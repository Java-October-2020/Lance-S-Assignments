package com.example.books.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@Size(min = 2, max = 200)
	private String title;
	@Column
	@Size(min = 2, max = 200)
	private String description;
	@Column
	@Size(min = 2, max = 40)
	private String language;
	@Column
	@Min(20)
	private int pages;
	
	@Column(updatable = false) 
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	//Constructors
	public Book()
	{
		
	}
	
	public Book(String title, String description, String language, int pages)
	{
		this.title = title;
		this.description = description;
		this.language = language;
		this.pages = pages;
	}
	
	@PrePersist
	protected void onCreate()
	{
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt = new Date();
	}
	
	//*Getter and Setters*
	//ID
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	//Title
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	//Description
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	//Language
	public String getLanguage() 
	{
		return language;
	}
	public void setLanguage(String language) 
	{
		this.language = language;
	}
	//Pages
	public int getPages() 
	{
		return pages;
	}
	public void setPages(int pages) 
	{
		this.pages = pages;
	}
}
