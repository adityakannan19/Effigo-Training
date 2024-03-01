package com.example.learningportal.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req -> req.requestMatchers("api/**").permitAll().anyRequest().anonymous())
				.build();
	}

	public static String hashPassword(String plainPassword) {
		try {
			// Creating a MessageDigest instance for SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hashedBytes = digest.digest(plainPassword.getBytes());

			// Converting the byte array to a hexadecimal string
			StringBuilder stringBuilder = new StringBuilder();
			for (byte b : hashedBytes) {
				stringBuilder.append(String.format("%02x", b));
			}
			return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean verifyPassword(String plainPassword, String hashedPassword) {
		String hashedPlainPassword = hashPassword(plainPassword); // Hash the plain password
		return hashedPlainPassword != null && hashedPlainPassword.equals(hashedPassword); // Compare the hashed passwords
	}

}
