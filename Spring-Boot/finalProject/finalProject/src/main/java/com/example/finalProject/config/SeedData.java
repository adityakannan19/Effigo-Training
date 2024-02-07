package com.example.finalProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.finalProject.dto.userDTO;

@Component
public class SeedData {
	@Autowired
	private com.example.finalProject.service.userService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void run(ApplicationArguments args) throws Exception {

		if (!userService.existsByUsername("admin")) {
			userDTO adminUser = new userDTO();
			adminUser.setUsername("admin");
			adminUser.setPassword(passwordEncoder.encode("Aditya")); // Encode password
			adminUser.setRole("ADMIN");
			userService.createUser(adminUser);
		}
	}
}
