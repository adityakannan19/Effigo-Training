package com.example.powerbisecuredb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.powerbisecuredb.Service.TokenValidator;

import lombok.Data;

@Data
@Controller
public class ReportController {
	private final TokenValidator tokenValidator;

	@Autowired
	public ReportController(TokenValidator tokenValidator) {
		this.tokenValidator = tokenValidator;
	}

	@GetMapping("/embed-report")
	public String showForm() {
		return "dashboard";
	}

	@GetMapping("/validate-token")
	public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
		if (tokenValidator.isValidToken(token)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
