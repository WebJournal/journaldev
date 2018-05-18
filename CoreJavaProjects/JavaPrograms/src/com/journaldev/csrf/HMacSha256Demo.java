package com.journaldev.csrf;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMacSha256Demo {

	private static final String SECRET_KEY = "abcdefgh1234567890";
	
	public static void main(String[] args) {
		final Charset asciiCs = Charset.forName("US-ASCII");
        try {
			final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			final SecretKeySpec secret_key = new javax.crypto.spec.SecretKeySpec(asciiCs.encode(SECRET_KEY).array(), "HmacSHA256");
			sha256_HMAC.init(secret_key);
			
			long timestamp = System.currentTimeMillis();
			byte[] data = (timestamp + SECRET_KEY).getBytes();
			final byte[] mac_data = sha256_HMAC.doFinal(data);
			System.out.println("Token="+mac_data);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			e.printStackTrace();
		}
	}

}
