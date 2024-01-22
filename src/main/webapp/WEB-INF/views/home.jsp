<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body class="text-center">

    <h1 class="mt-5">WELCOME TO MVC FILM SITE</h1>

		<br>
		<br>

	<div class="container">
    

    <form action="GetFilmById.html" method="get">
        <button type="submit" class="btn btn-primary">Get Film By ID</button>
    </form>
<br>
    <form action="AddNewFilm.html" method="get">
        <button type="submit" class="btn btn-primary">Add New Film</button>
    </form>
<br>
    <form action="AddNewActor.html" method="get">
        <button type="submit" class="btn btn-primary">Add New Actor</button>
    </form>
<br>
    <form action="SearchbyKeyword.html" method="get">
        <button type="submit" class="btn btn-primary">Search Films by Keyword</button>
    </form>
</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>