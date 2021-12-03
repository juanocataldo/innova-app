<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>

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
	
	<link rel="apple-touch-icon" sizes="57x57" href="${pageContext.request.contextPath}/resources/img/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="${pageContext.request.contextPath}/resources/img/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/resources/img/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/img/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/resources/img/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/resources/img/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/resources/img/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/resources/img/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/img/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="${pageContext.request.contextPath}/resources/img/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/img/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/resources/img/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/img/favicon-16x16.png">
	<link rel="manifest" href="${pageContext.request.contextPath}/resources/img/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/resources/img/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">
	
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
                            <a href="${pageContext.request.contextPath}/nuevoMovB">Movimientos</a>
                        </li>
                    </ul>
                </li>           
                
                <li class="active" >
                    <a href="#homeSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle" style="background-color:#3A3F44;">Puesto 1</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu2">
                        <li>
                            <a href="${pageContext.request.contextPath}/estadoSearch">Estado Personal</a>
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

            <div class="container text-center" >
                
                <div class="cabeceraMov">
                    <span style="color:#F0B847">Nuevo Movimiento</span>		
                </div>
                
               
            <div class="filtroCuerpo">
            <form:form action="inOut" method="POST">
            
              
            <h4 style="text-align:left;color:white">Seleccionar movimiento</h4>
            	<select name="tipoMov" id="tipoMov" style="width:100%" class="form-select-innova">
					  <option value="1" selected>Entregar bienes</option>
					  <option value="2">Devolución de bienes</option>
					  <option value="3" disabled=disabled>Bien a Fuera de Servicio</option>
					</select>
            
            
            
           
        
         <div class="" id="personaShow" style="display:none;">
    	<div class="filtroCuerpo">
    		<div class="row">
                    <div class="col-md-6">
                        <span>DNI</span><br><input type="text"  style="width:100%;" name="dniSearch" id="dniSearch" >
                    </div>

                    <div class="col-md-3">
                        <span>Persona</span><br><h5 style="color:white" id="result1"></h5>
                    </div>     
                    <div class="col-md-3">
						<input class="btn btn-sm submit" type="button" value="Buscar persona" id="buttonDemo1">                    
                    </div>               
                </div>
             
    	</div>  
</div>
          <button type="submit" class="submit btn btn-sm">
                    <div class="d-flex flex-wrap" style="background-color: transparent;" >
                            <span>Siguiente</span>
                        </div>
                    </button>	
                    <br><br>	
                    
			</form:form>
        </div>
    </div><br>
    
    <div class="container">
    
      <div class="filtro">
                <span>Listado Movimientos</span> 
            </div>
           
            <div class="filtroCuerpo">
            	
            	<table id="tablaMovs" class="table " style="width:100%; color:white">
            		<thead>
            			<tr>
            				<th scope="col">ID</th>
            				<th scope="col">Nombre</th>
            				<th scope="col">Apellido</th>
            				<th scope="col">Bien Consumo</th>
            				<th scope="col">Bien Uso</th>
            				<th scope="col">Cantidad</th>
            				<th scope="col">Actividad</th>
            				<th scope="col" class="text-center">Acción</th>            				
            			</tr>
            		</thead>
            		<tbody>
            		</tbody>
            	</table>
            	            
           </div>  
    
    </div>
    
   
</div>


</div>
 <style>
    	.filtro{
    	cursor: pointer;}
    </style>
    
    
   <style>
           
           .dataTables_wrapper{
           	color:#DCDCDD;
           }
           
           </style> 
      <!-- jQuery CDN - Slim version (=without AJAX) -->
    
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    
    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
        
        
        
        $(document).ready(function(){
            $('#tipoMov').on('change', function() {
              if ( this.value == '2')
              {
                $("#personaShow").show();
              }
              else
              {
                $("#personaShow").hide();
              }
            });
        });
    </script>
    
     <script>

	$(document).ready(function(){
		$('#buttonDemo1').click(function(){
			var dni = parseInt($('#dniSearch').val());
			
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
	$(document).ready(function() {
		
		fila = $(this).closest("tr");
		estado = parseInt(fila.find('td:eq(3)').text());
		
		$('#tablaMovs').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/listadoMovimientos',
			"dataSrc":''
			
		},
		"language": {
	        "sProcessing":    "Procesando...",
	        "sLengthMenu":    "_MENU_ ",
	        "sZeroRecords":   "No se encontraron resultados",
	        "sEmptyTable":    "Ningún dato disponible en esta tabla",
	        "sInfo":          "_START_ 	al 	_END_ 	de 	_TOTAL_ ",
	        "sInfoEmpty":     "Mostrando registros del 0 al 0 de un total de 0 registros",
	        "sInfoFiltered":  "(filtrado de un total de _MAX_ registros)",
	        "sInfoPostFix":   "",
	        "sSearch":        "Buscar:",
	        "sUrl":           "",
	        "sInfoThousands":  ",",
	        "sLoadingRecords": "Cargando...",
	        "oPaginate": {
	            "sFirst":    '<span style="cursor: pointer;color:#DCAB46;"><<	</span>',
	            "sLast":    '<span style="cursor: pointer;color:#DCAB46;">	>></span>',
	            "sNext":    '<span style="cursor: pointer;color:#DCAB46;">	></span>',
	            "sPrevious": '<span style="cursor: pointer;color:#DCAB46;"><	</span>'
	        },
	        "oAria": {
	            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	        }
	    },
		"columns":[
			{"data": 'id'},
			{"data": 'persona.nombre'},
			{"data": 'persona.apellido'},
			{"data": 'bienUso.nombre',
				"defaultContent": '<i style="color:#9b9b9b">-</i>'},
			{"data": 'bienConsumo.nombre',
					"defaultContent": '<i style="color:#9b9b9b">-</i>'},				
			{"data": 'cant',
					"defaultContent": '<i style="color:#9b9b9b">-</i>'},
			{"data" : 'tipoMovId',
						
						"render": function(data, type, row){
							if(data == 1){
								return '<span class="material-icons" style="color:green;font-size:40px">arrow_circle_up</span>';
							}else{
								return '<span class="material-icons" style="color:grey;font-size:40px">arrow_circle_down</span>';
							}	
						} },
			{"defaultContent":
				'<div class="text-center"><button class="btnAddBc botonAccion btn btn-sm" style="background-color:#5BBFDD;width:40px;font-size:5px"><span class="material-icons" style="color:white">visibility</span></button></div>'
			}
		]
	});
});
</script>
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
</body>

</html>