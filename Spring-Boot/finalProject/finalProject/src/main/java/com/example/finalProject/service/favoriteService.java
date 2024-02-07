package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.entity.favoriteEntity;

@Service
public class favoriteService {
	@Autowired
	private com.example.finalProject.repository.favoriteRepository favoriteRepository;

	public favoriteEntity saveFavorite(favoriteEntity favorite) {
		return favoriteRepository.save(favorite);
	}

	public favoriteEntity getFavoriteById(Long favoriteId) {
		return favoriteRepository.findById(favoriteId).orElse(null);
	}

	public List<favoriteEntity> getAllFavorites() {
		return favoriteRepository.findAll();
	}
}
