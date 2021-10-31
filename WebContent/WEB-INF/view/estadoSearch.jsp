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
<title>Innova</title>
</head>
<body >
<br>

<div class="row p-4" style="background-color:black;color:white">
	<a href="${pageContext.request.contextPath}/search" style="color:yellow">Ver Movimientos</a>
	
	<br><br><br><br>
	<h2>Estado Ingresos</h2>
	
	 
 <div class="row text-center">
 <h2 style="color:yellow">Filtros</h2>
 	<div class="col-md-12">
 		<form:form action="estadoSearch" method="GET">
 			<span>Persona</span><br><input type="text" name="personaSearch">
 			<input type="submit" value="Buscar" />
 		</form:form>
 	</div> 	
 	
 </div>
	
	
	<table class="table table-dark m-4 text-center table-striped">
		<thead>
			<tr>
				<th scope="col">Persona</th>
				<th scope="col">Estado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tempSemaforo" items="${listado}">
				<tr>
					
					<td>${tempSemaforo.persona.nombre} ${tempSemaforo.persona.apellido}</td>
					
				
					<c:choose>
					    <c:when test="${tempSemaforo.estado == 1}">
					        <td><span class="material-icons" style="color:green">circle</span></td>
					    </c:when>    
					    <c:otherwise>
					    	<td><span class="material-icons" style="color:red">circle</span></td>
					    </c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>



</body>
</html>