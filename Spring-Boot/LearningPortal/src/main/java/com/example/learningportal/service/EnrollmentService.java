package com.example.learningportal.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.learningportal.entity.Enrollment;
import com.example.learningportal.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	public EnrollmentService(EnrollmentRepository enrollmentRepository) {
		super();
		this.enrollmentRepository = enrollmentRepository;
	}

	private EnrollmentRepository enrollmentRepository;

	public Enrollment enrollment(Enrollment enrollment) {

		enrollment.setCreatedOn(LocalDateTime.now());
		enrollment.setUpdatedOn(LocalDateTime.now());
		return enrollmentRepository.save(enrollment);

	}

}
