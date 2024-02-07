package com.example.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalProject.entity.favoriteEntity;

public interface favoriteRepository extends JpaRepository<favoriteEntity, Long> {

}
