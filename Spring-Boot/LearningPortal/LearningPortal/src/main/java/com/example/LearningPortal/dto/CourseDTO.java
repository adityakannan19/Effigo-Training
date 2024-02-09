package com.example.LearningPortal.dto;

import java.security.Timestamp;

import com.example.LearningPortal.entity.CategoryEntity;
import com.example.LearningPortal.entity.UserEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CourseDTO {
	private long courseId;
	private String title;
	private String description;
	private UserEntity author;
	private CategoryEntity category;
	private Timestamp createdOn;
	private Timestamp updatedOn;
}
