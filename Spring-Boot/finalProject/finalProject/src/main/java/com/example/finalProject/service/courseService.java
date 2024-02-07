package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.dto.courseDTO;
import com.example.finalProject.entity.courseEntity;

@Service
public class courseService {

	@Autowired
	private com.example.finalProject.mapper.courseMapper courseMapper;

	public void createCourse(courseDTO courseDTO) {
		courseEntity course = courseMapper.courseDTOToCourseEntity(courseDTO);
		courseRepository.save(course);
	}

	@Autowired
	private com.example.finalProject.repository.courseRepository courseRepository;

	public courseEntity saveCourse(courseEntity course) {
		return courseRepository.save(course);
	}

	public courseEntity getCourseById(Long courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}

	public List<courseEntity> getAllCourses() {
		return courseRepository.findAll();
	}
}
