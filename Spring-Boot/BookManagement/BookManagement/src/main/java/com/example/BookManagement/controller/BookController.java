package com.example.BookManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookManagement.entity.book;
import com.example.BookManagement.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping
	public List<book> findAllBooks() {
		return bookService.findAllBooks();
	}

	@GetMapping("/{id}")
	public Optional<book> findBookById(@PathVariable("id") long id) {
		return bookService.findbyId(id);
	}

	@PostMapping
	public book saveBook(@RequestBody book b) {
		return bookService.saveBook(b);
	}

	@PutMapping
	public book updateBook(@RequestBody book b) {
		return bookService.updateBook(b);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
	}

}
