<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<style>
	table.dataTable thead {
		color:white;
	}
</style>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <title>SIFPA</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/style.css">

    <!-- Font Awesome JS -->
   
  
    
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>

<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>



  <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
    

</head>

<body>
    <div class="wrapper" >
        <!-- Sidebar  -->
      <nav id="sidebar" style="background-color: #3A3F44;">
            <div class="sidebar-header" style="background-color: #3A3F44;">
                <div class="row text-left">
                    <div class="col-md-12">
                        <img src="${pageContext.request.contextPath}/resources/img/fpa.png" width="70%" alt="">
                    </div>
                </div>
            </div>

            <ul class="list-unstyled components" style="background-color: #3A3F44;border-bottom: none;">
                
                <li class="active" >
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle" style="background-color:#3A3F44;">Economato</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="${pageContext.request.contextPath}/bienesUso">Bienes de Uso</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/elementos">Bienes de Consumo</a>
                        </li>
                        <li>
                            <a href="#">Movimientos</a>
                        </li>
                    </ul>
                </li>           
                
                <li class="active" >
                    <a href="#homeSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle" style="background-color:#3A3F44;">Puesto 1</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu2">
                        <li>
                            <a href="${pageContext.request.contextPath}/estadoSearch">Estado Personal</a>
                        </li>                        
                        <li>
                            <a href="${pageContext.request.contextPath}/nuevoMovimiento">Movimientos</a>
                        </li>
                    </ul>
                </li>       
            </ul>         
        </nav>

        <!-- Page Content  -->
        <div id="content" style="background-color: #272B30;">

            <nav class="navbar navbar-expand-lg " style="background-color: #272B30;">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-bars"></i>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                  
                </div>
            </nav>

            
<div class="container">	

    <div class="cabecera">
        <span>Estado de Personal</span>
    
            
        <a href="${pageContext.request.contextPath}/nuevoMovimiento" id="estado">
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
        <form:form action="estadoSearch" method="GET">
        
        <div class="row">
            <div class="col-md-4">
                <span>Persona</span><br><input type="text" name="personaSearch" style="width:100%;" >	
            </div>
            
            <div class="col-md-4">
                <span>DNI</span><br><input type="text" name="dniSearch" style="width:100%;">	
            </div>
            
            <div class="col-md-4">
                <span>Estado</span><br>
                <select name="estadoSearch" class="form-select form-select-sm form-select-innova minimal" style="width:100%">
                    <option value="2" selected>Todos</option>
                    <option value="1">En Base</option>
                    <option value="0">Fuera de Base</option>			        
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
    <div class="filtroCuerpo" style="color:white">
        
         <!-- <table class="table">
            <thead>
                <tr>
                    <th scope="col">Persona</th>
                    <th scope="col">DNI</th>
                    <th scope="col" style="text-align:center">Estado</th>
                    <th scope="col" style="text-align:center">Acción</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tempSemaforo" items="${listado}">
                    <tr>
                        
                        <td>${tempSemaforo.persona.nombre} ${tempSemaforo.persona.apellido}</td>
                        <td>${tempSemaforo.persona.dni}</td>
                    
                        <td style="text-align:center">
                        <c:choose>
                            <c:when test="${tempSemaforo.estado == 1}">					       
                               <span class="material-icons" style="color:#46BA46">circle</span>
                            </c:when>    
                            <c:otherwise>
                                <span class="material-icons" style="color:#515960">circle</span>
                            </c:otherwise>
                        </c:choose>
                        </td>
                        
                        <c:url var="viewMov" value="search"> 
                            <c:param name="id" value="${tempSemaforo.persona.id}" />								
                        </c:url>
                        
                        <td style="text-align:center; ">
                        <a href="${viewMov}">
                            <button class="botonAccion btn btn-sm" style="background-color:#5BBFDD;width:40px;font-size:5px">							
                                    <span class="material-icons" style="color:white">visibility</span>							
                            </button>
                        </a>
                        </td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table> -->
        <br>
        <table id="tablaUsuarios" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Estado</th>
                <th scope="col" style="text-align:center">Acción</th>
            </tr>
        </thead>
        <tbody>        	
        </tbody>
    </table>
    
    </div>	
    </div>
    
    
            

        </div>
    </div>


<script>
	$(document).ready(function() {
		$('#tablaUsuarios').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/jsonEstadoSearch',
			"dataSrc":''
		},
		"columns":[			
			{"data": 'persona.nombre'},
			{"data": 'persona.apellido'},
			{"data": 'estado',
			
				"render": function(data, type, row){
					if(data == 0){
						return '<span class="material-icons" style="color:grey">circle</span>';
					}else{
						return '<span class="material-icons" style="color:green">circle</span>';
					}	
				} 
				
				},
			{"defaultContent":
				'<a href="${viewMov}"><button class="botonAccion btn btn-sm" style="background-color:#5BBFDD;width:40px;font-size:5px"><span class="material-icons" style="color:white">visibility</span></button></a>'
			}
		]
	});
});
</script>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
<!--      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    
    
    
<!-- Bootstrap JS -->
	
    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>
    
</html>