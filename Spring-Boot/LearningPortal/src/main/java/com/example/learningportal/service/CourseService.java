package com.example.learningportal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.learningportal.entity.Course;
import com.example.learningportal.repository.CourseRepository;

import lombok.Data;

@Data
@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public Course saveCourse(Course course) {
		course.setCreatedOn(LocalDateTime.now());
		course.setUpdatedOn(LocalDateTime.now());
		return courseRepository.save(course);
	}

	public Course getCourseById(long courseId) {
		Optional<Course> courseOptional = courseRepository.findById(courseId);

		if (!courseOptional.isPresent()) {
			return null;
		}
		return courseOptional.get();
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course updateCourse(Long id, Course course) {
		Optional<Course> courseOptional = courseRepository.findById(id);
		if (courseOptional.isEmpty()) {
			return null;
		}

		Course updatedCourse = courseOptional.get();

		String title = (course.getTitle() == null) ? updatedCourse.getTitle() : course.getTitle();
		String description = (course.getDescription() == null) ? updatedCourse.getDescription()
				: course.getDescription();

		updatedCourse.setTitle(title);
		updatedCourse.setDescription(description);

		return courseRepository.save(updatedCourse);
	}

	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> GetAllJavaCourses(String name) {
		return courseRepository.findAllJavaCourses(name);
	}

}
