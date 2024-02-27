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
	<a href="/logout">Logout</a>
	</div>
</div>

<div class="container mt-3 card bg-info p-3">
<div class="d-flex justify-content-between">
<div>
<h1>Developer Name :</h1>
<h1 class="mb-3"><c:out value="${user. firstName}"/> <c:out value="${user. lastName}"/> </h1>
</div>
<img src="${user.image_url}" height="150px" width="150px" class="p-1 rounded-circle bg-white" border="2px balck solid" >
</div>
<h2><c:out value="${user. firstName}"/> <c:out value="${user. lastName}"/> Info : </h2>
<ul>
<li>Email : <c:out value="${user.email}"/></li>
<li>Adresse : <c:out value="${user.addresse}"/></li>
<li>City : <c:out value="${user.city}"/></li>
<li>State : <c:out value="${user.state}"/></li>
</ul>
<c:if test="${user.getProfile().biography!=null}">
<h2 class="mt-2 mb-2">Biography :</h2>
<p><c:out value="${user.getProfile().biography }"></c:out></p>
</c:if>

<c:if test="${user.getProfile().profession !=null}">
<h2>Profession or current job :</h2>
<p><c:out value="${user.getProfile().getProfession() }"></c:out></p>
</c:if>

<c:if test="${user.getProfile().experience !=null}">
<h2 class="mt-2 mb-2">Experience :</h2>
<p><c:out value="${user.getProfile().experience }"></c:out> Years</p>
</c:if>
<div class="d-flex justify-content-between">
<div>
<h3 class="mb-2">Languages :</h3>

	<c:forEach var="language" items="${user.getProfile().languages}">
		<p><span class="bg-warning px-3"><c:out value="${language}"/></span></p>
	</c:forEach>
</div>
<div>
<h3 class="mb-3">Frameworks :</h3>

	<c:forEach var="framework" items="${user.getProfile().frameworks}">
		<p><span class="bg-warning px-3"><c:out value="${framework}"/></span></p>
	</c:forEach>
</div>
</div>
</body>
</html>