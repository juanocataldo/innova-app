<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html style="background-color:black;color:white">
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/mycss.css">
<title>Innova</title>
</head>
<body>
<br>

<div class="row bg-transparent text-center" style="color: rgb(255, 196, 0);;">
	<h1>Extensión SIFPA</h1>
</div>
<br>
<div class="container text-center">
	<div class="row text-center p-4" style="background-color:black;color:white">		
		<div class="col-md-12 text-center">
			<h2>INICIO</h2>		
			<button class="submit-menu btn btn-sm">
				<a href="${pageContext.request.contextPath}/estadoSearch">
					<div class="submit-menu d-flex flex-wrap">
						<span class="material-icons">meeting_room</span>PUESTO 1
					</div>
				</a>
			</button>		
	
			<button class="submit-menu btn btn-sm">
				<a href="${pageContext.request.contextPath}/elementos">
					<div class="submit-menu d-flex flex-wrap">
						<span class="material-icons">meeting_room</span>ECONOMATO
					</div>
				</a>
			</button>
		</div>
	</div>
</div>


</body>
</html>