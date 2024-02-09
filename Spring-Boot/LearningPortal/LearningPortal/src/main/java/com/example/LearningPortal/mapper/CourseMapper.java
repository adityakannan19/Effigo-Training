package com.example.LearningPortal.mapper;

import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.CourseDTO;
import com.example.LearningPortal.entity.CourseEntity;

public interface CourseMapper {
	CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

	CourseDTO mapToCourseDto(CourseEntity course);

	CourseEntity mapToCourse(CourseDTO courseDto);
}
