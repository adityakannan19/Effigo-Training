package com.example.LearningPortal.mapper;

import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.CategoryDTO;
import com.example.LearningPortal.entity.CategoryEntity;

public interface CategoryMapper {
	CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

	CategoryDTO mapToCategoryDto(CategoryEntity category);

	CategoryEntity mapToCategory(CategoryDTO categoryDto);
}
