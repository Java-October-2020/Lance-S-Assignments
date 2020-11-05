package com.example.GettingFamiliarWithRouting.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController 
{
	@RequestMapping("/")
	public String codingHome()
	{
		return "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String codingPython()
	{
		return "Python/Django was awesome";
	}
	@RequestMapping("/java")
	public String codingJava()
	{
		return "Java/Spring is better!";
	}
}
