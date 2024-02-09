package com.example.LearningPortal.service;

import java.util.List;

import com.example.LearningPortal.dto.CourseDTO;

public interface CourseService {
	List<CourseDTO> getAllCourses();

	void deleteCourse(long id);

	CourseDTO createCourse(CourseDTO courseDTO);

	CourseDTO updateCourse(CourseDTO courseDTO);

	CourseDTO getCourseById(long id);
}
