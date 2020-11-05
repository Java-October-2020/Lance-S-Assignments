package com.example.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lookify.models.Song;
import com.example.lookify.services.SongService;

@Controller
public class IndexController 
{
	private final SongService songService;
	public IndexController(SongService service)
	{
		this.songService = service;
	}
	
	@RequestMapping("")
	public String index()
	{
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model)
	{
		List<Song> allSongs = this.songService.findAll();
		model.addAttribute("songs", allSongs);
		return "dashboard.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String viewSong(@PathVariable("id")Long id, Model model)
	{
		Song song = this.songService.findSong(id);
		model.addAttribute("song", song);
		return "songs.jsp";
	}
	@RequestMapping("/songs/new")
	public String addSongPage(@ModelAttribute("song")Song song)
	{
		return "new.jsp";
	}
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song")Song song, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return "new.jsp";
		}
		else
		{
			this.songService.add(song);
			return "redirect:/dashboard";
		}
	}
//	@RequestMapping(value="/songs/delete/{id}", method=RequestMethod.DELETE)
	@GetMapping("/songs/delete/{id}")
	public String delete(@PathVariable("id")Long id)
	{
		this.songService.delete(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("artist")String artist, Model model)
	{
		List<Song> songs = this.songService.songsContainingArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	@GetMapping("/search/topTen")
	public String topTen(Model model)
	{
		List<Song> topTen = this.songService.topTenByRating();
		model.addAttribute("topTen", topTen);
		return "topten.jsp";
	}
}
