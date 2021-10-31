<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/mycss.css">
<title>Innova</title>
</head>
<body >

<div class="container">	

	<div class="cabeceraMov">
		<span>Nuevos movimientos</span>		
	</div>

	<div class="row p-4" style="background-color: transparent;">
		<button class="atras btn btn-sm"><a href="${pageContext.request.contextPath}/search" id="estado">Atras</a></button>
	</div>

	<div class="filtro">
		<span>Filtros</span> 
	</div>
	<div class="filtroCuerpo">
		<form:form action="nuevoMovimiento" method="GET">
		<span style="color:white">Persona</span><br>
		 <input type="text" name="searchPerson" />
		
		<button type="submit" class="submit btn btn-sm">Buscar</button>
	</form:form>
	</div>	
	
	
	
	<div class="filtro mt-4">
		<span>Seleccione Persona</span> 
	</div>
	<div class="filtroCuerpo">
		<table class="table table-hover">
			<thead>
				<tr>				
					<td>Persona</td>
					<td>Actividadn</td>
				</tr>
			</thead>
			<tbody>		
				<c:forEach var="tempPersonas" items="${searchUsers}">
				
				<c:url var="addPerson" value="addPerson"> 
					<c:param name="id" value="${tempPersonas.id}" />								
				</c:url>
	
						<tr>
							<td>
								${tempPersonas.nombre} ${tempPersonas.apellido}
							</td>
	
							<td>
								<a href="${addPerson}">
									<span class="material-icons" style="color: white">add_circle</span>
								</a>							
							</td> 						
						</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>	
</div>


<div class="p-4">
	
</div>

</body>
</html>