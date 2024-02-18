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
	<div class="container mt-2">
		<div class="text-center mb-4">
			<h1>ISport</h1>
			<p class="mt-3">Free Pickup Game Finder and Organizer</p>
		</div>

		<div class="d-flex justify-content-between">
			<div
				class='col-6 p-4 border border-3 rounded-5 bg-warning mb-3 shadow'>
				<form:form action="/register" method="POST" modelAttribute="newUser">

					<p class="text-danger">
						<form:errors path="firstName" />
					</p>
					<div class="form-group row mb-3">
						<label for="firstName" class="col-sm-2 col-form-label">First
							Name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="firstName"
								placeholder="Enter your first name" />
						</div>
					</div>
					<p class="text-danger">
						<form:errors path="lastName" />
					</p>
					<div class="form-group row mb-3">
						<label for="lastName" class="col-sm-2 col-form-label">Last
							Name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="lastName"
								placeholder="Enter your last name" />
						</div>
					</div>
					<p class="text-danger">
						<form:errors path="email" />
					</p>
					<div class="form-group row mb-3">
						<label for="email" class="col-sm-2 col-form-label">Email </label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" id="email"
								path="email" placeholder="email@example.com" />
						</div>
					</div>
					<p class="text-danger">
						<form:errors path="password" />
					</p>
					<div class="form-group row mb-4">
						<label for="password" class="col-sm-2 col-form-label">Password
							: </label>
						<div class="col-sm-10">
							<form:input type="password" class="form-control" id="password"
								path="password" placeholder="Enter your Password" />
						</div>
						<p class="text-danger">
							<form:errors path="birthdate" />
						</p>
						<div class="form-group row mb-3 mt-4">
							<label for="birthdate" class="col-sm-2 col-form-label">Birthdate</label>
							<div class="col-sm-10">
								<form:input type="date" class="form-control" id="birthdate"
									path="birthdate" />
							</div>
						</div>

					</div>
					<div class='text-end'>
						<button class="btn btn-primary mb-2">Register</button>
					</div>
				</form:form>
			</div>
			<div class='col-6 bg-warning p-4 border border-3 rounded-4 mx-4'>
				<form:form action="/login" method="POST" modelAttribute="user">
					<p class="text-danger">
						<form:errors path="email" />
					</p>
					<div class="form-group row mb-4">
						<label for="email" class="col-sm-2 col-form-label">Email </label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" id="email"
								path="email" placeholder="Enter your Email" />
						</div>
						<p class="text-danger">
							<form:errors path="password" />
						</p>
						<div class="form-group row mb-3 mt-3">
							<label for="password" class="col-sm-2 col-form-label">Password</label>
							<div class="col-sm-10">
								<form:input type="password" class="form-control" id="password"
									path="password" placeholder="Enter your Password" />
							</div>
						</div>
					</div>
					<div class='text-end'>
						<button class="btn btn-primary mb-2">Login</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>