package com.example.learningportal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.learningportal.dto.UserDto;
import com.example.learningportal.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(source = "user.role", target = "role")
	UserDto userToUserDTO(User user);

	User userDTOToUser(UserDto userDTO);

}
