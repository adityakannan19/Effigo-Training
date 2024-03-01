package com.example.learningportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.learningportal.controller", "com.example.learningportal.service",
		"com.example.learningportal.security" })
@EnableJpaRepositories(basePackages = { "com.example.LearningPortal.repository" })
public class LearningPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPortalApplication.class, args);
	}

}
