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
<title>ISport</title>
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
	<div class="container mt-5">
		<div class="d-flex justify-content-between">
			<h1>
				Welcome,
				<c:out value="${user.firstName}" />
				<c:out value="${user.lastName}" />
				!
			</h1>
			<a href="/logout" class="btn btn-danger btn-lg">Logout</a>
		</div>

		<p class="mt-2">
			Today is <span class="bg-info px-2 rounded"><c:out
					value="${formattedDate}" /></span> and you have today:
		</p>

		<table class="table table-border table-hover">
			<tr class="bg-secondary">
				<th>Event Name</th>
				<th>Location Name</th>
				<th>Attendances</th>
				<th>Time</th>
			</tr>

			<c:forEach var="event" items="${user.favouriteEvents}">
				<c:if test="${(event.eventDate).equals(today) }">
					<tr>
						<td><c:out value="${event.name }"></c:out></td>
						<td><c:out value="${event.location }"></c:out></td>
						<td><c:out value="${event.attendance }"></c:out></td>
						<td><c:out value="${event.eventTime }"></c:out></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>

		<p class="mt-4">Here are your joined future events:</p>
		<table class="table table-border table-hover">
			<tr class="bg-secondary">
				<th>Event Name</th>
				<th>Location Name</th>
				<th>Attendances</th>
				<th>Date</th>
			</tr>

			<c:forEach var="event" items="${user.favouriteEvents}">
				<c:if test="${(event.eventDate) gt (today) }">
					<tr>
						<td><c:out value="${event.name}"></c:out></td>
						<td><c:out value="${event.location}"></c:out></td>
						<td><c:out value="${event.attendance}"></c:out></td>
						<td><c:out value="${event.eventDate}"></c:out></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>

	</div>
</body>
</html>