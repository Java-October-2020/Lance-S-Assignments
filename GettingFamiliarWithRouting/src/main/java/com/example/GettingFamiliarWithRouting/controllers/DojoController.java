package com.example.GettingFamiliarWithRouting.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/dojo")
public class DojoController 
{
	@RequestMapping("/")
	public String codingHome()
	{
		return "The dojo is awesome!";
	}
	@RequestMapping("/{location}")
	public String codingPython(@PathVariable("location") String location)
	{
		switch(location)
		{
		case "burbank":
			return "Burbank Dojo is location in Southern California";
		case "sanjose":
			return "HQ is in SJ. Lets go Sharks";
		default:
			return String.format("%s is pretty sweet!", location);
		}
	}
}
