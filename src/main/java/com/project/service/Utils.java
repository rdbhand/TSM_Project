package com.project.service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public class Utils {

    private static final String HMAC_SHA256 = "HmacSHA256";

    public static String calculateRFC2104HMAC(String data, String secret) throws Exception {
        SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(), HMAC_SHA256);
        Mac mac = Mac.getInstance(HMAC_SHA256);
        mac.init(signingKey);

        return new String(Hex.encodeHex(mac.doFinal(data.getBytes())));
    }
}
