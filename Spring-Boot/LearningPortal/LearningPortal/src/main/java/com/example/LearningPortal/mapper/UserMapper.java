package com.example.LearningPortal.mapper;

import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.dto.UserDTO;
import com.example.LearningPortal.entity.UserEntity;

public interface UserMapper {
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	UserDTO mapToUserDto(UserEntity user);

	UserEntity mapToUser(UserDTO userDto);
}
