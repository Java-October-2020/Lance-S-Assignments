package com.example.HelloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String home(Model model, @RequestParam(value="name", required = false, defaultValue = "Human") String name)
	{
		model.addAttribute("name", name);
		return "index.jsp";
	}
}
