package com.example.finalProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.finalProject.dto.courseDTO;
import com.example.finalProject.entity.courseEntity;

@Mapper(componentModel = "spring", uses = { categoryMapper.class, userMapper.class })
public interface courseMapper {
	courseMapper INSTANCE = Mappers.getMapper(courseMapper.class);

	@Mapping(target = "createdOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getUpdatedOn()))")
	@Mapping(source = "course.category.name", target = "category")
	courseDTO courseEntityToCourseDTO(courseEntity course);

	@Mapping(source = "category", target = "category.name")
	courseEntity courseDTOToCourseEntity(courseDTO courseDTO);
}
