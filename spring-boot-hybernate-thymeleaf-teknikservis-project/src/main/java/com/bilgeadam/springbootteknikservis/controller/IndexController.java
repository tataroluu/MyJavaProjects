package com.bilgeadam.springbootteknikservis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController
{

	@GetMapping(path = {"","/","index","index.html"})
	public ModelAndView index()
	{


		return new ModelAndView("index");
	}


}
