package com.example.powerbisecuredb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.powerbisecuredb.Entity.Token;
import com.example.powerbisecuredb.Repository.TokenRepository;

import lombok.Data;

@Data
@Service
public class TokenService {
	private final TokenRepository tokenRepository;

	@Autowired
	public TokenService(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	public Token saveToken(Token token) {
		return tokenRepository.save(token);
	}
}
