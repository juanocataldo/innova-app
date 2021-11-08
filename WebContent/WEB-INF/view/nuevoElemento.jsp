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
	<br>
	<a href="${pageContext.request.contextPath}/elementos" id="estado">
		<button type="submit" class="submit-atras btn btn-sm">
		<div class="d-flex flex-wrap justify-content-left" style="background-color: transparent;" >
			<span class="material-icons">arrow_back</span>
				<span>Atras</span>
			</div>
		</button>
	</a>
	<br><br>		

	<div class="cabeceraMov">
		<span>Nuevo Elemento</span>		
	</div>
	
	<div class="filtro">
	<span>Elemento a cargar</span> 
</div>
<div class="filtroCuerpo">
	<form:form action="addElemento" method="POST">
	
	<div class="row">
		<div class="col-md-6">
			<span>Nombre</span><br><input type="text" name="nombreElem" style="width:100%;" >	
		</div>
		
		<div class="col-md-6">
			<span>Tipo</span><br><select name="tipoElem" class="form-select form-select-sm form-select-innova minimal" style="width:100%">			    
			    <option value="21">Librería</option>			    			        
			</select>
		</div>
	</div>
	<br>
	<button type="submit" class="submit btn btn-sm">
		<div class="d-flex flex-wrap" style="background-color: transparent;" >							
			<span class="material-icons">add</span>
				<span>Agregar</span>
			</div>
		</button>		
	<br>
 	
 		</form:form>
</div>	
	
			
</div>


<div class="p-4">
	
</div>

</body>
</html>