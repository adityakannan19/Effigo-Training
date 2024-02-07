package com.example.finalProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.finalProject.dto.favoriteDTO;
import com.example.finalProject.entity.favoriteEntity;

@Mapper(componentModel = "spring", uses = { userMapper.class, courseMapper.class })
public interface favoriteMapper {
	favoriteMapper INSTANCE = Mappers.getMapper(favoriteMapper.class);

	@Mapping(target = "createdOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getUpdatedOn()))")
	@Mapping(source = "favorite.learner.userId", target = "learnerId")
	favoriteDTO favoriteToFavoriteDTO(favoriteEntity favorite);

	favoriteEntity favoriteDTOToFavorite(favoriteDTO favoriteDTO);
}
