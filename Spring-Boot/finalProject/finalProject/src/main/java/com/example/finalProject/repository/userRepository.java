package com.example.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.entity.userEntity;

public interface userRepository extends JpaRepository<userEntity, Long> {
	userEntity findByUsername(String username);

	@org.springframework.data.jpa.repository.Query(value = "SELECT u.*, c.* FROM user u INNER JOIN course c ON u.id = c.user_id", nativeQuery = true)
	List<Object[]> joinUserAndCourse();

	boolean existsByUsername(String username);
}
