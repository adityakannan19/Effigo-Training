package com.example.LearningPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearningPortal.dto.UserDTO;
import com.example.LearningPortal.service.CategoryService;
import com.example.LearningPortal.service.CourseService;
import com.example.LearningPortal.service.EnrollmentService;
import com.example.LearningPortal.service.FavoriteService;
import com.example.LearningPortal.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LearningPortalController {
	@Autowired
	private UserService userService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private FavoriteService favoriteService;

	@GetMapping("/try")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

}
