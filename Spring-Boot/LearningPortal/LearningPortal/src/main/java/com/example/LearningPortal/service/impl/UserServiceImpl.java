package com.example.LearningPortal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.dto.UserDTO;
import com.example.LearningPortal.entity.UserEntity;
import com.example.LearningPortal.mapper.UserMapper;
import com.example.LearningPortal.repository.UserRepository;
import com.example.LearningPortal.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Override
	public UserDTO getUserById(long id) {
		UserEntity user = userRepository.findById(id).get();
		//return UserMapper.mapToUserDto(user);
		//return modelMapper.map(user, UserDto.class);
		return UserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public UserDTO createUser(UserDTO userDto) {

		// Convert UserDto into User JPA Entity
		// User user = UserMapper.mapToUser(userDto);

		//User user = modelMapper.map(userDto, User.class);

		UserEntity user = UserMapper.MAPPER.mapToUser(userDto);

		UserEntity savedUser = userRepository.save(user);

		// Convert User JPA entity to UserDto
		//UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

		//UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

		UserDTO savedUserDto = UserMapper.MAPPER.mapToUserDto(savedUser);

		return savedUserDto;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<UserEntity> users = userRepository.findAll();
		//        return users.stream().map(UserMapper::mapToUserDto)
		//                .collect(Collectors.toList());

		//        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
		//                .collect(Collectors.toList());

		return users.stream().map((user) -> UserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(UserDTO user) {

		UserEntity existingUser = userRepository.findById(user.getUserID()).get();

		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		UserEntity updatedUser = userRepository.save(existingUser);
		//return UserMapper.mapToUserDto(updatedUser);
		//return modelMapper.map(updatedUser, UserDto.class);
		return UserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(long userId) {

		userRepository.deleteById(userId);
	}

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
}
