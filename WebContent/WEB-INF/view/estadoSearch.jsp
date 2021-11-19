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
    <title>SIFPA</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  	
  	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/style.css">
  	<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
	<!-- 
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/style.css">  
  	
  	
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    
  	<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
    
	 -->
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
    
            
        <!-- <a href="${pageContext.request.contextPath}/nuevoMovimiento" id="estado"> -->
            <button id="btnNuevo" class="submit btn btn-sm" style="background-color: #46BA46">
            <div class="d-flex flex-wrap" style="background-color: transparent;" >
                <span class="material-icons">add</span>
                    <span>Nuevo</span>
                </div>
            </button>
        <!-- </a> -->
        <br>		
    </div>
    
    <!-- 
    
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
    <div class="filtroCuerpo" style="color:white"> -->
        
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
        <div class="filtro">
                    <span>Estados</span> 	
                </div>
        
     <div class="filtroCuerpo">
        <table id="tablaUsuarios" class="table" style="width:100%; color:white">
        <thead>
            <tr>
            	<th scope="col">ID</th>
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
    
    
           <style>
           
           .dataTables_wrapper{
           	color:#DCDCDD;
           }
           
           </style> 

    
    </div>




<div class="modal fade" id="modalCRUD" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="background-color:#3A3F44">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
        <form id="formUsuarios">    
            <div class="modal-body">
                <div class="row"  style="color:white">
                    <div class="col-lg-4">
                    <div class="form-group">
                    <label for="" class="col-form-label" >DNI</label>
                    <input type="text" id="dni">
                    </div>
                    </div>
                    <div class="col-lg-5">
	                    <div class="form-group">
		                    <label for="" class="col-form-label">Persona</label><br>
		                    <h5 id="result1"></h5>
	                    </div> 
                    </div>                    
                    <div class="col-lg-3">
	                    <div class="form-group">
		                    <br><input type="button" value="Buscar" id="buttonDemo1">
		                    </div> 
                    </div>    
                </div>    
				<div class="row" style="color:white">
					<div class="col-lg-12">
                        <div class="form-group">
                        <label for="" class="col-form-label">Acción</label><br>
                       <select id="item" name="item" class="form-select form-select-sm form-select-innova" style="width:100%">
							<option value="ingreso">Ingreso a Base</option>
							<option value="egreso">Salida de Base</option>
			 			</select>
                        
                        </div>
                    </div>
				</div>        
				
				<div class="row" style="color:white">
					<div class="col-lg-12">
                       <div class="form-group">
                        <label for="" class="col-form-label">Detalles</label>
                        <input type="text" id="detalles">
                        </div> 
                    </div>
				</div>
				            
			                
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" data-dismiss="modal">Cancelar</button>
                <button type="submit" id="btnGuardar" class="btn btn-success">Guardar</button>
            </div>
        </form>    
        </div>
    </div>
</div>  

<script>



var dni;
$('#formUsuarios').submit(function(e){                         
   // e.preventDefault(); //evita el comportambiento normal del submit, es decir, recarga total de la página
    dni = $.trim($('#dni').val());
    detalles = $.trim($('#detalles').val());
    item = $('#item option:selected').val();
                                
        $.ajax({
          url: "${pageContext.request.contextPath}/ajaxEstado",
          type: "GET",
          datatype:"json",    
          data:  {dni:dni, detalles:detalles, item:item},    
          success: function(data) {
        	  $('#tablaUsuarios').DataTable().ajax.reload(null, false);
           }
        });			        
    $('#modalCRUD').modal('hide');											     			
});
        
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#tablaUsuarios').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/jsonEstadoSearch',
			"dataSrc":''
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
			{"data": 'persona.id'},
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
				'<div class="text-center"><button class="btnEditar botonAccion btn btn-sm" style="background-color:#5BBFDD;width:40px;font-size:5px"><span class="material-icons" style="color:white">visibility</span></button></div>'
			}
		]
	});
});
</script>

<script>
	$(document).ready(function(){
		$('#buttonDemo1').click(function(){
			var dni = $('#dni').val();
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/test2/'+dni+'',
				success: function(result){
					$('#result1').html(result);
				}
			})
		})
	})
</script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
        

        
        $(document).on("click", ".btnEditar", function(){		        
        	
            fila = $(this).closest("tr");	        
            id = parseInt(fila.find('td:eq(0)').text()); //capturo el ID		            
            nombre = fila.find('td:eq(1)').text();
            apellido = fila.find('td:eq(2)').text();
            estado = fila.find('td:eq(3)').text();
                        
            location.href = "${pageContext.request.contextPath}/search?id="+id+"";
            
            		   
        });
        
        
        $("#btnNuevo").click(function(){
                       
            user_id=null;
            
            $(".modal-header").css( "background-color", "#272B30");            
            $(".modal-header").css( "color", "white" );
            $(".modal-header").css( "font-size", "20px" );
            $(".modal-title").text("Actividad de Personal");
            $('#modalCRUD').modal('show');	    
        });
    </script>
    <style>
    	.filtro{
    	cursor: pointer;}
    </style>
    
    <script>
    $(".filtro").click(function () {

        $header = $(this);
        //getting the next element
        $content = $header.next();
        //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
        $content.slideToggle(500, function () {
            //execute this after slideToggle is done
            //change text of header based on visibility of content div
            $header.text(function () {
                //change text based on condition
                //return $content.is(":visible") ? "Collapse" : "";
            });
        });

    });
    </script>
    
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
    
</html>