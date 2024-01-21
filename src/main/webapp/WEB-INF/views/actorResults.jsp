<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Film Search Results</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <h2>Actor Results</h2>

    <!-- Access the flash attribute and display the new actor information -->
    <c:if test="${not empty newActor}">
        <p>New Actor Added:</p>
        <p>ID: ${newActor.id}</p>
        <p>Name: ${newActor.firstName} ${newActor.lastName}</p>
    </c:if>

    <!-- Your existing film details display code -->
    <c:choose>
        <c:when test="${fn:length(films) > 0}">
            <ul>
                <c:forEach items="${films}" var="film">
                    <!-- Display film details -->
                    <li>ID: ${film.id}</li>
                    <li>Title: ${film.title}</li>
                    <!-- Add other film details as needed -->
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p>No films found</p>
        </c:otherwise>
    </c:choose>

    <!-- Back Button -->
    <div class="col-auto">
        <button type="button" class="btn btn-secondary" onclick="goBack()">Go Back</button>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script>
        function goBack() {
            window.location.href = "/MVCFilmSite/AddNewActor.html?";
        }
    </script>
</body>
</html>
