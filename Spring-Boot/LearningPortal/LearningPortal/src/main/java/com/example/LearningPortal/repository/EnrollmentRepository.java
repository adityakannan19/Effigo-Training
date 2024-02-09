package com.example.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.entity.EnrollmentEntity;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {

}
