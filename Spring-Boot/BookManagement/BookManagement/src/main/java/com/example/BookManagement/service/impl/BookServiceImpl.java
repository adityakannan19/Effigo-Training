package com.example.BookManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.BookManagement.entity.book;
import com.example.BookManagement.repository.BookRepository;
import com.example.BookManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<book> findbyId(long id) {
		return bookRepository.findById(id);
	}

	@Override
	public book saveBook(book b) {
		return bookRepository.save(b);
	}

	@Override
	public book updateBook(book b) {
		return bookRepository.save(b);
	}

	@Override
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}

}
