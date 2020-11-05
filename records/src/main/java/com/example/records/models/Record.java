package com.example.records.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "records")
public class Record 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=1, max=50)
	private String artistName;
	@NotEmpty
	private String albumName;
	@NotNull
	private int year; 
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

	//Constructor
	public Record()
	{
		
	}
	
	public Record(String name, String artistName, int year)
	{
		this.albumName = name;
		this.artistName = artistName;
		this.year = year;
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


	public String getArtistName() 
	{
		return artistName;
	}


	public void setArtistName(String artistName) 
	{
		this.artistName = artistName;
	}


	public String getAlbumName() 
	{
		return albumName;
	}

	public void setAlbumName(String albumName) 
	{
		this.albumName = albumName;
	}


	public int getYear() 
	{
		return year;
	}


	public void setYear(int year) 
	{
		this.year = year;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
