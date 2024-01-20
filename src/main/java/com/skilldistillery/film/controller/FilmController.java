package com.skilldistillery.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.film.data.DatabaseAccessor;


import org.springframework.stereotype.Controller;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessor filmDAO;
	
	@RequestMapping("")
	public String home() {
		return "WEB-INF/views/home.jsp";
	}
}
