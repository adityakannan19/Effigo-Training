package com.example.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
