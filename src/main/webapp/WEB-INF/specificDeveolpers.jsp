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

		<a href="/orgs/${org.id}" class="mx-4 text-light fs-3"><c:out
				value="${org.name}"></c:out></a>
		<h3 class="text-light">DevsOnDeck</h3>
		<a href="/orgs/logout" class="fs-3">logout <span class="fs-3">🔄</span></a>

	</div>
	<h1 class="text-center mb-5 mt-3">
		<c:out value="${position.name}"></c:out>
	</h1>
	<div class="mb-2">	
				<div class="overflow-auto border border-4 " style="height: 40rem;">
				<h1 class="bg-secondary mx-3 p-4">Available Devs</h1>
					<c:forEach var="developer" items="${developers}">
					<div class="border border-3 mt-3 p-2 border-black bg-info">
						<div class="form-control mb-4 border border-2 d-flex justify-content-around">
							<a href="#" class="mx-2"><c:out value="${developer.firstName}" /> <c:out value="${developer.lastName}" /></a>
							<img src="${developer.image_url}" height="100px" width="100px" class="p-1 rounded-circle bg-white" border="2px balck solid" >
							
							<c:forEach var="language" items="${developer.getProfile().languages }">
							<p class="mx-2 bg-secondary p-1 text-light"><c:out value="${language}"/></p>
							</c:forEach>
							<c:forEach var="framework" items="${developer.getProfile().frameworks }">
							<p class="mx-2  bg-secondary p-1 text-light"><c:out value="${framework}"/></p>
							</c:forEach>
							</div>
							<p><span class="fs-6">Biography :</span> <c:out value="${developer.getProfile().biography}"/></p>
						<p><span class="fs-6">Last or Current Profession:</span> <c:out value="${developer.getProfile().profession}"/></p>
						<p><span class="fs-6">Years of Experience:</span> <c:out value="${developer.getProfile().experience}"/> Years</p>
						
					</div>
					</c:forEach>
				</div>
			</div>
</body>
</html>