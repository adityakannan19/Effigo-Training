package com.example.LearningPortal.service;

import java.util.List;

import com.example.LearningPortal.dto.EnrollmentDTO;

public interface EnrollmentService {
	EnrollmentDTO createEnrollment(EnrollmentDTO enrollment);

	EnrollmentDTO getEnrollmentById(long id);

	List<EnrollmentDTO> getAllEnrollments();
}
