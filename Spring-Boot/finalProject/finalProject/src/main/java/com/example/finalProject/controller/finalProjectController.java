package com.example.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.dto.userDTO;
import com.example.finalProject.entity.courseEntity;
import com.example.finalProject.service.courseService;
import com.example.finalProject.service.enrollmentService;

@RestController
@RequestMapping("/api")
public class finalProjectController {
	@Autowired
	private com.example.finalProject.service.userService userService;

	@Autowired
	private courseService courseService;

	@Autowired
	private com.example.finalProject.service.categoryService categoryService;

	@Autowired
	private enrollmentService enrollmentService;

	@Autowired
	private com.example.finalProject.service.favoriteService favoriteService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin/createUser")
	public ResponseEntity<String> createUser(@RequestBody userDTO userDTO) {
		userService.createUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
	}

	@PreAuthorize("hasRole('AUTHOR')")
	@PostMapping("/author/createCourse")
	public ResponseEntity<String> createCourse(@RequestBody com.example.finalProject.dto.courseDTO courseDTO) {
		courseService.createCourse(courseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Course created successfully");
	}

	@PreAuthorize("hasAnyRole('AUTHOR', 'LEARNER')")
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<courseEntity> getCourseById(@PathVariable Long courseId) {
		courseEntity courseDTO = courseService.getCourseById(courseId);
		if (courseDTO != null) {
			return ResponseEntity.ok(courseDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
