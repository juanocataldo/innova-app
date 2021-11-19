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
                            <a href="${pageContext.request.contextPath}/nuevoElemento">Movimientos</a>
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
               
                <div class="cabeceraMov">
                    <span>Nuevo Movimiento ${tipoMov}</span>		
                </div>
                
               
                
                <div class="filtro">
                <span>Seleccione Persona</span> 
            </div>
           
            <div class="filtroCuerpo">
                
                
                <form:form action="nuevoMovimientoBU" method="GET">
                
                <div class="row">
                    <div class="col-md-6">
                        <span>DNI</span><br><input type="text"  style="width:100%;" name="dniSearch" id="dni" >	
                    </div>
                    
                    <div class="col-md-6">
                        
                    </div>
                </div>
                <br>
             
                    <input type="button" class="submit btn btn-sm" value="Buscar" id="buttonDemo1">		
                <br>
                 <!-- <input type="hidden" name="tipoMov" value="${tipoMov}"/> -->
           </form:form>
            </div>	
                
                
                
                <div class="filtro mt-4">
                    <span>Seleccionado</span> 
                </div>
                <div class="filtroCuerpo">
                    <table class="table" style="color:white">
                        <thead>
                            <tr>				
                                <td>Persona</td>
                            </tr>
                        </thead>
                        <tbody>		
                            
             
                
                                    <tr>
                                        <td>
                                           <!--   ${persona.nombre} ${persona.apellido}-->
                                           <span id="result1"></span>
                                        </td>
                                        
                               					
                                    </tr>
                        </tbody>
                    </table>
                </div>	
                
                
                
            </div>
            
            
            
            <div class="container">	
               
                <br>
                
            
          
                
                
                
                <div class="filtro mt-4">
                    <span>Lista Bienes</span> 
                </div>
                <div class="filtroCuerpo">
                  <!--    <table class="table">
                        <thead>
                            <tr>				
                                <td>Elemento</td>
                                <td>Stock</td>
                                <td style="text-align:center">Actividad</td>
                            </tr>
                        </thead>
                        <tbody>		
                            <c:forEach var="tempElemento" items="${listadoBU}">
                            
                            <c:url var="nuevoMovimientoBU" value="nuevoMovimientoBU"> 
                                <c:param name="id" value="${tempElemento.id}" />
                                <c:param name="tipoMov" value="${tipoMov}" />
                                <c:param name="dniSearch" value="${persona.dni}" />									
                            </c:url>
                
                                    <tr>
                                        <td>
                                            ${tempElemento.nombre}
                                        </td>
                                        
                                        <td>
                                            ${tempElemento.stock}
                                        </td>	
                
                                        <td style="text-align:center">
                                            <a href="${nuevoMovimientoBU}">
                                                <button class="botonAccion btn btn-sm" style="background-color:#46BA46;width:40px;font-size:5px">							
                                                        <span class="material-icons" style="color:white">add</span>							
                                                </button>
                                            </a>
                                            
                                             <input type="button" value="Demo 1" id="buttonDemo2">		
                			                 <input type="hidden" name="id" value="${tempElemento.id}"/>
                                            
                                        </td> 						
                                    </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                </div>	
                
                <div id="pagination">
                <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                              
                    <c:url value="/bienesUso" var="prev">
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
                                <c:url value="/bienesUso" var="url">
                                    <c:param name="page" value="${i.index}"/>
                                </c:url>
                               <li class="page-item"> <a class="page-link" href='<c:out value="${url}" />'>${i.index}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:url value="/bienesUso" var="next">
                        <c:param name="page" value="${page + 1}"/>
                    </c:url>
                    <c:if test="${page + 1 <= maxPages}">
                        <li class="page-item"><a class="page-link" href='<c:out value="${next}" />' class="pn next"><span style="color:black">></span></a></a></li>
                    </c:if>
                     </ul>
                    </nav>
                </div>	-->
                
                
                <table id="tablaBienes" class="table" style="width:100%; color:white">
			        <thead>
			            <tr>
			            	<th scope="col">Elemento</th>
			                <th scope="col">Stock</th>
			                <th scope="col">Actividad</th>			                
			            </tr>
			        </thead>
			        <tbody>        	
			        </tbody>
			    </table>
                
                
                <div class="container">
            	
                
                
                
                 <c:url var="saveMovBU" value="saveMovBU"> 
                                <c:param name="id" value="${persona.dni}" />
                                <c:param name="listElementos" value="${excepciones}" /> 
                                 <c:param name="tipoMov" value="${tipoMov}" />             
                            </c:url>
                
                <a href="${saveMovBU}">
                
              
                
                	  
                	 <button class="submitNuevo btn btn-sm">
                    <div class="d-flex flex-wrap" style="background-color: transparent;" >							
                        <span class="material-icons">save</span>
                            <span> Guardar</span>
                        </div>
                    </button>
                  </a>		
                
            </div>
                
            </div>
            
            
            
            
            
	                    
            
            
            
            <div class="p-4">
                
            </div>
    
            







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
        
        
            	 
        
    </div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    

<script type="text/javascript">
	$(document).ready(function() {
		$('#tablaBienes').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/listBienesUso',
			"dataSrc":''
		},
		
		 "language": {
		        "sProcessing":    "Procesando...",
		        "sLengthMenu":    "Mostrar _MENU_ registros",
		        "sZeroRecords":   "No se encontraron resultados",
		        "sEmptyTable":    "Ningún dato disponible en esta tabla",
		        "sInfo":          "_START_ al _END_ de _TOTAL_ ",
		        "sInfoEmpty":     "Mostrando registros del 0 al 0 de un total de 0 registros",
		        "sInfoFiltered":  "(filtrado de un total de _MAX_ registros)",
		        "sInfoPostFix":   "",
		        "sSearch":        "Buscar:",
		        "sUrl":           "",
		        "sInfoThousands":  ",",
		        "sLoadingRecords": "Cargando...",
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
			{"data": 'nombre'},
			{"data": 'stock'},
			{"defaultContent":
				'<div class="text-center"><button class="btnEditar botonAccion btn btn-sm" style="background-color:#5BBFDD;width:40px;font-size:5px"><span class="material-icons" style="color:green">add</span></button></div>'
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

	$(document).ready(function(){
		$('#buttonDemo1').click(function(){
			var dni = $('#dni').val();
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/getPerByDni/'+dni+'',
				success: function(result){
					$('#result1').html(result);
				}
			})
		})
	})
    </script>
    
     <script>

	$(document).ready(function(){
		$('#buttonDemo1').click(function(){
			var dni = $('#dni').val();
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/getBUById/'+id+'',
				success: function(result){
					$('#result1').html(result);
				}
			})
		})
	})
    </script>
    
    
</body>

</html>