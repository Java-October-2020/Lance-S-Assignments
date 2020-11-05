package com.example.records.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.records.models.Record;
import com.example.records.repositories.RecordRepository;

@Service
public class RecordService 
{
	private RecordRepository rRepo;
	
	public RecordService(RecordRepository repo)
	{
		this.rRepo = repo;
	}
	
	//Get All
	public List<Record> getAllRecords()
	{
		return this.rRepo.findAll();
	}
	
	//Get One (Read)
	public Record getOneRecord(Long id)
	{
		return this.rRepo.findById(id).orElse(null);
	}
	
	public Record createRecord(Record newRecord)
	{
		return this.rRepo.save(newRecord);
	}
	
	public Record createRecord(String name, String artistName, int year)
	{
		Record newRecord = new Record(name, artistName, year);
		return this.rRepo.save(newRecord);
	}
	
	public Record updateRecord(Record updatedRecord)
	{
		return this.rRepo.save(updatedRecord);
	}
	
	public String deleteRecord(Long id)
	{
		this.rRepo.deleteById(id);
		return "Record" + id + "has been deleted";
	} 
}
