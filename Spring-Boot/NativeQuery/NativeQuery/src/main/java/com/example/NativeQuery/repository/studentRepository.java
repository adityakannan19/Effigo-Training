package com.example.NativeQuery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NativeQuery.entity.Students;

public interface studentRepository extends JpaRepository<Students, Long> {

}
