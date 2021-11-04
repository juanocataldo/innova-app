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

		
	<a href="${pageContext.request.contextPath}/nuevoMovimiento" id="estado">
		<button type="submit" class="submit btn btn-sm" style="background-color: #46BA46">
		<div class="d-flex flex-wrap" style="background-color: transparent;" >
			<span class="material-icons">add</span>
				<span>Nuevo</span>
			</div>
		</button>
	</a>
	<br>		
</div>



<div class="filtro">
	<span>Filtros</span> 
</div>
<div class="filtroCuerpo">
	<form:form action="estadoSearch" method="GET">
	
	<div class="row">
		<div class="col-md-4">
			<span>Persona</span><br><input type="text" name="personaSearch" style="width:100%;" >	
		</div>
		
		<div class="col-md-4">
			<span>DNI</span><br><input type="text" name="dniSearch" style="width:100%;">	
		</div>
		
		<div class="col-md-4">
			<span>Estado</span><br>
			<select name="estadoSearch" class="form-select form-select-sm form-select-innova minimal" style="width:100%">
			    <option value="2" selected>Todos</option>
			    <option value="1">En Base</option>
			    <option value="0">Fuera de Base</option>			        
			</select>
		</div>
		
	</div>
	<br>
	<button type="submit" class="submit btn btn-sm">
		<div class="d-flex flex-wrap" style="background-color: transparent;" >							
			<span class="material-icons">search</span>
				<span>Buscar</span>
			</div>
		</button>		
	<br>
 	
 		</form:form>
</div>	
</div>

<div class="container mt-4">
<div class="filtro">
	<span>Estados</span> 	
</div>
<div class="filtroCuerpo">
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Persona</th>
				<th scope="col">DNI</th>
				<th scope="col" style="text-align:center">Estado</th>
				<th scope="col" style="text-align:center">Acción</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tempSemaforo" items="${listado}">
				<tr>
					
					<td>${tempSemaforo.persona.nombre} ${tempSemaforo.persona.apellido}</td>
					<td>${tempSemaforo.persona.dni}</td>
				
					<td style="text-align:center">
					<c:choose>
					    <c:when test="${tempSemaforo.estado == 1}">					       
					       <span class="material-icons" style="color:#46BA46">circle</span>
					    </c:when>    
					    <c:otherwise>
					    	<span class="material-icons" style="color:#515960">circle</span>
					    </c:otherwise>
					</c:choose>
					</td>
					
					<c:url var="viewMov" value="search"> 
						<c:param name="id" value="${tempSemaforo.persona.id}" />								
					</c:url>
					
					<td style="text-align:center; ">
					<a href="${viewMov}">
						<button class="botonAccion btn btn-sm" style="background-color:#5BBFDD;width:40px;font-size:5px">							
								<span class="material-icons" style="color:white">visibility</span>							
						</button>
					</a>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>

</div>	
</div>



</body>
</html>