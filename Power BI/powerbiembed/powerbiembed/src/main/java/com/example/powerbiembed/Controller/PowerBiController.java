package com.example.powerbiembed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PowerBiController {

	@GetMapping
	String GetBi() {
		return "dashboard";
	}
}
