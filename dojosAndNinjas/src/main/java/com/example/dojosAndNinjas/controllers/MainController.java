package com.example.dojosAndNinjas.controllers;

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

import com.example.dojosAndNinjas.models.Dojo;
import com.example.dojosAndNinjas.models.Ninja;
import com.example.dojosAndNinjas.services.DojoNinjaService;

@Controller
public class MainController 
{
	@Autowired
	private DojoNinjaService service;
	
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo, Model m)
	{
		List<Dojo> dojos = this.service.findAllDojos();
		m.addAttribute("dojos", dojos);
		return "new.jsp";
	}
	@PostMapping("/dojo/new")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "redirect:/dojo/new";
		}
		this.service.saveDojo(dojo);
		return "redirect:/dojo/new";
	}
	@RequestMapping("/dojos/{id}")
	public String viewDojo(@PathVariable("id")Long id, Model m)
	{
		Dojo d = this.service.findDojo(id);
		List<Ninja> ninjas = d.getNinjas();
		m.addAttribute("dojo", d);
		m.addAttribute("ninjas", ninjas);
		return "dojoDisplay.jsp";
	}
	@RequestMapping("/ninjas/new")
	public String addNinjaPage(@ModelAttribute("ninja")Ninja ninja, Model m)
	{
		List<Dojo> dojos = this.service.findAllDojos();
		m.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model m)
	{
		if(result.hasErrors())
		{
			m.addAttribute("dojos", this.service.findAllDojos());
			return "newNinja.jsp";
		}
		this.service.saveNinja(ninja);
		return "redirect:/ninjas/new";
	}
}
