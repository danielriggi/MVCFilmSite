<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
<!-- Include Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Film</h1>
	 <br>
     <c:choose>
    <c:when test="${not empty film}">
        <ul>
            <li>ID: ${film.id}</li>
            <li>Title: ${film.title}</li>
            <li>Description: ${film.description}</li>
            <li>Year: ${film.year}</li>
            <li>Length: ${film.length}</li>
            <li>Rating: ${film.rating}</li>
            <li>Actors: ${film.actors}</li>
            <li>Language: ${film.language}</li>
            <li>Category: ${film.category}</li>
        </ul>
    </c:when>
		<c:otherwise>
			<p>No films found</p>
		</c:otherwise>
	</c:choose>
	
		<div class="container">
  <div class="row">
    <div class="col-md-4">
      <form action="EditFilm.do" method="POST">
        <input type="hidden" name="editFilmId" value="${film.id}">
        <button type="submit" class="btn btn-primary">Edit this film</button>
      </form>
    </div>
    <div class="col-md-4">
      <form action="DeleteFilm.do" method="POST">
        <input type="hidden" name="deleteFilmId" value="${film.id}">
        <button type="submit" class="btn btn-danger">Delete this film</button>
      </form>
    </div>
    <div class="col-md-4">
      <button type="button" class="btn btn-secondary" onclick="goBack()">Go Back</button>
    </div>
  </div>
</div>

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