<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to DevsOnDeck</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="d-flex justify-content-between bg-danger p-4 border border-dark border-3">
	<h3 class="text-light">DevsOnDeck</h3>
	<div>
	<a href="/devs/login" class="mx-4">Dev Login</a>
	<a href="/orgs/login">Org Login</a>
	</div>
</div>
<div class="container  card bg-info mt-4 p-5 border border-4 border-dark">
<h1 class="text-center">Organization Sign Up</h1>
<form:form action="/orgs/register" method="post" modelAttribute="organization">

<p><form:errors path="name" class="text-danger"></form:errors></p>
<div class="d-inline d-flex justify-content-between mb-3">
	<form:label path="name" class="mx-3">Org Name </form:label>
	<form:input path="name" class="form-control mx-4"/>
</div>


<p><form:errors path="firstName" class="text-danger"></form:errors></p>
<p><form:errors path="lastName" class="text-danger"></form:errors></p>

<div class="d-inline d-flex justify-content-between mb-3">
<form:label path="firstName" class="mx-3">First Name </form:label>
<form:input path="firstName" class="form-control mx-4"/>


<form:label path="lastName">Last Name </form:label>
<form:input path="lastName" class="form-control mx-4"/>
</div>
<p><form:errors path="email" class="text-danger"></form:errors></p>
<div class="d-inline d-flex justify-content-between mb-3">

<form:label path="email" class="mx-3">Contact Email</form:label>
<form:input path="email" class="form-control mx-4"/>
</div>

<p><form:errors path="addresse" class="text-danger"></form:errors></p>
<div class="d-inline d-flex justify-content-between mb-3">
<form:label path="addresse" class="mx-2">Org Adresse</form:label>
<form:input path="addresse" class="form-control mx-4"/>
</div>

<p><form:errors path="city" class="text-danger"></form:errors></p>
<p><form:errors path="state" class="text-danger"></form:errors></p>
<div class="d-inline d-flex justify-content-between mb-3">


<form:label path="city" class="mx-4">Org City</form:label>
<form:input path="city" class="form-control mx-4"/>

<form:label path="state">State</form:label>
	<form:select path="state" class="form-control mx-4">
	<form:option value="Tunisia">Tunisia</form:option>
	<form:option value="Algeria">Algeria</form:option>
	<form:option value="Morroco">Morroco</form:option>
	<form:option value="Egypt">Egypt</form:option>
	<form:option value="Libya">Libya</form:option>
</form:select>

</div>

<p><form:errors path="password" class="text-danger"></form:errors></p>
<div class="d-inline d-flex justify-content-between mb-3">
	<form:label path="password" >Password</form:label>
	<form:input path="password" type="password" class="form-control mx-4"/>
</div>

<p><form:errors path="confirm" class="text-danger"></form:errors></p>
<div class="d-inline d-flex justify-content-between">
	<form:label path="confirm" class="mx-1">Confirm</form:label>
	<form:input path="confirm"  type="password"  class="form-control mx-4"/>
</div>

<div class="text-end mx-4">
	<button class="btn btn-success mt-2">Register</button>
</div>
<div class="text-center">
	<a href="/devs/register">Need to Sign Up as a Developer?</a>
</div>

</form:form>
</div>
  
</body>
</html>
