package com.example.records.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.records.models.Record;
import com.example.records.services.RecordService;

@Controller
public class HomeController 
{
//	private RecordService rService;
//	
//	public HomeController(RecordService service)
//	{
//		this.rService = service;
//	}
	
	@Autowired
	private RecordService rService;
	
	@GetMapping("/")
	public String index(Model model)
	{
		List<Record> record = this.rService.getAllRecords();
		model.addAttribute("allRecords", record);
		return "index.jsp";
	}
	
	//Non JPA Way
	@PostMapping("/addOldWay")
	public String addAlbum(@RequestParam("albumName") String albumName, @RequestParam("artistName") String artistName, @RequestParam("year") int year, RedirectAttributes redirect)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if(artistName.equals(""))
		{
			errors.add("You forgot an artist name");
		}
		if(errors.size() > 0)
		{
			for(String e: errors)
			{
				redirect.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		this.rService.createRecord(albumName, artistName, year);
		return "redirect:/";
	}
	//New way with JPA validations
	@PostMapping("/add")
	public String addNewAlbum(@Valid @ModelAttribute("record") Record newRecord, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "add.jsp";
		}
		else
		{
			this.rService.createRecord(newRecord);
			return "redirect:/";
		}
	}
	
	@GetMapping("/{id}")
	public String add(@ModelAttribute("record") Record record)
	{
		return "add.jsp";
	}
}
