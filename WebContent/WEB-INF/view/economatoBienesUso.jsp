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

 <style>
           
           .dataTables_wrapper{
           	color:#DCDCDD;
           }
</style>



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

            

            <div class="container">	

                <div class="cabecera">
                    <span>Bienes de Uso</span>
                
                        
                    
                        <button id="btnNuevo" type="submit" class="submit btn btn-sm" style="background-color: #46BA46">
                        <div class="d-flex flex-wrap" style="background-color: transparent;" >
                            <span class="material-icons">add</span>
                                <span>Nuevo</span>
                            </div>
                        </button>
                    
                    <br>		
                </div>
                
                
                
              <!--   <div class="filtro">
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
                </div>	-->
                </div>
                
                <div class="container mt-4">
                <div class="filtro">
                    <span>Listado</span> 	
                </div>
                <div class="filtroCuerpo">
                    
                       <table id="tablaBU" class="table" style="width:100%; color:white">
				        <thead>
				            <tr>
				            	<th scope="col">ID</th>
				                <th scope="col">Nombre</th>
				                <th scope="col">Stock</th>
				                <th scope="col">Estado</th>				                
				                <th scope="col" style="text-align:center">Acción</th>
				            </tr>
				        </thead>
				        <tbody>        	
				        </tbody>
				    </table>
                    
                    <br><br>
                    
                <!--     
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nombre</th>                                
                                <th scope="col">Stock</th>
                                <th scope="col">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tempElemento" items="${listado}">
                                <tr>
                                    <td>${tempElemento.id}</td>
                                    <td>${tempElemento.nombre}</td>                                    
                                    <td>${tempElemento.stock}</td>
                                    <td>Editar/Baja</td>
                                </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                
                </div>	
                
                <div id="pagination">
                <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                              
                    <c:url value="/elementos" var="prev">
                        <c:param name="page" value="${page-1}"/>
                    </c:url>
                    <c:if test="${page > 1}">
                        <li class="page-item"><a class="page-link" href="<c:out value="${prev}" />" class="pn prev"><span style="color:black"><</span></a></li>
                    </c:if>
                
                    <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                        <c:choose>
                            <c:when test="${page == i.index}">
                                <span class="p-2">${i.index}</span>
                            </c:when>
                            <c:otherwise>
                                <c:url value="/elementos" var="url">
                                    <c:param name="page" value="${i.index}"/>
                                </c:url>
                               <li class="page-item"> <a class="page-link" href='<c:out value="${url}" />'>${i.index}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:url value="/elementos" var="next">
                        <c:param name="page" value="${page + 1}"/>
                    </c:url>
                    <c:if test="${page + 1 <= maxPages}">
                        <li class="page-item"><a class="page-link" href='<c:out value="${next}" />' class="pn next"><span style="color:black">></span></a></a></li>
                    </c:if>
                     </ul>
                    </nav>
                </div>
                -->
                
                </div>
    
            

					



<div class="modal fade" id="modalCRUD" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="background-color:#3A3F44">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
        <form id="formEditElem">    
            <div class="modal-body">
                <div class="row"  style="color:white">
                    <div class="col-lg-4">
	                    <div class="form-group">
		                    <label for="" class="col-form-label" >ID</label>
		                    <input type="text" id="id" disabled="disabled">
	                    </div>
                    </div>
                    <div class="col-lg-5">
	                    <div class="form-group">
		                    <label for="" class="col-form-label">Elemento</label><br>
		                    <input type="text" id="nombre" />
	                    </div> 
                    </div>                    
                    <div class="col-lg-3">
	                    <div class="form-group">
		                    <label for="" class="col-form-label" >Stock</label>
			                <br>
			                <input type="text"  id="stock">
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




<div class="modal fade" id="modalCRUDNuevo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="background-color:#3A3F44">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
            </div>
        <form id="formNewElem">    
            <div class="modal-body">
                <div class="row"  style="color:white">
                    
                    <div class="col-lg-9">
	                    <div class="form-group">
		                    <label for="" class="col-form-label">Elemento</label><br>
		                    <input type="text" id="nombreElem" name="nombre">
	                    </div> 
                    </div>                    
                    <div class="col-lg-3">
	                    <div class="form-group">
	                    <label for="" class="col-form-label" >Stock</label>
		                    <br><input type="number"  id="stockElem" name="stock">
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
    </div>

  
    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
    
    
    
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    
</body>

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

<script type="text/javascript">
	$(document).ready(function() {
		
		fila = $(this).closest("tr");
		estado = parseInt(fila.find('td:eq(3)').text());
		
		$('#tablaBU').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/listBienesUso1',
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
			{"data": 'nombre'},
			{"data": 'stock'},
			{"data": 'estado'},	
			{"data" :'estado', 
					"render": function(data, type, row){
			       
			    	   if(data == 1){
			             data = '<div class="text-center"><button class="btnEdit botonAccion btn btn-sm" style="background-color:#5BBFDD;"><span class="material-icons" style="color:white">edit</span></button><span>  </span><button class="btnBaja botonAccion btn btn-sm" style="background-color:red;"><span class="material-icons">arrow_downward</span></button></div>';
			          } else {
			             data = '<div class="text-center"><button class="btnEdit botonAccion btn btn-sm" style="background-color:#5BBFDD;"><span class="material-icons" style="color:white">edit</span></button><span>  </span><button class="btnBaja botonAccion btn btn-sm" style="background-color:green;"><span class="material-icons">arrow_upward</span></button></div>';
			          }
			       

			       return data;
			    }
			
			}
		]
	});
});
</script>

<script>
$(document).on("click", ".btnEdit", function(){	        
    
    fila = $(this).closest("tr");	        
    id = parseInt(fila.find('td:eq(0)').text()); //capturo el ID		            
    nombre = fila.find('td:eq(1)').text();
    stock = fila.find('td:eq(2)').text();
    
    $("#id").val(id);
    $("#nombre").val(nombre);
    $("#stock").val(stock);
   
    $(".modal-header").css("background-color", "#D4B557");
    $(".modal-header").css("color", "black" );
    $(".modal-title").text("Editar Bien");		
    $('#modalCRUD').modal('show');		   
});



$(document).on("click", ".btnBaja", function(){
    fila = $(this);           
    id = parseInt($(this).closest('tr').find('td:eq(0)').text()) ;
    estado = parseInt($(this).closest('tr').find('td:eq(3)').text()) ;
       
    var respuesta = confirm("¿Está seguro de dar de baja el elemento con ID: "+id+"?");                
    if (respuesta) {            
        $.ajax({
          url: "${pageContext.request.contextPath}/bajaBienUso",
          type: "POST",
          datatype:"json",    
          data:  {id:id, estado:estado},    
          success: function() {
        	  $('#tablaBU').DataTable().ajax.reload(null, false);      
           }
        });	
    }
 });




var fila; //captura la fila, para editar o eliminar
//submit para el Alta y Actualización
$('#formEditElem').submit(function(e){                         
  e.preventDefault(); //evita el comportambiento normal del submit, es decir, recarga total de la página
  id = $.trim($('#id').val());    
  nombre = $.trim($('#nombre').val());
  stock = $.trim($('#stock').val());    
                              
      $.ajax({
        url: "${pageContext.request.contextPath}/editBienUso",
        type: "POST",
        datatype:"json",    
        data:  {id:id,nombre:nombre, stock:stock},    
        success: function(data) {
        	$('#tablaBU').DataTable().ajax.reload(null, false);
         }
      });			        
  $('#modalCRUD').modal('hide');											     			
});






$("#btnNuevo").click(function(){
	$("#formNewElem").trigger("reset");
    $(".modal-header").css( "background-color", "#272B30");            
    $(".modal-header").css( "color", "white" );
    $(".modal-header").css( "font-size", "20px" );
    $(".modal-title").text("Alta de Bien de Uso");
    $('#modalCRUDNuevo').modal('show');	    
});




$('#formNewElem').submit(function(e){                         
	    e.preventDefault(); //evita el comportambiento normal del submit, es decir, recarga total de la página
	    
	    nombre = $('#nombreElem').val();
	    stock = $('#stockElem').val();
	     
	    
	    	$.ajax({
	          url: "${pageContext.request.contextPath}/newBU",
	          type: "POST",
	          datatype:"json",    
	          data:  {nombre:nombre, stock:stock},    
	          success: function(data) {
	          	$('#tablaBU').DataTable().ajax.reload(null, false);
	           }
	        });			        
	    $('#modalCRUDNuevo').modal('hide');											     			
	});
</script>

</html>