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


 <style>
           
           .dataTables_wrapper{
           	color:#DCDCDD;
           }
</style>

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

            <input type="hidden" id="dni" name="dni" value="${dni}">

            <div class="container">	
               
                <div class="cabeceraMov">
                    <span>Nuevo Movimiento</span>		
                </div>
            
            </div>
            
            <div class="container">	
               
                <br>      
                
                <div class="filtro mt-4 filtro">
                    <span>Lista Bienes a Cargo</span> 
                </div>
                <div class="filtroCuerpo">
                
                <table id="listBienesCargo" class="table " style="width:100%; color:white">
			        <thead>
			            <tr>
			            	<th scope="col">ID</th>
			            	<th scope="col">Bien Uso</th>			            	
			                <th scope="col">Stock</th>			                
			                <th scope="col" class="text-center">Actividad</th>			                
			            </tr>
			        </thead>
			        <tbody>        	
			        </tbody>
			    </table>
                
                
                
                
            </div>
            
	                    
              <div class="filtro mt-4 filtro">
                    <span>Elementos seleccionados</span> 
                </div>
                <div class="filtroCuerpo">
                	
                <table id="tablaSeleccionadosDev" class="table " style="width:100%; color:white">
			        <thead>
			            <tr>
			            	<th scope="col">ID</th>
			            	<th scope="col">Elemento</th>
			            	<th scope="col">Cantidad</th>			               		                
			            </tr>
				        </thead>
				       <tbody>        	
					</tbody>
				</table>
                
                
            
                <div class="row align-self-end">
                	    <button class="submitNuevo btn btn-sm" id="mov">
			                    <div class="d-flex flex-wrap" style="background-color: transparent;" >							
			                        <span class="material-icons">save</span>
		                            <span> Guardar</span>
		                        </div>
	                    </button>
                    
                     
                    <button class="btn btn-sm submit cancelar">
		                    <div class="d-flex flex-wrap" style="background-color: transparent;">		                        
	                            <span> Cancelar</span>
	                        </div>
                    </button>
                </div>
            
                	 
                  
                
            
                
                </div>
            
            
            <div class="p-4">
                
            </div>
    
            







        </div>
        
        
     
        
        
        
        <div class="modal fade" id="modalCRUDbu" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="background-color:#3A3F44">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
            
            
            
        <form id="formBU">    
            <div class="modal-body">
                <div class="row"  style="color:white">
                    <div class="col-lg-4">
                    <div class="form-group">
	                    <label for="" class="col-form-label" >ID</label>
	                    <input type="text" id="id2" disabled=disabled>
	                    <input type="hidden" id="cat2" disabled=disabled>
                    </div>
                    </div>
                    <div class="col-lg-5">
	                    <div class="form-group">
		                    <label for="" class="col-form-label" >Elemento</label>
                   			 <input type="text" id="nombre2" disabled=disabled>
	                    </div> 
                    </div>                    
                    <div class="col-lg-3">
	                    <div class="form-group">
		                     <label for="" class="col-form-label">Cantidad</label><br>
		                    <input name="cant2" id="cant2" type="number"  min="1" max="Max" value="1" maxlength="3">
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
            	 
        
    </div>

 

 <style>
    	.filtro{
    	cursor: pointer;}
    </style>
     <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    
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

<script type="text/javascript">
	$(document).ready(function() {
		$('#tablaSeleccionadosDev').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/listBienesSeleccioandosDev',
			"dataSrc":''
		},
		
		 "language": {
		        "sProcessing":    "Procesando...",
		        "sLengthMenu":    "Mostrar _MENU_ registros",
		        "sZeroRecords":   "No se encontraron resultados",
		        "sEmptyTable":    "Ningún dato disponible en esta tabla",
		        "sInfo":          "_START_ al _END_ de _TOTAL_ ",
		        "sInfoEmpty":     "0 registros",
		        "sInfoFiltered":  "(filtrado de un total de _MAX_ registros)",
		        "sInfoPostFix":   "",
		        "sSearch":        "Buscar:",
		        "sUrl":           "",
		        "sInfoThousands":  ",",
		        "sLoadingRecords": "Sin elementos",
		        "oPaginate": {
		            "sFirst":    "Primero ",
		            "sLast":    " Último",
		            "sNext":    "- Siguiente",
		            "sPrevious": "Anterior- "
		        },
		        "oAria": {
		            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
		            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
		        }
		    },
		"columns":[
			{"data": 'id',
				"defaultContent":"-"},
			{"data": 'nombre',
				"defaultContent":"-"},
			{"data": 'stock',
				"defaultContent":"-"}
			
			
		]
	});
});
</script>
<script type="text/javascript">
	$(document).ready(function() {

		var dni = $.trim($('#dni').val());

		$('#listBienesCargo').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/listBienesCargo',
			"dataSrc":'',
			"data":{dni:dni}
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
			{"data": 'bienUso.id'},			
			{"data": 'bienUso.nombre',
				"defaultContent": '<i style="color:#9b9b9b">-</i>'},							
			{"data": 'cant',
					"defaultContent": '<i style="color:#9b9b9b">-</i>'},					
			{"defaultContent":
				'<div class="text-center"><button class="btnAddBu botonAccion btn btn-sm" style="background-color:green;width:40px;font-size:5px"><span class="material-icons" style="color:white">add</span></button></div>'
			}
		]
	});
});
</script>
    







    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>



<script>

$('#formBU').submit(function(e){                         
	  e.preventDefault(); //evita el comportambiento normal del submit, es decir, recarga total de la página
	  var id = $.trim($('#id2').val());	  
	  var cant = $.trim($('#cant2').val());
	  
	      $.ajax({
	        url: "${pageContext.request.contextPath}/listBienesSeleccioandosDev",
	        type: "GET",
	        datatype:"json",    
	        data:  {id:id, cant:cant},    
	        success: function(data) {
	        	$('#tablaSeleccionadosDev').DataTable().ajax.reload(null, false);
	         }
	      });			        
	  $('#modalCRUDbu').modal('hide');											     			
	});
</script>
    
    <script>
    $(document).on("click", ".cancelar", function(){	        
        
   	 $.ajax({
   	        url: "${pageContext.request.contextPath}/limpiar",
   	        type: "GET",
   	        datatype:"json",
   	        success: function(data) {
   	        	$('#tablaSeleccionadosDev').DataTable().ajax.reload(null, false);
   	         }
   	      });
   });
    </script>
    
    <script>
    $(document).on("click", ".btnAddBu", function(){	        
        
        fila = $(this).closest("tr");	        
        id = parseInt(fila.find('td:eq(0)').text()); //capturo el ID		            
        nombre = fila.find('td:eq(1)').text();
        cant = fila.find('td:eq(2)').text();
        
        $("#id2").val(id);
        $("#nombre2").val(nombre);
        $("#cant2").val("1");
        
        var input = document.getElementById("cant2");
        
        input.setAttribute("max", cant);
       
        $(".modal-header").css("background-color", "#D4B557");
        $(".modal-header").css("color", "black" );
        $(".modal-title").text("Asignar elementos");		
        $('#modalCRUDbu').modal('show');	
        
        
        $('#cant2').on('change keyup', function() {
        	  var res = $(this).val()
        	  console.log(res.length);
        	  if(res.length > 3) $(this).val(res.substring(0, 3));
        	});

        
        function isNumberKey(e) {
            if(e.which === 13 || e.which === 8) return true;
            var currentChar = parseInt(String.fromCharCode(e.which), 10);
            if(!isNaN(currentChar)){
                var nextValue = $("#cant2").val() + currentChar; //It's a string concatenation, not an addition

                if(parseInt(nextValue, 10) <= cant) return true;
            }

            return false;
        }
        
    });
    
</script>
    
    <script>

	$(document).ready(function(){
		$('#buttonDemo1').click(function(){
			var dni = parseInt($('#dni').val());
			
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
    
  <script>
    $(document).ready(function(){
		$('#mov').click(function(){
			var dni = parseInt($('#dni').val());
			
			//var table = $('#tablaSeleccionados').DataTable();
			
			var table = $('#tablaSeleccionadosDev').DataTable().rows().data().toArray();
			
			var tipoMov= 2;
		
			var cant = $.trim($('#cant2').val());
			
			$.ajax({
				type:'POST',				
				url:'${pageContext.request.contextPath}/saveMovBienesDev',
				data:  JSON.stringify({ dni:dni, table:table, tipoMov:tipoMov, cant:cant}),
				dataType: "json",
				contentType: 'application/json'				
			})
			.done(function() {
				window.location = '${pageContext.request.contextPath}/nuevoMovB';
			})
			.fail(function(){
				window.location = '${pageContext.request.contextPath}/nuevoMovB';
			})
		})
	})
	
    </script>

<script>
function isNumberKey(e) {
    if(e.which === 13 || e.which === 8) return true;
    var currentChar = parseInt(String.fromCharCode(e.which), 10);
    if(!isNaN(currentChar)){
        var nextValue = $("#txthour").val() + currentChar; //It's a string concatenation, not an addition

        if(parseInt(nextValue, 10) <= 12) return true;
    }

    return false;
}
</script>
    
</body>

</html>