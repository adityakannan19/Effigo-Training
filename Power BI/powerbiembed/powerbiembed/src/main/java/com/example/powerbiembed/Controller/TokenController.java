package com.example.powerbiembed.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RestController
public class TokenController {

	@PostMapping("/add-token")
	public void addToken(@RequestBody TokenInfo tokenInfo) {
		TokenValidator.addValidToken(tokenInfo.getToken(), tokenInfo.getExpirationTime());
	}
}

@Data
@NoArgsConstructor
class TokenInfo {
	private String token;
	private long expirationTime;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

}
