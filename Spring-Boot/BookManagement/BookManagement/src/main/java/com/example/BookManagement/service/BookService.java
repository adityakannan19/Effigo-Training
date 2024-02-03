package com.example.BookManagement.service;

import java.util.List;
import java.util.Optional;

import com.example.BookManagement.entity.book;

public interface BookService {
	List<book> findAllBooks();

	Optional<book> findbyId(long id);

	book saveBook(book b);

	book updateBook(book b);

	void deleteBook(long id);

}
