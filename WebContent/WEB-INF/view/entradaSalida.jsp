<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrada Salida</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

<a href="${pageContext.request.contextPath}/nuevoMovimiento">Atrás</a>

<div class="row" style="padding-top:200px">
	<div class="col-md-12 text-center">
		<h2>
			${userSelected.nombre} ${userSelected.apellido} ${userSelected.id}
		</h2>

		
		
		
		
		<h4>Último movimiento</h4>
		
		<table class="table">
			<thead>
				<tr>					
					<td>Entrada</td>
					<td>Salida</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<c:choose>
						    <c:when test="${ingresoPersona.fechaIn}=null">
						        Sin movimiento
						        <br />
						    </c:when>    
						    <c:otherwise>
						        ${ingresoPersona.fechaIn} 
						        <br />
						    </c:otherwise>
						</c:choose>
					</td>
					
					<td>
						<c:choose>
						    <c:when test="${ingresoPersona.fechaFin}=null">
						        Sin movimiento
						        <br />
						    </c:when>    
						    <c:otherwise>
						        ${ingresoPersona.fechaFin} 
						        <br />
						    </c:otherwise>
						</c:choose>
					</td>
					
					
				</tr>
			</tbody>
		</table>
		
		<c:url var="guardarMovimiento" value="guardarMovimiento"> 
				<select name="item">
				    <option value="ingreso">Ingreso a Base</option>
				    <option value="egreso">Salida de Base</option>	    
				  </select>
				
				<c:param name="id" value="${userSelected.id}" />					
			</c:url>
		
				  
		<form:form action="guardarMovimiento">
		  <select name="item">
		    <option value="ingreso">Ingreso a Base</option>
		    <option value="egreso">Salida de Base</option>	    
		  </select>
			
			<input type="text" name="detalle" placeholder="Ingrese detalles del movimiento">
			<input style="display:none" type="text" name="id" value="${userSelected.id}">							
		  <input type="submit" value="Enviar">
		</form:form>
	</div>

</div>

		
		

</body>
</html>