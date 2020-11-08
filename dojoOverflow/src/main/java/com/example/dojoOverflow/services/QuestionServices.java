package com.example.dojoOverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojoOverflow.models.Answer;
import com.example.dojoOverflow.models.Question;
import com.example.dojoOverflow.models.Tag;
import com.example.dojoOverflow.repositories.AnswersRepository;
import com.example.dojoOverflow.repositories.QuestionRepository;
import com.example.dojoOverflow.repositories.TagRepository;

@Service
public class QuestionServices 
{
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private TagRepository tRepo;
	@Autowired
	private AnswersRepository aRepo;
	
	//Questions
	public List<Question> findAllQuestions()
	{
		return this.qRepo.findAll();
	}
	public Question findQuestion(Long id)
	{
		return this.qRepo.findById(id).orElse(null);
	}
	public Question saveQuestion(Question q)
	{
		return this.qRepo.save(q);
	}
	
	//Tags
	public List<Tag> findAllTags()
	{
		return this.tRepo.findAll();
	}
	public Tag findTag(Long id)
	{
		return this.tRepo.findById(id).orElse(null);
	}
	public Tag findTagByName(String name)
	{
		return this.tRepo.findByName(name).orElse(null);
	}
	public Tag saveTag(Tag t)
	{
		return this.tRepo.save(t);
	}
	
	//Answers
	public List<Answer> findAllAnswers()
	{
		return this.aRepo.findAll();
	}
	public Answer findAnswer(Long id) 
	{
		return this.aRepo.findById(id).orElse(null);
	}
	public Answer saveAnswer(Answer a)
	{
		return this.aRepo.save(a);
	}
}
