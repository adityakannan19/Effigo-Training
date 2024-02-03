package com.example.BookManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookManagement.entity.book;

@Repository
public interface BookRepository extends JpaRepository<book, Long> {

}
