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
		<a href="/orgs/logout" class="fs-3">logout <span class="fs-3">🔄</span></a>

	</div>
	<div class="container mt-5 border border-4 border-dark text-center">
		<h1 class="bg-info text-center p-2">Add A Position</h1>


		<form:form action="/orgs/jobs/new" method="post"
			modelAttribute="position">
			<p>
				<form:errors path="name" class="text-danger"></form:errors>
			</p>
			<div class="d-flex justify-content-betwwen mt-5">
				<form:label path="name" class="mx-3">Name  </form:label>
				<form:input path="name" class="form-control mb-2" />
			</div>

			<p>
				<form:errors path="description" class="text-danger"></form:errors>
			</p>
			<div class="d-flex justify-content-betwwen">
				<form:label path="description" class="mx-3">Description  </form:label>
				<form:textarea path="description" class="form-control mb-4" />
			</div>

			<div class="d-flex justify-content-around mb-4 mx-4 mt-4">
			<p>
				<form:errors path="skills" class="text-danger"></form:errors>
			</p>
				<form:label path="skills" class="mx-4">Skills </form:label>
				<div class="text-center">
					<div class="overflow-auto border border-3 border-dark p-2"
						style="height: 10rem; width: 30rem;">
						
						
						<ul onclick="chooseItem(event)" class="p-2 text-white" >
							<li class="btn btn-secondary mx-3 mb-3" >JAVA</li>
							<li class="btn btn-secondary mx-3 mb-3">SQL</li>
							<li class="btn btn-secondary mx-3 mb-3">PYTHON</li>
							<li class="btn btn-secondary mx-3 mb-3">JS</li>
							<li class="btn btn-secondary mx-3 mb-3">Angular</li>
							<li class="btn btn-secondary mx-3 mb-3">React</li>
							<li class="btn btn-secondary mx-3 mb-3">Bootstrap</li>
							<li class="btn btn-secondary mx-3 mb-3">GO</li>
							<li class="btn btn-secondary mx-3 mb-3">HTML5</li>
							<li class="btn btn-secondary mx-3 mb-3">CSS</li>
							<li class="btn btn-secondary mx-3 mb-3">Spring</li>
							<li class="btn btn-secondary mx-3 mb-3">Flask</li>
							<li class="btn btn-secondary mx-3 mb-3">Django</li>
							<li class="btn btn-secondary mx-3 mb-3">MySQL</li>
						</ul>
						
						
						<textarea name="skills" id="response"></textarea>
						
					</div>
				</div>
			</div>
			<div class="text-end mx-5">
				<button class="btn btn-primary btn-lg mb-4">Add Position</button>
			</div>
			
		</form:form>



	</div>

</body>
<script>
	var items = []
	function chooseItem(event) {

		var target = event.target;

		var item = event.target.innerHTML.trim().toLowerCase();
		console.log(item);
		items.push(item);
		document.getElementById("response").innerHTML = items;
		
		return items;
	}
	chooseItem();
</script>
</html>