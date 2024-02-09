package com.example.LearningPortal.service;

import java.util.List;

import com.example.LearningPortal.dto.CategoryDTO;

public interface CategoryService {
	CategoryDTO createCategory(CategoryDTO category);

	CategoryDTO getCategoryById(long id);

	List<CategoryDTO> getAllCategories();

	CategoryDTO updateCategory(CategoryDTO category);

	void deleteCategory(long id);
}
