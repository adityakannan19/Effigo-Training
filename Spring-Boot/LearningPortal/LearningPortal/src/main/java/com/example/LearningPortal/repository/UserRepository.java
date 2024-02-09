package com.example.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.LearningPortal.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	@Query("SELECT u FROM UserEntity u WHERE u.username = :username")
	public UserEntity getUserByUsername(@Param("username") String username);
}
