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
<title>Welcome to DevsOnDeck</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div
		class="d-flex justify-content-between bg-danger p-4 border border-dark border-3">
		<h3 class="text-light">DevsOnDeck</h3>
		<div>
			<a href="/devs/register" class="mx-4">Dev Registration</a> <a
				href="/orgs/register">Org Registration</a>
		</div>
	</div>
	<div class="container col-6 mt-4 card bg-warning p-4 text-center">
		<h1>Welcome Back , Developer!</h1>
		<h4 class="mt-2">Let's Connect You To A job</h4>
		<form:form action="/devs/login" method="post" modelAttribute="user">
			<p>
				<form:errors path="email" class="text-danger"></form:errors>
			</p>
			<div class="d-inline d-flex justify-content-between mt-4">

				<form:label path="email" class="mx-4">Email</form:label>
				<form:input path="email" class="form-control" />
			</div>

			<p>
				<form:errors path="password" class="text-danger text-start mt-3 mb-2"></form:errors>
			</p>
			<div class="d-inline  d-flex justify-content-between mt-4">

				<form:label path="password" class="mx-2">Password</form:label>
				<form:input path="password" class="form-control" />
			</div>
			<div class="text-end">
				<button class="btn btn-success btn-lg mt-3">Log In</button>
			</div>

		</form:form>
	</div>

</body>
</html>