package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

public class Film {
	private int id;
	private String title;	
	private String description;
	private int year;
	private Integer length;
	private String rating;
	private List<Actor> actors;
	private String language;
	private String category;
	
	public Film() {
		
	}
	
    public Film(int id, String title, String description, List<Actor> actors) {
        this(id, title, description, actors, 0, null, null, null, null);
    }

    public Film(int id, String title, String description) {
        this(id, title, description, null, 0, null, null, null, null);
    }
    
    public Film(String title, String description, int year, int length, String rating, String language) {
    	this(0, title, description, null, year, rating, language, length, null);
    	System.out.println("===============/n/n/n/n/n/n/n/n==================");

    }

    public Film(int id, String title, String description, List<Actor> actors, int year, String rating, String language, Integer length, String category) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.year = year;
        this.rating = rating;
        this.language = language;
        this.length = length;
        this.category = category;
    }

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return String.format("Title: %s%nYear: %d%nRating: %s%nDescription: %s%nLanguage: %s%nActors: %s%nLength: %d%nCategory: %s%n%n",
			    this.title, this.year, this.rating, this.description, this.language, this.actors, this.length, this.category);

	}

	
	
	
}
