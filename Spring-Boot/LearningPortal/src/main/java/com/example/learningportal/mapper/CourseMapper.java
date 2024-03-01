package com.example.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.learningportal.dto.CourseDto;
import com.example.learningportal.entity.Course;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class, UserMapper.class })
public interface CourseMapper {

	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

	@Mapping(source = "course.author.userId", target = "authorId")
	@Mapping(source = "course.category.name", target = "category")
	CourseDto courseToCourseDTO(Course course);

	Course courseDTOToCourse(CourseDto courseDTO);

}
