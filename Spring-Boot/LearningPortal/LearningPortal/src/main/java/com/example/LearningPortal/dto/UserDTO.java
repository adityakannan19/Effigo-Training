package com.example.LearningPortal.dto;

import java.security.Timestamp;
import java.util.Set;

import com.example.LearningPortal.entity.Roles;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDTO {
	private long userID;
	private String username;
	private String password;
	private String role;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	private boolean enabled;
	private Set<Roles> roles;
}
