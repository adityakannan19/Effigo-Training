package com.example.LearningPortal.dto;

import java.security.Timestamp;

import com.example.LearningPortal.entity.CourseEntity;
import com.example.LearningPortal.entity.UserEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EnrollmentDTO {
	private long enrollmentId;
	private UserEntity learner;
	private CourseEntity course;
	private Timestamp createdOn;
	private Timestamp updatedOn;
}
