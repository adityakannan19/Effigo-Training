package com.example.NativeQuery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NativeQuery.repository.streamRepository;

@RestController
public class joinController {
	@Autowired
	private streamRepository streamRepository;

	@GetMapping("/join")
	public java.util.List<Object[]> joinTables() {
		return streamRepository.getJoinedData();
	}
}
