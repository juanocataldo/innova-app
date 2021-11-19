<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
	<!DOCTYPE html>
	<html >
	<head>
   <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <title>SIFPA</title>
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  	
  	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
  	
  	
  	
  	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  
  
	<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
  	
  	<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
	
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
				
		
		<!-- <div class="filtro">
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
		</div>	-->
	</div>
	
	<div class="container mt-4">
		<div class="filtro">
			<span>Ingresos / Egresos</span>			
		</div>
		<div class="filtroCuerpo">
		
			<fmt:formatDate type="both" value="${Date}" />  
			
			<table id="tablaIngresos" class="table" style="width:100%; color:white">
		        <thead>
		            <tr>
		            	<th scope="col">Nombre</th>
		            	<th scope="col">Apellido</th>
		                <th scope="col">DNI</th>
		                <th scope="col">Llegada</th>
		                <th scope="col">Salida</th>
		                <th scope="col">Detalles</th>
		            </tr>
		        </thead>
		        <tbody>        	
		        </tbody>
		    </table>
			<!-- 
			<br><br>
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
			</table> -->
		</div>
	</div>

   <style>
           
           .dataTables_wrapper{
           	color:#DCDCDD;
           }
           
           </style> 

<script type="text/javascript">

var url_string = window.location.href; //window.location.href
var url = new URL(url_string);
var id = url.searchParams.get("id");

	$(document).ready(function() {
		$('#tablaIngresos').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/jsonEstadoSearch3',
			"dataSrc":'',
			"data":{id:id}
		},
		
		 "language": {
		        "sProcessing":    "Procesando...",
		        "sLengthMenu":    "Mostrar _MENU_ registros",
		        "sZeroRecords":   "No se encontraron resultados",
		        "sEmptyTable":    "Ningún dato disponible en esta tabla",
		        "sInfo":          "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		        "sInfoEmpty":     "Mostrando registros del 0 al 0 de un total de 0 registros",
		        "sInfoFiltered":  "(filtrado de un total de _MAX_ registros)",
		        "sInfoPostFix":   "",
		        "sSearch":        "Buscar:",
		        "sUrl":           "",
		        "sInfoThousands":  ",",
		        "sLoadingRecords": "Cargando...",
		        "oPaginate": {
		            "sFirst":    "Primero",
		            "sLast":    "Último",
		            "sNext":    "Siguiente",
		            "sPrevious": "Anterior"
		        },
		        "oAria": {
		            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
		            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
		        }
		    },
		"columns":[
			{"data": 'persona.nombre'},
			{"data": 'persona.apellido'},
			{"data": 'persona.dni'},
			{"data": 'fechaIn',
				"defaultContent": '<i style="color:#9b9b9b">-</i>'},
			{"data": 'fechaFin',
					"defaultContent": '<i style="color:#9b9b9b">-</i>'},
			{"data": 'detalles',
						"defaultContent": '<i style="color:#9b9b9b">-</i>'}
		]
	});
});
</script>


	</body>
	</html>