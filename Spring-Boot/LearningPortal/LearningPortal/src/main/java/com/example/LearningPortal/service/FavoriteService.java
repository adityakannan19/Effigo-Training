package com.example.LearningPortal.service;

import java.util.List;

import com.example.LearningPortal.dto.FavoriteDTO;

public interface FavoriteService {
	FavoriteDTO createFavorite(FavoriteDTO fav);

	FavoriteDTO getFavoriteById(long id);

	List<FavoriteDTO> getAllFavorites();
}
