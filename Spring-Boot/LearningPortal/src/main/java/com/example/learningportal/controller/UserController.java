package com.example.learningportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningportal.entity.User;
import com.example.learningportal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	private UserService userService;

	@GetMapping
	public List<User> findAllUsers() {

		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {

		return userService.findById(id);
	}

	@PostMapping
	public User saveUsers(@RequestBody User userToSave) {

		return userService.saveUser(userToSave);
	}

	@PutMapping("/{id}")
	public User updateUsers(@PathVariable Long id, @RequestBody User userToUpdate) {

		return userService.updateUser(id, userToUpdate);
	}
}
