package com.example.powerbiembed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PowerBiController {

	@GetMapping("/embed-report")
	public String embedReport(@RequestParam("token") String token, Model model) {
		System.out.print(TokenValidator.getValidTokens());
		if (TokenValidator.isValidToken(token)) {
			model.addAttribute("token", token);
			return "dashboard";

		} else {
			return "error";
		}
	}
}
