<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="/MVCFilmSite/src/main/webapp/styles.css">
<style>
  /* Add some left margin to the form */
  form, h3, .btn-secondary {
    margin-left: 20px; /* Adjust the value as needed */
  }

  /* Add space between form elements */
  form input,
  form select {
    margin-bottom: 10px; /* Adjust the value as needed */
  }
</style>
</head>
<body>
	<h3>Edit Film</h3>
	<form action="EditFilm2.do" method="POST">
		<input type="hidden" name="id" value="${film.id}">

		<!-- Title input -->
		Title: <input type="text" name="title" value="${film.title}" /> <br>

		<!-- Description input -->
		Description: <input type="text" name="description"
			value="${film.description}" /> <br>

		<!-- Year input -->
		Year: <input type="text" name="year" value="${film.year}" /> <br>

		<!-- Length input -->
		Length: <input type="text" name="length" value="${film.length}" /> <br>

		<!-- Rating input -->
		Rating: <select name="rating">
			<option value="G" ${film.rating == 'G' ? 'selected' : ''}>G</option>
			<option value="PG" ${film.rating == 'PG' ? 'selected' : ''}>PG</option>
			<option value="PG13" ${film.rating == 'PG13' ? 'selected' : ''}>PG13</option>
			<option value="NC17" ${film.rating == 'NC17' ? 'selected' : ''}>NC17</option>
			<option value="R" ${film.rating == 'R' ? 'selected' : ''}>R</option>
		</select> <br>

		<!-- Language dropdown menu -->
		Language: <select name="language">
			<option value="English"
				${film.language == 'English' ? 'selected' : ''}>English</option>
			<option value="Italian"
				${film.language == 'Italian' ? 'selected' : ''}>Italian</option>
			<option value="Japanese"
				${film.language == 'Japanese' ? 'selected' : ''}>Japanese</option>
			<option value="Mandarin"
				${film.language == 'Mandarin' ? 'selected' : ''}>Mandarin</option>
			<option value="French" ${film.language == 'French' ? 'selected' : ''}>French</option>
		</select> <br> <input type="submit" value="Update Film" />

		<div class="col-auto">
			<button type="button" class="btn btn-secondary" onclick="goBack()">Go
				Back</button>
		</div>

	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
<script>
    function goBack() {
        window.history.go(-1);
    }
</script>

</body>
</html>