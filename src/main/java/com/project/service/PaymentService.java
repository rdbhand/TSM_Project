package com.project.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    public Map<String, Object> createOrder(int amount) throws Exception {

        // Razorpay requires amount in paise
        int finalAmount = amount * 100;

        RazorpayClient client = new RazorpayClient(keyId, keySecret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", finalAmount);
        orderRequest.put("currency", "INR");
        orderRequest.put("payment_capture", 1);

        Order order = client.orders.create(orderRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", order.get("id"));
        response.put("amount", finalAmount);
        response.put("currency", "INR");

        return response;
    }

    public boolean verifySignature(String orderId, String paymentId, String signature) {
        try {
            String data = orderId + "|" + paymentId;
            String expectedSignature = Utils.calculateRFC2104HMAC(data, keySecret);

            return expectedSignature.equals(signature);
        } catch (Exception e) {
            return false;
        }
    }
}
