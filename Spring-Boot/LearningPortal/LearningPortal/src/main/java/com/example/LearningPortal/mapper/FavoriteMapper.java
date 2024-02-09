package com.example.LearningPortal.mapper;

import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.FavoriteDTO;
import com.example.LearningPortal.entity.FavoriteEntity;

public interface FavoriteMapper {
	FavoriteMapper MAPPER = Mappers.getMapper(FavoriteMapper.class);

	FavoriteDTO mapToFavoriteDto(FavoriteEntity favorite);

	FavoriteEntity mapToFavorite(FavoriteDTO favoriteDto);
}
