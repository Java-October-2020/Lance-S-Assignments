package com.example.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.books.models.Book;
import com.example.books.repositories.BookRepository;

@Service
public class BookService 
{
	//Repo injection
	private BookRepository bookRepo;
	public BookService(BookRepository repo)
	{
		this.bookRepo = repo;
	}
	
	//Service Methods
	public List<Book> allBooks()
	{
		return bookRepo.findAll();
	}
	
	public Book createBook(Book b)
	{
		return bookRepo.save(b);
	}
	
	public Book findBook(Long id)
	{
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent())
		{
			return optionalBook.get();
		}
		else
		{
			return null;
		}
	}
	
	public void updateBook(Long id, Book book)
	{
		
	}
}
