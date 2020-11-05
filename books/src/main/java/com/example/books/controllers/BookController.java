package com.example.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.books.models.Book;
import com.example.books.services.BookService;

@Controller
public class BookController 
{
	private final BookService bookService;
	public BookController(BookService service)
	{
		this.bookService = service;
	}
	
	@GetMapping("/books")
	public String index(Model model)
	{
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	@GetMapping("/books/{id}")
	public String findBookByIndex(Model model, @PathVariable("id")Long id)
	{
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, BindingResult result)
	{
		return "/books/new.jsp";
	}
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book")Book book, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "/books/new.jsp";
		}
		else
		{
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id")Long id, Model model)
	{
		System.out.println(id);
		Book book = bookService.findBook(id);
		if(book != null)
		{
			model.addAttribute("book", book);
			return "/books/editBook.jsp";
		}
		else
		{
			
			return "redirect:/books/index";
		}
	}
}
