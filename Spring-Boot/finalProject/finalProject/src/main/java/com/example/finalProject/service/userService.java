package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.finalProject.dto.userDTO;
import com.example.finalProject.entity.userEntity;

@Service
public class userService {

	@Autowired
	private com.example.finalProject.mapper.userMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void createUser(userDTO userDTO) {
		userEntity user = userMapper.userDTOToUserEntity(userDTO);
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		userRepository.save(user);
	}

	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Autowired
	private com.example.finalProject.repository.userRepository userRepository;

	public userEntity saveUser(userEntity user) {
		return userRepository.save(user);
	}

	public userEntity getUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public List<userEntity> getAllUsers() {
		return userRepository.findAll();
	}
}
