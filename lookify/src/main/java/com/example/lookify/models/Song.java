package com.example.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "lookify_songs")
public class Song 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 50)
	private String name;
	@Size(min = 5, max = 50)
	private String artist;
	@Min(1)
	@Max(10)
	private int rating;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	
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
	
	//Constructors
	public Song()
	{
		
	}
	
	public Song(String name, String artist, int rating)
	{
		this.name = name;
		this.artist = artist; 
		this.rating = rating;
	}
	
	//Getters and Setters
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getArtist() 
	{
		return artist;
	}
	public void setArtist(String artist) 
	{
		this.artist = artist;
	}
	public int getRating() 
	{
		return rating;
	}
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	public Date getCreatedAt() 
	{
		return createdAt;
	}
	public Date getUpdatedAt() 
	{
		return updatedAt;
	}
}
