package com.example.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lookify.models.Song;
import com.example.lookify.repositories.SongRepository;

@Service
public class SongService 
{
	private final SongRepository songRepo;
	public SongService(SongRepository repo)
	{
		this.songRepo = repo;
	}
	
	public List<Song> findAll()
	{
		List<Song> allSongs = this.songRepo.findAll();
		return allSongs;
	}
	
	public Song findSong(Long id)
	{
		return this.songRepo.findById(id).orElse(null);
	}
	
	public Song add(Song song)
	{
		return this.songRepo.save(song);
	}
	
	public void delete(Long id)
	{
		this.songRepo.deleteById(id);
	}
	
	public List<Song> songsContainingArtist(String artist)
	{
		return this.songRepo.findByArtistContaining(artist);
	}
	
	public List<Song> topTenByRating()
	{
		return this.songRepo.findTop10ByOrderByRatingDesc();
	}
}
