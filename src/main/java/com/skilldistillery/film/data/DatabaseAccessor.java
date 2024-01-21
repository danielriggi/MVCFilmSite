package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
	public static final String USER = "student";
	public static final String PASS = "student";
	public static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=America/New_York";

	public Film findFilmById(int filmId);
	public Film createFilm(Film film);
	public Film editFilm(Film film);
	public List<Film> findFilmsByKeyword(String keyword);
	public List<Actor> findActorsByFilmId(int filmId);
	public Category findCategoryByFilmId(int filmId);
	public boolean deleteFilm(Film film);
	public boolean deleteFilm(Integer id);
	public Actor createActor(Actor actor);


}
