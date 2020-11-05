package com.example.DisplayDate.controllers;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController 
{
	Date d = new Date();
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model m)
	{
		SimpleDateFormat date = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		m.addAttribute("dateFormat" , date.format(new java.util.Date()));
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model m)
	{
		SimpleDateFormat date = new SimpleDateFormat("h:mm a");
		m.addAttribute("timeFormat" , date.format(new java.util.Date()));
		return "time.jsp";
	}
}
