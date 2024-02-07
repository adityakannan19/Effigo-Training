package com.example.finalProject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.finalProject.dto.userDTO;
import com.example.finalProject.entity.userEntity;

@Mapper(componentModel = "spring")
public interface userMapper {
	userMapper INSTANCE = Mappers.getMapper(userMapper.class);

	@Mapping(target = "createdOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn", expression = "java(dateTimeFormatter.formatTimestamp(user.getUpdatedOn()))")
	@Mapping(source = "user.role", target = "role")
	userDTO userEntityToUserDTO(userEntity user);

	userEntity userDTOToUserEntity(userDTO userDTO);
}
