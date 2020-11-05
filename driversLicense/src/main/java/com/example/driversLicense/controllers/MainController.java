package com.example.driversLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.driversLicense.models.License;
import com.example.driversLicense.models.Person;
import com.example.driversLicense.services.PersonService;

@Controller
public class MainController 
{
	@Autowired
	private PersonService pService;
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@RequestMapping("/persons/new")
	public String addPage(@ModelAttribute("person")Person p)
	{
		return "index.jsp";
	}
	@PostMapping("/persons/new")
	public String addPerson(@ModelAttribute("person")Person p, BindingResult result)
	{
		if (result.hasErrors())
		{
			return "index.jsp";
		}
		else
		{
			this.pService.addPerson(p);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String display(@PathVariable("id")Long id, Model m)
	{
		Person p = this.pService.findPerson(id);
		System.out.println(p.getFirstName());
		m.addAttribute("person", p);
		return "display.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String licenses(@ModelAttribute("license")License l, Model m)
	{
//		List<Person> pList = this.pService.findAllPerson();
		List<Person> pList = this.pService.findAllUnlicensed();
		m.addAttribute("persons", pList);
		return "newLicense.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("license")License l, Model m, BindingResult result)
	{
		this.pService.createLicense(l);
		return "redirect:/licenses/new";
	}
}
