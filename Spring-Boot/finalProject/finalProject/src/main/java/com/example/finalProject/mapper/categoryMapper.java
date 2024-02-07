package com.example.finalProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.example.finalProject.dto.categoryDTO;
import com.example.finalProject.entity.categoryEntity;

@Mapper(componentModel = "spring")
public interface categoryMapper {
	categoryMapper INSTANCE = Mappers.getMapper(categoryMapper.class);

	@Mappings({
			@Mapping(target = "createdOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getCreatedOn()))"),
			@Mapping(target = "updatedOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getUpdatedOn()))") })
	categoryDTO categoryEntityToCategoryDTO(categoryEntity category);

	categoryEntity categoryDTOToCategoryEntity(categoryDTO categoryDTO);
}
