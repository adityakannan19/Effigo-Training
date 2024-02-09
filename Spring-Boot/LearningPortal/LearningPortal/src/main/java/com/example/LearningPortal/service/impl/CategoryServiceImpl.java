package com.example.LearningPortal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.dto.CategoryDTO;
import com.example.LearningPortal.entity.CategoryEntity;
import com.example.LearningPortal.mapper.CategoryMapper;
import com.example.LearningPortal.repository.CategoryRepository;
import com.example.LearningPortal.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepository;
	private ModelMapper modelMapper;

	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {

		CategoryEntity category = CategoryMapper.MAPPER.mapToCategory(categoryDto);

		CategoryEntity savedCategory = categoryRepository.save(category);

		CategoryDTO savedCategoryDto = CategoryMapper.MAPPER.mapToCategoryDto(savedCategory);

		return savedCategoryDto;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<CategoryEntity> categories = categoryRepository.findAll();
		return categories.stream().map((category) -> CategoryMapper.MAPPER.mapToCategoryDto(category))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteCategory(long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO category) {

		CategoryEntity existingCategory = categoryRepository.findById(category.getCategoryId()).get();
		existingCategory.setName(category.getName());
		CategoryEntity updatedCategory = categoryRepository.save(existingCategory);
		return CategoryMapper.MAPPER.mapToCategoryDto(updatedCategory);
	}

	@Override
	public CategoryDTO getCategoryById(long categoryid) {
		CategoryEntity category = categoryRepository.findById(categoryid).get();
		return CategoryMapper.MAPPER.mapToCategoryDto(category);
	}

}
