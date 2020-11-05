package com.example.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojosAndNinjas.models.Dojo;
import com.example.dojosAndNinjas.models.Ninja;
import com.example.dojosAndNinjas.repositories.DojoRepository;
import com.example.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class DojoNinjaService 
{
	@Autowired
	private DojoRepository dojoRepo;
	@Autowired
	private NinjaRepository ninjaRepo;
	
	
	//Dojos
	public List<Dojo> findAllDojos()
	{
		return this.dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id)
	{
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	public Dojo saveDojo(Dojo d)
	{
		return this.dojoRepo.save(d);
	}
	
	//Ninjas
	public Ninja saveNinja(Ninja ninja)
	{
		return this.ninjaRepo.save(ninja);
	}
}
