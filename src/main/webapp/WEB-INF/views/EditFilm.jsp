<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<h3>Edit Film</h3>
	<form action="EditFilm2.do" method="POST">
		<input type="hidden" name="filmId" value="${film.id}">

		<!-- Title input -->
		Title: <input type="text" name="title"  value="${film.title}" /> <br>

		<!-- Description input -->
		Description: <input type="text" name="description" value="${film.description}" /> <br>

		<!-- Year input -->
		Year: <input type="text" name="year" value="${film.year}" /> <br>

		<!-- Length input -->
		Length: <input type="text" name="length" value="${film.length}" /> <br>

		<!-- Rating input -->
		Rating: <select name="rating">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG13">PG13</option>
			<option value="NC17">NC17</option>
			<option value="R">R</option>
			<!-- Add more language options as needed -->
		</select> <br>

		<!-- Language dropdown menu -->
		Language: <select name="language">
			<option value="English">English</option>
			<option value="Italian">Italian</option>
			<option value="Japanese">Japanese</option>
			<option value="Mandarin">Mandarin</option>
			<option value="French">French</option>
			<!-- Add more language options as needed -->
		</select> <br> <input type="submit" value="Update Film" />
	</form>
</body>
</html>