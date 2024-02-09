package com.example.LearningPortal.service;

import java.util.List;

import com.example.LearningPortal.dto.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO user);

	UserDTO getUserById(long id);

	List<UserDTO> getAllUsers();

	UserDTO updateUser(UserDTO user);

	void deleteUser(long id);

}
