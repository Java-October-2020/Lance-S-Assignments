package com.example.Counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController 
{
	private int getSessionCount(HttpSession s)
	{
		Object sValue = s.getAttribute("count");
		if(sValue == null)
		{
			setSessionCount(s, 0);
			sValue = s.getAttribute("count");
		}
		return (Integer)sValue;
	}
	private void setSessionCount(HttpSession s, int value)
	{
		s.setAttribute("count", value);
	}
	
	@RequestMapping("/")
	public String index(HttpSession s)
	{
		int currCount = getSessionCount(s);
		setSessionCount(s, ++currCount);
		System.out.println(currCount);
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(Model m, HttpSession s)
	{
		int currCount = getSessionCount(s);
		m.addAttribute("currCount", currCount);
		return "counter.jsp";
	}
}
