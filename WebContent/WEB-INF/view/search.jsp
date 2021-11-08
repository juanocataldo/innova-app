<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
	</head>
	<body>
		
	
	
	<div class="container">	
	<br>
	<a href="${pageContext.request.contextPath}/estadoSearch" id="estado">
		<button type="submit" class="submit-atras btn btn-sm">
		<div class="d-flex flex-wrap justify-content-left" style="background-color: transparent;" >
			<span class="material-icons">arrow_back</span>
				<span>Atras</span>
			</div>
		</button>
	</a>
	<br><br>		
		<div class="cabecera">
			<span>Movimientos </span>					
		</div>
				
		
		<div class="filtro">
			<span>Filtros</span> 
		</div>
		<div class="filtroCuerpo">
			<form:form action="searchFecha" method="GET">
				<span>Fecha<br><input type="text" id="datepicker" name="fechaSearch" style="width:100%"></span><br>				
				
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
			<span>Ingresos / Egresos</span>			
		</div>
		<div class="filtroCuerpo">
		
			<fmt:formatDate type="both" value="${Date}" />  
			<table class="table">
				<thead>
					<tr>				
						<td>Persona</td>
						<td>DNI</td>							
						<td>Llegada</td>
						<td>Salida</td>				
						<td>Detalles</td>
					</tr>
				</thead>
				<tbody >
				  
					<c:forEach var="tempIngresos" items="${ingresos}">				
						<tr>
							<td>${tempIngresos.persona.nombre} ${tempIngresos.persona.apellido}</td>
							<td>${tempIngresos.persona.dni}</td>
							<td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${tempIngresos.fechaIn}" /></td>
							<td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${tempIngresos.fechaFin}" /></td>
							<td>${tempIngresos.detalles}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	</body>
	</html>