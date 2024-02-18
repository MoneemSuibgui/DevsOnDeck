<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid d-flex justify-content-between mx-5">
			<div>
				<a class="navbar-brand" href="/home">Home</a>| <a
					class="navbar-brand" href="/new/event">New</a>| <a
					class="navbar-brand" href="/search">Search</a>
			</div>
			<div>
				<a class="navbar-brand" href="#">Accounts</a>
			</div>
		</div>
	</nav>
	<div class="container mt-4">
		<div class="d-flex jsutify-content-between">
			<div class="col-5 mx-2">
				<h3>
					Name :
					<c:out value="${user.firstName}" />
					<c:out value="${user.lastName}" />
				</h3>
				<h3>
					Email :
					<c:out value="${user.email}" />
				</h3>
				<h3 class="mb-4">
					Password :
					<c:out value="${pass}" />
				</h3>

				<a href="/edit/users/${user.id}">Edit</a>
				<h3 class="mt-4">Event History :</h3>
				<c:forEach var="event" items="${user.favouriteEvents}">
					<c:if test="${event.eventDate lt today}">
						<p>
							<c:out value="${event.name}" />
						</p>
					</c:if>
				</c:forEach>

				<h3>Future Event :</h3>
				<c:forEach var="event" items="${user.favouriteEvents}">
					<c:if
						test="${event.eventDate gt today || event.eventDate == today}">
						<p>
							<c:out value="${event.name}" />
						</p>
					</c:if>
				</c:forEach>
			</div>
			<div class="bg-info col-5 p-3">
				<form action="/upload/picture/${user.id}" method="post"
					enctype="multipart/form-data">
					<p class="text-light bg-danger">${errorMessage}</p>
					<input name="image" type="file" class="form-control" />
					<button class="btn btn-primary mt-4">Upload</button>
				</form>
				<div class="card border border-rounder border-3 bg-warning p-4 mt-4">

					<h4 class="text-center mb-4"> Your Pictures :</h4>
					<c:forEach var="picture" items="${loggedUser.getPictures()}">
						<img alt="picture" src="${picture.image_path}" width="150px"
							height="150px" class="mb-2 p-2 rounded-4">
						<h6>* Uploaded by : <c:out value="${picture.creator.firstName }"/></h6>
						<h6>* Uploaded at : <c:out value="${picture.getCreatedAt()}"/></h6>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>

</body>
</html>