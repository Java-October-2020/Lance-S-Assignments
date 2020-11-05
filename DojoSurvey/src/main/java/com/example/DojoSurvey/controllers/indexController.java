package com.example.DojoSurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController 
{
	private String nameForm;
	private String locationForm; 
	private String languageForm;
	private String textForm;
	
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="name") String name, 
    					@RequestParam(value="location") String location, 
    					@RequestParam(value="language") String language, 
    					@RequestParam(value="text") String text) 
	{
          // ... process information and save it to the session
		nameForm = name;
		locationForm = location;
		languageForm = language;
		textForm = text;
        return "redirect:/result";
    }
	@RequestMapping("/result")
	public String result(Model m)
	{	
		m.addAttribute("name", nameForm);
		m.addAttribute("location", locationForm);
		m.addAttribute("language", languageForm);
		m.addAttribute("text", textForm);
		return "result.jsp";
	}
}
