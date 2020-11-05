package com.example.driversLicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.driversLicense.models.License;
import com.example.driversLicense.models.Person;
import com.example.driversLicense.repositories.LicenseRepository;
import com.example.driversLicense.repositories.PersonRepository;

@Service
public class PersonService 
{	
	@Autowired
	private PersonRepository personRepo;
	@Autowired
	private LicenseRepository lRepo;
	
	public Person addPerson(Person p)
	{
		return this.personRepo.save(p);
	}
	
	public Person findPerson(Long id)
	{
		return this.personRepo.findById(id).orElse(null);
	}
	
	public List<Person> findAllPerson()
	{
		return this.personRepo.findAll();
	}
	
	public List<Person> findAllUnlicensed()
	{
		return this.personRepo.findByLicenseIdIsNull();
	}
	
	public License createLicense(License l)
	{
		l.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(l);
	}
	
	public int generateLicenseNumber()
	{
		License l = this.lRepo.findTopByOrderByNumberDesc();
		if(l == null)
		{
			return 1;
		}
		else
		{
			int highestNumber = l.getNumber();
			highestNumber++;
			return (highestNumber);
		}
	}
}
