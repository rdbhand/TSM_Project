package com.project.controllers;

import com.project.model.PaymentRecord;
import com.project.repository.PaymentRecordRepository;
import com.project.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-order")
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> request) throws Exception {
        int amount = (int) request.get("amount");  // amount in rupees
        return paymentService.createOrder(amount);
    }

    @Autowired
    private PaymentRecordRepository repo;

    @PostMapping("/verify")
    public Map<String, Object> verifyPayment(@RequestBody Map<String, Object> request) {

        String orderId = (String) request.get("razorpay_order_id");
        String paymentId = (String) request.get("razorpay_payment_id");
        String signature = (String) request.get("razorpay_signature");

        boolean isValid = paymentService.verifySignature(orderId, paymentId, signature);

        PaymentRecord record = new PaymentRecord();
        record.setOrderId(orderId);
        record.setPaymentId(paymentId);
        record.setSignature(signature);
        record.setStatus(isValid ? "SUCCESS" : "FAILED");

        repo.save(record);

        return Map.of("status", isValid ? "success" : "failed");
    }

}
