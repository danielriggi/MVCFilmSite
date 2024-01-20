package com.skilldistillery.film.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessor filmDAO;

	@RequestMapping("")
	public String home() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path="GetFilm.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getStateByName(@RequestParam("id") Integer id) {
	    ModelAndView mv = new ModelAndView();
	    List<Film> films = new ArrayList<>(); // Initialize an empty list

	    Film film = filmDAO.findFilmById(id);
	    if (film != null) {
	        films.add(film); // Add the film to the list
	    }

	    mv.addObject("films", films);
	    mv.setViewName("WEB-INF/views/result.jsp");
	    return mv;
	}
}
