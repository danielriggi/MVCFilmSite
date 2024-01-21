package com.skilldistillery.film.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(path = "GetFilm.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") Integer id) {
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

	@RequestMapping(path = "AddFilm.do", method = RequestMethod.POST)
	public String newFilm(Film film, RedirectAttributes redir) {
		List<Film> films = new ArrayList<>(); // Initialize an empty list

		Film newFilm = filmDAO.createFilm(film);
		if (newFilm != null) {
			films.add(newFilm); // Add the film to the list
		}
		redir.addFlashAttribute("films", films);
		return "redirect:filmAdded.do";
	}

	@RequestMapping("filmAdded.do")
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();
		// This uses InternalResourceViewResolver with WEB-INF and .jsp as the prefix
		// and suffix
		mv.setViewName("WEB-INF/views/result.jsp");
		return mv;
	}


	@RequestMapping(path = "DeleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilmById(@RequestParam("deleteFilmId") Integer id) {
		ModelAndView mv = new ModelAndView();
		Boolean isDeleted = filmDAO.deleteFilm(id);

		mv.setViewName("WEB-INF/views/home.jsp");
		return mv;
	}

	@RequestMapping(path = "EditFilm.do", method = RequestMethod.POST)
	public ModelAndView editFilmById(@RequestParam("editFilmId") Integer id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/EditFilm.jsp");
		return mv;
	}

	@RequestMapping(path = "EditFilm2.do", method = RequestMethod.POST)
	public String  submitEditFilm(Film film, RedirectAttributes redir) {
		List<Film> films = new ArrayList<>();

		Film editedFilm = filmDAO.editFilm(film);
		films.add(editedFilm);
		redir.addFlashAttribute("films", films);
		return "redirect:filmEdited.do";
	}

	@RequestMapping("filmEdited.do")
	public ModelAndView filmEdited() {
		ModelAndView mv = new ModelAndView();
		// This uses InternalResourceViewResolver with WEB-INF and .jsp as the prefix
		// and suffix
		mv.setViewName("WEB-INF/views/result.jsp");
		return mv;
	}
}












