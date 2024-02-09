package com.example.LearningPortal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.dto.FavoriteDTO;
import com.example.LearningPortal.entity.FavoriteEntity;
import com.example.LearningPortal.mapper.FavoriteMapper;
import com.example.LearningPortal.repository.FavoriteRepository;
import com.example.LearningPortal.service.FavoriteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
	private FavoriteRepository favoriteRepository;
	private ModelMapper modelMapper;

	public FavoriteServiceImpl(FavoriteRepository favoriteRepository, ModelMapper modelMapper) {
		super();
		this.favoriteRepository = favoriteRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<FavoriteDTO> getAllFavorites() {
		List<FavoriteEntity> favorites = favoriteRepository.findAll();
		return favorites.stream().map((fav) -> FavoriteMapper.MAPPER.mapToFavoriteDto(fav))
				.collect(Collectors.toList());
	}

	@Override
	public FavoriteDTO getFavoriteById(long favid) {
		FavoriteEntity favorite = favoriteRepository.findById(favid).get();
		return FavoriteMapper.MAPPER.mapToFavoriteDto(favorite);
	}

	@Override
	public FavoriteDTO createFavorite(FavoriteDTO favDto) {

		FavoriteEntity fav = FavoriteMapper.MAPPER.mapToFavorite(favDto);

		FavoriteEntity savedFav = favoriteRepository.save(fav);

		FavoriteDTO savedFavDto = FavoriteMapper.MAPPER.mapToFavoriteDto(savedFav);

		return savedFavDto;
	}
}
