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
	<div class="container mt-4">
		<div class="d-flex justify-content-between mb-4">
			<h1>Create Event</h1>
			<a href="/logout" class="btn btn-danger btn-danger">Logout</a>
		</div>
		<div class="card col-8 p-3 border border-3 border-dark bg-warning shadow text-light">
		<form:form action="/new/event" method="post" modelAttribute="newEvent">
		<p class="text-danger "><form:errors path="name"/></p>
		<form:label path="name">Event Name</form:label>
		<form:input path="name" class="form-control"/>
		
		<p class="text-danger mt-3"><form:errors path="location"/></p>
		<form:label path="location">Location</form:label>
		<form:input path="location" class="form-control"/>
		
		<p class="text-danger mt-3"><form:errors path="attendance"/></p>
		<form:label path="attendance">Attendance</form:label>
		<form:input path="attendance" type="number" class="form-control"/>
		
		<p class="text-danger mt-3"><form:errors path="member"/></p>
		<form:label path="member">Member</form:label>
		<form:input path="member" type="number" class="form-control"/>
		
		<p class="text-danger mt-3"><form:errors path="eventDate"/></p>
		<form:label path="eventDate">Date</form:label>
		<form:input path="eventDate" type="date" class="form-control"/>
		
		<p class="text-danger mt-3"><form:errors path="eventTime"/></p>
		<form:label path="eventTime">Time</form:label>
		<form:input path="eventTime" type="time" class="form-control"/>
		
		<div class="text-end mt-3">
		<button class="btn btn-primary btn-lg">Create</button>
		</div>
		</form:form>
		</div>
	</div>
</body>
</html>