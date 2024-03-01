package com.example.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.learningportal.dto.FavoriteDto;
import com.example.learningportal.entity.Favorite;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

	FavoriteMapper INSTANCE = Mappers.getMapper(FavoriteMapper.class);

	@Mapping(source = "favorite.learner.userId", target = "learnerId")
	FavoriteDto favoriteToFavoriteDTO(Favorite favorite);

	Favorite favoriteDTOToFavorite(FavoriteDto favoriteDTO);

}
