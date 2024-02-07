package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
	@Autowired
	private com.example.finalProject.repository.userRepository userRepository;

	public List<Object[]> joinUserAndCourse() {
		return userRepository.joinUserAndCourse();
	}
}
