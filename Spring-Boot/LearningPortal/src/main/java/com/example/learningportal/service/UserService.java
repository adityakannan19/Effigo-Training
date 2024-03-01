package com.example.learningportal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.learningportal.entity.User;
import com.example.learningportal.repository.UserRepository;
import com.example.learningportal.security.SecurityConfig;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public User saveUser(User user) {
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());

		String plainPassword = user.getPassword();
		String hashedPassword = SecurityConfig.hashPassword(plainPassword);
		user.setPassword(hashedPassword);

		return userRepository.save(user);

	}

	public User updateUser(long id, User user) {
		String plainPassword = user.getPassword();
		if (plainPassword != null) {
			String hashedPassword = SecurityConfig.hashPassword(plainPassword);
			user.setPassword(hashedPassword);
		}
		user.setUpdatedOn(LocalDateTime.now());
		return userRepository.save(user);
	}

	public User getUserById(long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
