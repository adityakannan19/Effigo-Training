package com.example.LearningPortal.dto;

import java.security.Timestamp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryDTO {
	private long categoryId;
	private String name;
	private Timestamp createdOn;
	private Timestamp updatedOn;
}
