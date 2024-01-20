package com.skilldistillery.film.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.data.FilmDAOImpl;
import com.skilldistillery.film.entities.Film;

public class TestingApp {
	DatabaseAccessor dao = new FilmDAOImpl();

	public static void main(String[] args) {
		TestingApp app = new TestingApp();
		app.launch();
	}

	private void test() {
		Film film = dao.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

		int choice = 0;
		do {
			displayMenu();
			choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Please enter a film id.");
				int filmId = input.nextInt();
				Film film = dao.findFilmById(filmId);
				if (film != null) {
					System.out.println(film);
					editFilmOption(input, film);
					deleteFilmOption(input, film);
				} else {
					System.out.println("No film found with id: " + filmId);
				}
				break;
			case 2:
				System.out.println("Enter the keyword for the search: ");
				String kw = input.next();
				List<Film> films = dao.findFilmsByKeyword(kw);
				if (films.isEmpty()) {
					System.out.println("No films match");
				} else {
					for (Film currentFilm : films) {
						System.out.println(currentFilm);
						editFilmOption(input, currentFilm);
						deleteFilmOption(input, currentFilm);
					}
				}
				break;
			case 3:
				System.out.println("Input the film's attributes:");
				System.out.println("Title:");
				String title = input.next();
				System.out.println("Description:");
				String description = input.next();
				System.out.println("Release year:");
				Integer releaseYear = input.nextInt();
				System.out.println("Length:");
				Integer filmLength = input.nextInt();
				input.nextLine();
				System.out.println("Rating (G, PG, PG13, R, NC17):");
				String rating = input.nextLine();
				if (!rating.equals("G") && !rating.equals("PG") && !rating.equals("PG13") && !rating.equals("R")
						&& !rating.equals("NC17")) {
					System.out.println("Invalid rating, inputing default.");
					rating = "G";
				}
				System.out.println("Category:");
				String category = input.nextLine();

				Film userFilm = new Film(0, title, description, null, releaseYear, rating, null, filmLength, category);
				Film addedFilm = dao.createFilm(userFilm);
				System.out.println(addedFilm);
				editFilmOption(input, addedFilm);
				deleteFilmOption(input, addedFilm);
				break;

			case 4:
				System.out.println("Exiting program");
				break;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		} while (choice != 4);
	}

	public void displayMenu() {
		System.out.println("Menu:");
		System.out.println("1. Look up a film by its ID");
		System.out.println("2. Look up a film by a search keyword");
		System.out.println("3. Add new film");
		System.out.println("4. Exit the application");
		System.out.print("Enter your choice: ");
	}

	public void deleteFilmOption(Scanner input, Film film) {
		System.out.println("Do you wish to delete this film?");
		System.out.println("1. Yes");
		System.out.println("2. No Way!");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			dao.deleteFilm(film);
			break;
		default:
			System.out.println("Keeping film.\n");
		}
	}

	public void editFilmOption(Scanner input, Film film) {
		System.out.println("Do you wish to edit this film?");
		System.out.println("1. Yes");
		System.out.println("2. No Way!");
		int choice = input.nextInt();
		input.nextLine();
		switch (choice) {
		case 1:
			System.out.println("New Title: ");
			String title = input.nextLine();
			film.setTitle(title);
			dao.editFilm(film);
			break;
		default:
			System.out.println("Not editin film.\n");
		}

	}
}
