<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html style="background-color:black;color:white">
<head>
<meta charset="ISO-8859-1">
<title>Buscar usuario</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
 





<div class="p-4" style="background-color:black;color:white">
<a href="${pageContext.request.contextPath}/estadoSearch" style="color:yellow">Estado</a><br>
<a href="${pageContext.request.contextPath}/nuevoMovimiento" class="mb-4" style="color:yellow">Nuevo Movimiento</a> 
 <br><br><br>
 
 
 <div class="row text-center">
 <h2 style="color:yellow">Filtros</h2>
 	<div class="col-md-12">
 		<form:form action="search" method="GET">
 			<span>Persona</span><br><input type="text" name="personaSearch">
 			<input type="submit" value="Buscar" />
 		</form:form>
 	</div> 	
 	
 </div>
 
 <br><br><br><br>
 
 <h2 style="color:yellow">Listado de Ingresos/Egresos</h2>
	<table class="table table-striped table-dark text-center">
		<thead>
			<tr>				
				<td>Persona</td>							
				<td>Llegada</td>
				<td>Salida</td>				
			</tr>
		</thead>
		<tbody class="text-center">
		
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

</body>
</html>