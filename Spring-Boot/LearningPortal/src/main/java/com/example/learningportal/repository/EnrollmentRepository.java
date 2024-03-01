package com.example.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningportal.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
