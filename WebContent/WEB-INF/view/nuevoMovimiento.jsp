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
<title>Innova</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/search">Atrás</a>

<div class="text-center p-4">
	<form:form action="nuevoMovimiento" method="GET">
		Buscar Persona <input type="text" name="searchPerson" />
		
		<input type="submit" value="Buscar" />
	</form:form>
</div>



<div class="p-4">
	<table class="table text-center">
		<thead>
			<tr>				
				<td>Persona</td>
				<td>Acción</td>
			</tr>
		</thead>
		<tbody class="text-center">		
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
								<span class="material-icons" style="color: green">add_circle</span>
							</a>							
						</td> 						
					</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>

</body>
</html>