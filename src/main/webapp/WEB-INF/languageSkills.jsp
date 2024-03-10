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
<div class="container d-flex justify-content-between bg-info border border-dark p-3 mt-4">
		<div>
		<h1 >Add Your Skills</h1>
		<h2><c:out value="${LGuser.firstName }"/></h2>
		</div>
		<img src="${LGuser.image_url}" height="120px" width="120px" class="p-1 rounded-circle bg-white" border="2px balck solid" >
	</div>
<div class="container border border-4 border-dark">
	
	<p class="text-danger">${errorMessage}</p>
	<form action="/devs/skills/languages" method="post">
	<div class="d-flex justify-content-between mt-3">
		<h4>Pick Your Top 5	Languages</h4>
		<ul onclick="chooseItem(event)"class="d-inline d-flex justify-content-between p-2 text-white">
    
			<li class="btn btn-secondary mx-3" >JAVA</li>
			<li class="btn btn-secondary mx-3">SQL</li>
			<li class="btn btn-secondary mx-3" >PYTHON</li>
			<li class="btn btn-secondary mx-3" >JS</li>
			<li class="btn btn-secondary mx-3">Angular</li>
			<li class="btn btn-secondary mx-3" >React</li>
			<li class="btn btn-secondary mx-3" >Bootstrap</li>
			<li class="btn btn-secondary mx-3">GO</li>
			<li class="btn btn-secondary mx-3" >HTML5</li>
			<li class="btn btn-secondary mx-3" >CSS</li>
				
		</ul>
	</div>
	<div class="d-flex justify-content-between">
		<div class="text-center">
            <div class="overflow-auto" style="height: 10rem;">
               <textarea name="languages" rows="6" class="form-control mb-4" id="response"></textarea>
            </div> 
        </div>
        <div>
        	<h4 class="mb-2">Short Bio</h4>
        	<textarea name="biography" rows="6" class="form-control mb-4 mt-2" placeholder="Add more about yourself here..."></textarea>
        </div>       
	</div>
	<div class="d-flex justify-content-end mb-4">
		<a href="/devs/skills/frameworks" class="btn btn-secondary mx-2">Skip This Step</a>
		<button type="submit" class="btn btn-primary">NEXT STEP :Frameworks & Libraries</button>
	
	</div>
	</form>
	
</div>

</body>
<script>
var items=[]
function chooseItem(event){
	
	var target = event.target || event.srcElement;
   
	var item =event.target.innerHTML;
	console.log(item);
	items.push(item);
	
	document.getElementById("response").innerHTML=items;
	return items;
}
chooseItem();
</script>

</html>