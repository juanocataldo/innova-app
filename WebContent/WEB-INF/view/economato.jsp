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
	<span>Elementos Economato</span>

		
	<a href="${pageContext.request.contextPath}/nuevoElemento" id="estado">
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
	<form:form action="elementoSearch" method="GET">
	
	<div class="row">
		<div class="col-md-4">
			<span>Elemento</span><br><input type="text" name="elemNombre" style="width:100%;" >	
		</div>
		
		<div class="col-md-4">
			<span>Tipo</span><br><select name="elemTipo" class="form-select form-select-sm form-select-innova minimal" style="width:100%">
			    <option value="2" selected>Todos</option>
			    <option value="21">Lapiceras</option>			    			        
			</select>	
		</div>
		
		<div class="col-md-4">
			<span>Estado</span><br>
			<select name="elemEstado" class="form-select form-select-sm form-select-innova minimal" style="width:100%">
			    <option value="2" selected>Todos</option>
			    <option value="1">Entregado</option>
			    <option value="0">Stock</option>			        
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
				<th scope="col">ID</th>
				<th scope="col">Nombre</th>
				<th scope="col">Tipo</th>
				<th scope="col">Estado</th>
				<th scope="col">Acción</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tempElemento" items="${listado}">
				<tr>
					<td>${tempElemento.id}</td>
					<td>${tempElemento.nombre}</td>
					<td>${tempElemento.tipo}</td>
					<td>${tempElemento.estado}</td>
					<td>Editar/Baja</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>

</div>	
</div>



</body>
</html>