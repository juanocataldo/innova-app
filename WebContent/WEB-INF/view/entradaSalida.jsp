<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html >
<head >
<meta charset="ISO-8859-1">
<title>Entrada Salida</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/mycss.css">	
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>
<body >


<div class="container">
	<div class="cabeceraMov">
		<span>Nuevo ingreso/egreso</span>		
	</div>

	<div class="row p-4" style="background-color: transparent;">
		<button class="atras btn btn-sm"><a href="${pageContext.request.contextPath}/nuevoMovimiento" id="estado">Atras</a></button>
	</div>

	
	<div class="filtro">
		<span>Generar Movimiento:  ${userSelected.nombre} ${userSelected.apellido}</span> 
	</div>
	<div class="filtroCuerpo mb-4">
		<form:form action="guardarMovimiento" >		  
			<div class="form-group">
			<span>Seleccionar movimiento</span>
				 <select name="item" class="form-select form-select-sm form-select-innova">		    		
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
			
			<br><br>
			
				<span>Detalles del movimiento</span><br> 
				<input type="text" name="detalle" id="detalles" placeholder="Ingrese detalles del movimiento">
			   
			   <input style="display:none" type="text" name="id" value="${userSelected.id}">							
			   
			   <button type="submit" class="submit btn btn-sm">Enviar</button>	
			</div>
		 
		   
		   
	   </form:form>
	</div>

	<div class="filtro">
		<span>�ltimo movimiento realizado</span> 
	</div>
	<div class="filtroCuerpo">
		<table class="table table-hover">
			<thead>
				<tr>				
					<td>Persona</td>
					<td>Entrada</td>
					<td>Salida</td>
				</tr>
			</thead>
			<tbody>
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
	</div>	
</div>

</body>
</html>