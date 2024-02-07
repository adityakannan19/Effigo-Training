package com.example.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.entity.courseEntity;

public interface courseRepository extends JpaRepository<courseEntity, Long> {

}
