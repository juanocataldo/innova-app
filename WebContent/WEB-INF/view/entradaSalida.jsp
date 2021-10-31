<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html style="background-color:black">
<head >
<meta charset="ISO-8859-1">
<title>Entrada Salida</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body style="background-color:black; color:white">

<a href="${pageContext.request.contextPath}/nuevoMovimiento">Atrás</a>

<div class="row p-4" style="padding-top:100px">
	<div class="col-md-12 text-center">
		

				
	<h4>Movimientos</h4>	
	<table class="table text-center table-dark table-striped">
		<thead>
			<tr>				
				<td>Persona</td>
				<td>Entrada</td>
				<td>Salida</td>
			</tr>
		</thead>
		<tbody class="text-center">
					<tr>
						<td>
							<span>${userSelected.nombre} ${userSelected.apellido} ${userSelected.id}</span>
						</td>
						<td>
							${ingresoPersona.fechaIn}							
						</td>						 						
						<td>
								${ingresoPersona.fechaFin}						
						</td>
					</tr>			
		</tbody>
	</table>
		<!-- 
		<c:url var="guardarMovimiento" value="guardarMovimiento"> 
				<select name="item">
				<c:choose>
						    <c:when test="${ingresoPersona.fechaFin}==null">
								<option value="ingreso" disabled=disabled>a</option>
				    			<option value="egreso">Salida de Base</option>
						    </c:when>    
						    <c:otherwise>
								<option value="ingreso" >b</option>
				    			<option value="egreso" disabled=disabled>Salida de Base</option>
						    </c:otherwise>
						</c:choose>
	    
				  </select>
				
				<c:param name="id" value="${userSelected.id}" />					
			</c:url> -->
	<br><br><br>
	<div class="container-fluid">
		<div class="row d-flex justify-content-center">		
			<h5>Tipo de movimiento</h5>
			<form:form action="guardarMovimiento" style="width:60%" >		  
			 <div class="form-group">
			 	 <select name="item" class="form-select form-select-sm">		    		
			    				<c:if test="${(empty ingresoPersona.fechaIn) and (not empty ingresoPersona.fechaFin)}">
									<option value="ingreso" >Ingreso a Base</option>
					    			<option value="egreso" disabled=disabled>Salida de Base</option>
							    </c:if>
							    
							    <c:if test="${(not empty ingresoPersona.fechaIn) and (empty ingresoPersona.fechaFin)}">
									<option value="ingreso" disabled=disabled>Ingreso a Base</option>
					    			<option value="egreso" >Salida de Base</option>
							    </c:if>
							    
							    <c:if test="${(empty ingresoPersona.fechaIn) and (empty ingresoPersona.fechaFin)}">
									<option value="ingreso" >Ingreso a Base</option>
					    			<option value="egreso" >Salida de Base</option>
							    </c:if>	   
			  </select>
			 </div>
			 <br><br>
			 <div class="form-group">
			 	<h5>Detalles del movimiento</h5>
		 		<input type="text" name="detalle" placeholder="Ingrese detalles del movimiento">
				<input style="display:none" type="text" name="id" value="${userSelected.id}">							
				<input type="submit" value="Enviar">	
		 	</div>
		  
			
			
		</form:form>
		
	</div>	  
	</div>
	
		
	</div>

</div>

		
		

</body>
</html>