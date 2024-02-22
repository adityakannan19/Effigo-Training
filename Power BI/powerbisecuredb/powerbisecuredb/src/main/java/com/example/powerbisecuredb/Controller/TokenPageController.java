package com.example.powerbisecuredb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TokenPageController {
	@GetMapping("/add-token-page")
	public String showAddTokenPage() {
		return "add-token";
	}
}
