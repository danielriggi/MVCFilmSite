<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty films}">
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
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No films found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>