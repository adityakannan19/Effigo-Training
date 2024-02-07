package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.entity.enrollmentEntity;
import com.example.finalProject.repository.enrollmentRepository;

@Service
public class enrollmentService {
	@Autowired
	private enrollmentRepository enrollmentRepository;

	public enrollmentEntity saveEnrollment(enrollmentEntity enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	public enrollmentEntity getEnrollmentById(Long enrollmentId) {
		return enrollmentRepository.findById(enrollmentId).orElse(null);
	}

	public List<enrollmentEntity> getAllEnrollments() {
		return enrollmentRepository.findAll();
	}
}
