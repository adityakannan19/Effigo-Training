package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.entity.categoryEntity;

@Service
public class categoryService {
	@Autowired
	private com.example.finalProject.repository.categoryRepository categoryRepository;

	public categoryEntity saveCategory(categoryEntity category) {
		return categoryRepository.save(category);
	}

	public categoryEntity getCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}

	public List<categoryEntity> getAllCategories() {
		return categoryRepository.findAll();
	}

}
