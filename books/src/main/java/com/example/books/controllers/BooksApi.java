package com.example.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.models.Book;
import com.example.books.services.BookService;

@RestController
public class BooksApi 
{
	private final BookService bookService;
	public BooksApi(BookService service)
	{
		this.bookService = service;
	}
	@RequestMapping("/api/books")
	//SKETCH platform had a lowercase "book" in List<>
	public List<Book> Index()
	{
		return bookService.allBooks();
	}
	@PostMapping("/api/books")
	public Book create(@RequestParam(value = "title")String title, 
				@RequestParam(value = "description")String description, 
				@RequestParam(value = "language")String language,
				@RequestParam(value = "pages")int pages)
	{
		Book b = new Book(title, description, language, pages);
		return bookService.createBook(b);
	}
	@GetMapping("/api/books/{id}")
	public Book show(@PathVariable("id")Long id)
	{
		Book book = bookService.findBook(id);
		return book;
	}
	@PutMapping("/api/books/{id}")
	public Book update(@PathVariable(value = "id")Long id ,@RequestParam(value = "title")String title, 
			@RequestParam(value = "description")String description, 
			@RequestParam(value = "language")String language,
			@RequestParam(value = "pages")int pages)
	{
		return null;
	}
}
