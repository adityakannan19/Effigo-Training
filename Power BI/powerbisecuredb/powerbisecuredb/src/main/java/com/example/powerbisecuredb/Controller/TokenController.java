package com.example.powerbisecuredb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.powerbisecuredb.Entity.Token;
import com.example.powerbisecuredb.Service.TokenService;

import lombok.Data;

@Data
@RestController
public class TokenController {
	private final TokenService tokenService;

	@Autowired
	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@PostMapping("/add-token")
	public Token addToken(@RequestBody Token token) {
		return tokenService.saveToken(token);
	}
}
