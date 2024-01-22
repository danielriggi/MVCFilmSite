package com.skilldistillery.film.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.entities.Actor;
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

		Film film = filmDAO.findFilmById(id);

		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/result.jsp");
		return mv;
	}

	@RequestMapping(path = "AddFilm.do", method = RequestMethod.POST)
	public String newFilm(Film film, RedirectAttributes redir) { 
		
		Film newFilm = filmDAO.createFilm(film);
		redir.addFlashAttribute("film", newFilm);
		return "redirect:filmAdded.do";
	}

	@RequestMapping("filmAdded.do")
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();

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
	public String submitEditFilm(Film film, RedirectAttributes redir) {

		Film editedFilm = filmDAO.editFilm(film);
		redir.addFlashAttribute("film", film);
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

	@RequestMapping(path = "AddActor.do", method = RequestMethod.POST)
	public ModelAndView newActor(Actor actor) {
		ModelAndView mv = new ModelAndView();
		Actor newActor = filmDAO.createActor(actor);

		mv.addObject("newActor", newActor);

		mv.setViewName("WEB-INF/views/actorResults.jsp");

		return mv;
	}
	
	@RequestMapping(path = "searchFilms.do", method = RequestMethod.POST)
	public ModelAndView searchFilms(@RequestParam("keyword") String keyword, Model model) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmsByKeyword(keyword);
	    model.addAttribute("films", films);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/views/filmSearchResults.jsp");
		return mv;
    }


	@RequestMapping(path = "UpdateActor.do", method = RequestMethod.POST)
	public String updateActor(@RequestParam("updateActorId") int actorId,
	                           @RequestParam("firstName") String firstName,
	                           @RequestParam("lastName") String lastName,
	                           Model model) {
	    // Retrieve the existing actor by ID
	    Actor existingActor = filmDAO.getActorById(actorId);

	    if (existingActor != null) {
	        // Update the actor's details
	        existingActor.setFirstName(firstName);
	        existingActor.setLastName(lastName);

	        // Perform the update in the data source (e.g., database)
	        filmDAO.updateActor(existingActor);

	        // Redirect to the film search results page
	   
	    }
	    return "redirect:/path/to/filmSearchResults";
	}

}
