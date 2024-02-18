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
		<div class="row mb-4">
			<form action="/search/event">
				<input name="searchEvent"> <label for="search">Search
					By :</label> <select name="searchEvent" id="searchEvent">
					<option value="name">Event Name</option>
					<option value="location">Event Location</option>
					<option value="creator">Event Creator</option>
				</select>
				<button class="btn btn-success">Submit</button>
			</form>
		</div>
		<table class="table table-border table-hover">
			<tr>
				<th>Event Name</th>
				<th>Location</th>
				<th>Member</th>
				<th>Date</th>
				<th>Creator</th>
				<th>Action</th>
			</tr>
			<c:forEach var="event" items="${events}">
				<tr>
					<td><c:out value="${event.name}" /></td>
					<td><c:out value="${event.location}" /></td>
					<td><c:out value="${event.member}" /></td>
					<td>
					<span class="fs-5 mx-3"><c:out value="${event.eventDate}" /></span> <span class="bg-danger p-2 rounded"> <c:out value="${event.eventTime}"></c:out></span></td>
					<td><a href="/users/${event.creator.id}"><c:out value="${event.creator.firstName}"/></a></td>
					
					<td><c:choose>
							<c:when test="${event.eventDate gt  now || event.eventDate.equals(now)}">
							<c:if test="${event.users.contains(user)}">
								<a href="/${event.id}">View</a>
							</c:if>
							<c:if test="${!event.users.contains(user) }">
								<a href="/join/${event.id}">Join</a>
							</c:if>
								
							</c:when>
							<c:otherwise>
								<p>Full</p>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>