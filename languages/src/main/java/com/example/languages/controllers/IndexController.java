package com.example.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.languages.models.Language;
import com.example.languages.services.LanguageServices;

@Controller
@RequestMapping("/languages")
public class IndexController 
{
	private final LanguageServices langService;
	public IndexController(LanguageServices serv)
	{
		this.langService = serv;
	}
	
	
	
	
	//Navigate user to page
	@GetMapping("")
	public String index(Model model, @ModelAttribute("language")Language lang)
	{
		List<Language> langs = langService.findAllLang();
		model.addAttribute("langs", langs);
		return "index.jsp";
	}
	
	//Takes in the form data
	@PostMapping("")
	public String create(Model model, @Valid @ModelAttribute("language")Language lang, BindingResult result)
	{
		if(result.hasErrors())
		{
			List<Language> langs = langService.findAllLang();
			model.addAttribute("langs", langs);
			return "index.jsp";
		}
		else
		{
			List<Language> langs = langService.findAllLang();
			model.addAttribute("langs", langs);
			this.langService.createLanguage(lang);
			return "index.jsp";
		}
	}
	
	@GetMapping("/{id}")
	public String view(@PathVariable("id")Long id, Model model)
	{
		Language lang = this.langService.findLang(id);
		model.addAttribute("language", lang);
		return "language.jsp";
	}
	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id")Long id, @ModelAttribute("language")Language language)
	{
		Language langVar = this.langService.findLang(id);
		model.addAttribute("language", language);
		model.addAttribute("langVar", langVar);
		return "edit.jsp";
	}
	@PostMapping("{id}")
	public String update(Model model, @Valid @ModelAttribute("language")Language language, BindingResult result)
	{
		if(result.hasErrors())
		{
			List<Language> langs = langService.findAllLang();
			model.addAttribute("langs", langs);
			System.out.println(result);
			return "index.jsp";
		}
		else
		{
			model.addAttribute("language", language);
			this.langService.updateLanguage(language);
			List<Language> langs = langService.findAllLang();
			model.addAttribute("langs", langs);
			return "index.jsp";
		}
	}
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable Long id)
	{
		this.langService.deleteByID(id);
		return "redirect:/";
	}
	
}
