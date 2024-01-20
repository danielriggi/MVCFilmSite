<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(films) > 0}">
			<ul>
				<c:forEach items="${films}" var="film">
					<li>ID: ${film.id}</li>
					<li>Title: ${film.title}</li>
					<li>Description: ${film.description}</li>
					<li>Year: ${film.year}</li>
					<li>Length: ${film.length}</li>
					<li>Rating: ${film.rating}</li>
					<li>Actors: ${film.actors}</li>
					<li>Language: ${film.language}</li>
					<li>Category: ${film.category}</li>
					<h3>Delete Film</h3>
					<form action="DeleteFilm.do" method="POST">
						<!-- Assuming you want to pass the film ID for deletion -->
						<input type="hidden" name="deleteFilmId" value="${film.id}">
						<!-- Replace "123" with the actual film ID -->
						<button type="submit">Delete this film</button>
					</form>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No films found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>