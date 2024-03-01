package com.example.learningportal.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.learningportal.entity.Favorite;
import com.example.learningportal.repository.FavoriteRepository;

@Service
public class FavoriteService {

	private FavoriteRepository favoriteRepository;

	FavoriteService(FavoriteRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository;
	}

	public Favorite favourite(Favorite favourite) {
		favourite.setCreatedOn(LocalDateTime.now());
		favourite.setUpdatedOn(LocalDateTime.now());
		return favoriteRepository.save(favourite);

	}

}
