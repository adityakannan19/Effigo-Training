package com.example.powerbiembed.Controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class TokenValidator implements InitializingBean {
	private static Map<String, Long> validTokens = new HashMap<>();

	@Override
	public void afterPropertiesSet() {
		// Add initial tokens with expiration times (e.g., 1 hour from now)
		addValidToken("INITIAL_TOKEN_1", LocalDateTime.now().plusHours(10).toEpochSecond(ZoneOffset.UTC) * 1000);
		addValidToken("INITIAL_TOKEN_2", LocalDateTime.now().plusHours(20).toEpochSecond(ZoneOffset.UTC) * 1000);
	}

	public static void addValidToken(String token, long expirationTime) {
		validTokens.put(token, expirationTime);
	}

	public static boolean isValidToken(String token) {
		// Check if the token exists in the database
		if (!validTokens.containsKey(token)) {
			return false;
		}

		// Check if the token has expired
		long expirationTime = validTokens.get(token);
		if (expirationTime < System.currentTimeMillis()) {
			// Token has expired
			validTokens.remove(token); // Remove the expired token from the database
			return false;
		}

		// Token is valid
		return true;

	}

	public static Map<String, Long> getValidTokens() {
		return validTokens;
	}

	public static void setValidTokens(Map<String, Long> validTokens) {
		TokenValidator.validTokens = validTokens;
	}
}
