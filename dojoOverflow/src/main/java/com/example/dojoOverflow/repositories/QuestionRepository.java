package com.example.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dojoOverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>
{
	List<Question> findAll();
}
