package com.example.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.learningportal.dto.CategoryDto;
import com.example.learningportal.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	CategoryDto categoryToCategoryDTO(Category category);

	Category categoryDTOToCategory(CategoryDto categoryDTO);

}
