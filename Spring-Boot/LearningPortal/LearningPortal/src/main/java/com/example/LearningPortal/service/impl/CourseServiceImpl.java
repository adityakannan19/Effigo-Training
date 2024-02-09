package com.example.LearningPortal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.dto.CourseDTO;
import com.example.LearningPortal.entity.CourseEntity;
import com.example.LearningPortal.mapper.CourseMapper;
import com.example.LearningPortal.repository.CourseRepository;
import com.example.LearningPortal.service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
	private CourseRepository courseRepository;
	private ModelMapper modelMapper;

	public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
		super();
		this.courseRepository = courseRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CourseDTO createCourse(CourseDTO courseDto) {

		CourseEntity course = CourseMapper.MAPPER.mapToCourse(courseDto);

		CourseEntity savedCourse = courseRepository.save(course);

		CourseDTO savedCourseDto = CourseMapper.MAPPER.mapToCourseDto(savedCourse);

		return savedCourseDto;
	}

	@Override
	public List<CourseDTO> getAllCourses() {
		List<CourseEntity> courses = courseRepository.findAll();
		return courses.stream().map((course) -> CourseMapper.MAPPER.mapToCourseDto(course))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteCourse(long courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public CourseDTO updateCourse(CourseDTO course) {

		CourseEntity existingCourse = courseRepository.findById(course.getCourseId()).get();

		existingCourse.setAuthor(course.getAuthor());
		existingCourse.setCategory(course.getCategory());
		existingCourse.setDescription(course.getDescription());
		existingCourse.setTitle(course.getTitle());
		CourseEntity updatedCourse = courseRepository.save(existingCourse);
		return CourseMapper.MAPPER.mapToCourseDto(updatedCourse);
	}

	@Override
	public CourseDTO getCourseById(long courseid) {
		CourseEntity course = courseRepository.findById(courseid).get();
		return CourseMapper.MAPPER.mapToCourseDto(course);
	}

}
