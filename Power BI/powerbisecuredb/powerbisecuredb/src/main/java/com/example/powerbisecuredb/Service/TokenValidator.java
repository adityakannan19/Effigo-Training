package com.example.powerbisecuredb.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.powerbisecuredb.Entity.Token;
import com.example.powerbisecuredb.Repository.TokenRepository;

@Component
public class TokenValidator {
	private final TokenRepository tokenRepository;

	@Autowired
	public TokenValidator(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	public boolean isValidToken(String token) {
		Optional<Token> optionalToken = tokenRepository.findByToken(token);
		System.out.print(optionalToken);
		return optionalToken.isPresent() && !optionalToken.get().getExpirationTime().isBefore(LocalDateTime.now());
	}
}
