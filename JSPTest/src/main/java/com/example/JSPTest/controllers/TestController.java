package com.example.JSPTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController 
{
	@RequestMapping("/")
	public String home()
	{
		return "index.jsp";
	}
}
