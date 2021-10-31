<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
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

<div class="container">	

<div class="cabecera">
	<span>Estado de Personal</span>	
</div>

<div class="row p-4" style="background-color: transparent;">
	<a class="atras" href="${pageContext.request.contextPath}/search" id="estado"><button class="atras btn btn-sm">Atras</button></a>
</div>

<div class="filtro">
	<span>Filtros</span> 
</div>
<div class="filtroCuerpo">
	<form:form action="estadoSearch" method="GET">
 			<span>Persona</span><br><input type="text" name="personaSearch">
 			<button type="submit" class="submit btn btn-sm">Buscar</button>
 		</form:form>
</div>	
</div>

<div class="container mt-4">
<div class="filtro">
	<span>Estados</span> 	
</div>
<div class="filtroCuerpo">
	
	<table class="table table-hover">
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
</div>



</body>
</html>