<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
	<!DOCTYPE html>
	<html >
	<head>
	<meta charset="ISO-8859-1">
	<title>Buscar usuario</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
	<link rel="stylesheet"
			  href="https://fonts.googleapis.com/css?family=Tangerine">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/mycss.css">
	</head>
	<body>
		
	
	
	<div class="container">	
	
		<div class="cabecera">
			<span>Movimientos </span>
			<button class="nuevoBoton btn btn-sm"><a href="${pageContext.request.contextPath}/nuevoMovimiento" id="estado">Nuevo</a></button><br>		
		</div>
		<div class="filtro">
			<span>Filtros</span> 
		</div>
		<div class="filtroCuerpo">
			<form:form action="search" method="GET">
				<span>Persona</span><br><input type="text" name="personaSearch">
				
				<button type="submit" class="submit btn btn-sm">Buscar</button>
			</form:form>
		</div>	
	</div>
	
	<div class="container mt-4">
		<div class="filtro">
			<span>Ingresos / Egresos</span> 
			<button class="nuevoBoton btn btn-sm" style="background-color: #006BBD;"><a href="${pageContext.request.contextPath}/estadoSearch" id="estado">Estado</a></button><br>
		</div>
		<div class="filtroCuerpo">
			<table class="table table-hover">
				<thead>
					<tr>				
						<td>Persona</td>							
						<td>Llegada</td>
						<td>Salida</td>				
					</tr>
				</thead>
				<tbody >
				
					<c:forEach var="tempIngresos" items="${ingresos}">
					<!--<c:url var="UpdateLink" value="actividadPersona"> 
									<c:param name="id" value="${tempUsers.id}" />
										
								</c:url>-->
							<tr>												
							<td>${tempIngresos.persona.nombre} ${tempIngresos.persona.apellido}</td>						
							<td>${tempIngresos.fechaIn}</td>
							<td>${tempIngresos.fechaFin}</td>
								<!-- <td>
								
									
									<c:choose>
										<c:when test="${tempIngresos.fechaIn != null}">
											<i class="material-icons p-2" style="color:grey">person_add</i>	
											
											<a href="${UpdateLink}">
												<i class="material-icons p-2" style="color:red">person_off</i>	
											</a>						        
										</c:when>    
										<c:otherwise>
											<a href="${UpdateLink}">
												<i class="material-icons p-2" style="color:green">person_add</i>	
											</a>		
											<i class="material-icons p-2" style="color:grey">person_off</i>			        
										</c:otherwise>
									</c:choose>
									
								
								
									
								</td> 		 -->				
							</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>	
	</div>
	
	
	</body>
	</html>