package com.example.dojoOverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dojoOverflow.models.Answer;
import com.example.dojoOverflow.models.Question;
import com.example.dojoOverflow.models.Tag;
import com.example.dojoOverflow.services.QuestionServices;

@Controller
public class MainController 
{
	@Autowired
	private QuestionServices qServices;
	
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/questions")
	public String questions(Model m)
	{
		List<Question> qList = this.qServices.findAllQuestions();
		for(Question q : qList)
		{
			System.out.println("Tags:" + q.getTags());
			for(Tag t : q.getTags())
			{
				System.out.println(t.getName());
			}
		}
		m.addAttribute("qList", qList);
		return "questions.jsp";
	}
	
	//Navigate to new question page
	@RequestMapping("/questions/new")
	public String newQuestion()
	{
		return "newQuestion.jsp";
	}
	//Create new question function
	@PostMapping("/questions/new")
	public String createQuestion(@RequestParam("text")String text, @RequestParam("formTag")String formTag, RedirectAttributes errors)
	{
		boolean hasUppercase = !formTag.equals(formTag.toLowerCase());
		
		System.out.println(text);
		System.out.println(formTag);
		//Create and set question text
		Question q = new Question();
		q.setText(text);
		
		//Break tags into a list
		List<String> formTagSeperated = Arrays.asList(formTag.split(","));
		System.out.println(formTagSeperated);
		
		//Check if there are 3 or less tags present
		if(formTagSeperated.size() <= 3 && !hasUppercase)
		{
			List<Tag> tags = new ArrayList<>();
			//Loop through broken up tag list
			for(String tagName : formTagSeperated)
			{
				//Get list of questions tags and check if its greater than 3
				if(this.qServices.findTagByName(tagName)==null)
				{
					//Create Tag
					Tag t = new Tag(tagName);
					this.qServices.saveTag(t);
					System.out.println("Tag did not exist");
				}
				else
				{
					System.out.println("Tag did exist");
				}
				//Create blank list, add new form, and save it. 
				//Loop through the broken up tag list and add each to the new list then save
				tags.add(this.qServices.findTagByName(tagName));
				q.setTags(tags);
				this.qServices.saveQuestion(q);
			}
		}
		
		//If there are more than 3 tags present, throw an error. 
		else
		{
			errors.addFlashAttribute("errors", "CANNOT ADD MORE THAN 3 TAGS TO QUESTION AND TAG MUST BE ALL LOWERCASE");
			System.out.println("THROW ERRORS");
		}
		
		return "redirect:/questions/new";
	}
	
	//View question page
	@RequestMapping("/questions/{id}")
	public String viewQuestion(@PathVariable("id")Long id, Model m)
	{
		Question q = this.qServices.findQuestion(id);
		m.addAttribute("question", q);
		System.out.println(q.getAnswers());
		return "viewQuestion.jsp";
	}
	@PostMapping("/questions/{id}")
	public String newAnswer(@PathVariable("id")Long id, @RequestParam("answer")String answer)
	{
		//Add answer
		Answer a = new Answer(answer);
		this.qServices.saveAnswer(a);
		
		//Get answers to question, add question to list, add the list to the question, and then save it. 
		Question q = this.qServices.findQuestion(id);
		a.setQuestion(q);
		List<Answer> aList = q.getAnswers();
		aList.add(a);
		q.setAnswers(aList);
		this.qServices.saveQuestion(q);
		return "redirect:/questions/{id}";
	}
}
