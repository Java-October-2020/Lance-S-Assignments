package com.example.records.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.records.models.Record;

@Repository
public interface RecordRepository extends CrudRepository<Record,Long>
{
	List<Record> findAll();
}
