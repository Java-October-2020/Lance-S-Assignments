package com.example.TheCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexControl 
{
	private String pw = "bushido";
	
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="username") String username, @RequestParam(value="password") String password) 
	{
		if(isCorrectPassword(password))
		{
			return "redirect:/dashboard";
		}
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
    public String dashboard() {
    // ... any code to process before rendering
      return "dashboard.jsp";
    }
	private Boolean isCorrectPassword(String password)
	{
		return password.equals(pw);
	}
}
