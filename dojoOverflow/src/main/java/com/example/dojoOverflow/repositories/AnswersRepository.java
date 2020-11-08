package com.example.dojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dojoOverflow.models.Answer;

@Repository
public interface AnswersRepository extends CrudRepository<Answer, Long>
{
	List<Answer> findAll();
}
