<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actividad usuario</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>


<form:form action="guardarMovimiento" modelAttribute="userSelected" method="POST">
		
		
		<!-- el id oculto para pasarlo al listado anterior -->
		<form:hidden path="id" />
		
		<div class="row p-4 text-center">
		<div class="col-md-12 text-center">
			<h2>Tipo de actividad : XXXXX</h2>		
		</div><br><br>
		<div class="col-md-12 text-center">
			Nombre de la persona<td><br><form:input path="nombre" /><br><form:input path="apellido" /></td>	
		</div><br><br><br><br>
		
		<div class="col-md-12 pt-2 text-center">
			Detalles<br><input type="text" />		
		</div>
		
		<input type="submit" value="Guardar" />
	</div>
	
</form:form>


</body>
</html>