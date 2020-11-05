package com.example.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.languages.models.Language;
import com.example.languages.repositories.LanguageRepository;

@Service
public class LanguageServices 
{
	private final LanguageRepository languageRepo;
	public LanguageServices(LanguageRepository repo)
	{
		this.languageRepo = repo;
	}
	
	public List<Language> findAllLang()
	{
		return languageRepo.findAll();
	}
	
	public Language findLang(Long id)
	{
		return languageRepo.findById(id).orElse(null);
	}
	
	public Language createLanguage(Language lang)
	{
		return languageRepo.save(lang);
	}
	
	public Language createLanguage(String name, String creator, String version)
	{
		Language lang = new Language(name, creator, version);
		return languageRepo.save(lang);
	}
	
	public Language updateLanguage(Language updatedLang)
	{
		this.languageRepo.save(updatedLang);
		return updatedLang;
	}
	
	public void deleteByID(Long id)
	{
		this.languageRepo.deleteById(id);
	}
}
