package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

@Repository
public class FilmDAOImpl implements DatabaseAccessor {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	@Override
	public Film editFilm(Film film) {
		String sql = "UPDATE film "
				+ "SET title = ?, "
				+ "description = ?, "
				+ "release_year = ?, "
				+ "length = ?, "
				+ "rating = ? "
				+ "WHERE id = ?";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, film.getTitle());
			st.setString(2, film.getDescription());
			st.setInt(3, film.getYear());
			st.setInt(4, film.getLength());
			st.setString(5, film.getRating());
			st.setInt(6,  film.getId());

			int uc = st.executeUpdate();
			System.out.println(uc + " film record updated.");
			
			ResultSet keys = st.getGeneratedKeys();
		    if (keys.next()) {
		        int generatedFilmId = keys.getInt(1);
		        System.out.println("Film ID: " + generatedFilmId + " updated");
		    }

			conn.commit();
			st.close();
			conn.close();
			return film;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return null;
		}
	}
	
	@Override
	public boolean deleteFilm(Film film) {
		String sql = "DELETE FROM film WHERE id = ?";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, film.getId());


			int uc = st.executeUpdate();
			System.out.println(uc + " film record deleted.");

			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;

	}
	
	@Override
	public boolean deleteFilm(Integer id) {
		String sql = "DELETE FROM film WHERE id = ?";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, id);


			int uc = st.executeUpdate();
			System.out.println(uc + " film record deleted.");

			conn.commit();
			st.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;

	}
	
	@Override
	public Film createFilm(Film film) {
	    Map<String, Integer> languageMapping = new HashMap<>();
        languageMapping.put("English", 1);
        languageMapping.put("Italian", 2);
        languageMapping.put("Japanese", 3);
        languageMapping.put("Mandarin", 4);
        languageMapping.put("French", 5);
		String sql = "INSERT INTO film (title, description, release_year, language_id, "
				+ "                     length, rating)" + "    VALUES (?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, film.getTitle());
			st.setString(2, film.getDescription());
			st.setInt(3, film.getYear());
			st.setInt(4, languageMapping.get(film.getLanguage()));
			st.setInt(5, film.getLength());
			st.setString(6, film.getRating());

			int uc = st.executeUpdate();
			System.out.println(uc + " film record created.");
			
			ResultSet keys = st.getGeneratedKeys();
		    if (keys.next()) {
		        int generatedFilmId = keys.getInt(1);
		        System.out.println("New film ID: " + generatedFilmId);
		        film.setId(generatedFilmId);
		    }

			conn.commit();
			st.close();
			conn.close();
			return film;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return null;
		}

	}
	
	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		String sql = "SELECT f.*, l.name as language\n"
				+ "FROM film f\n"
				+ "JOIN language l\n"
				+ " ON l.id = f.language_id\n"
				+ "WHERE title COLLATE utf8_general_ci LIKE ?\n"
				+ " OR description COLLATE utf8_general_ci LIKE ?;";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Integer id = rs.getInt("id");
				List<Actor> actors = findActorsByFilmId(id);
				Category category = findCategoryByFilmId(id);
				Film film = new Film(id, rs.getString("title"), rs.getString("description"), actors,
						rs.getInt("release_year"), rs.getString("rating"), rs.getString("language"),
						rs.getInt("length"), category.toString());
				films.add(film);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return films;
	}
	
	
	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String sql = "SELECT f.*,\n"
		                   + "l.name AS language\n"
		                   + "FROM film f\n"
		                   + "JOIN language l \n"
			               + " ON f.language_id  = l.id\n" 
		                   + "WHERE f.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				List<Actor> actors = findActorsByFilmId(filmId);
				Category category = findCategoryByFilmId(filmId);
				String categoryString = (category != null) ? category.toString() : null;
				film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"), actors,
						rs.getInt("release_year"), rs.getString("rating"), rs.getString("language"),
						rs.getInt("length"), categoryString);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return film;
	}
	
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		String sql = "SELECT a.*\n" + "FROM actor a\n" + "JOIN film_actor fa\n" + " ON fa.actor_id = a.id \n"
				+ "JOIN film f\n" + " ON f.id = fa.film_id \n" + " AND f.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				actors.add(actor);

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return actors;

	}
	
	@Override
	public Category findCategoryByFilmId(int filmId) {
		Category category = null;
		String sql = "SELECT *\n"
				+ "FROM category c\n"
				+ "JOIN film_category fc\n"
				+ " ON fc.category_id = c.id \n"
				+ "WHERE fc.film_id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				category = new Category(rs.getInt("id"), rs.getString("name"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
		return category;

	}
	
	
}
