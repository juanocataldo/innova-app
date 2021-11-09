<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

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
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
</head>

<body>
    <div class="wrapper" >
        <!-- Sidebar  -->
       <nav id="sidebar" style="background-color: #3A3F44;">
            <div class="sidebar-header" style="background-color: #3A3F44;">
                <h3 style="color: rgb(255, 196, 0);">Ampliación SIFPA</h3>
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
    <br>
        <a href="${pageContext.request.contextPath}/nuevoMovimiento" id="estado">
            <button type="submit" class="submit-atras btn btn-sm">
            <div class="d-flex flex-wrap justify-content-left" style="background-color: transparent;" >
                <span class="material-icons">arrow_back</span>
                    <span>Atras</span>
                </div>
            </button>
        </a>
        <br><br>	
    
        <div class="cabeceraMov">
            <span>Nuevo ingreso/egreso</span>		
        </div>
        
        
        <div class="filtro">
            <span>Generar Movimiento:  ${userSelected.nombre} ${userSelected.apellido}</span> 
        </div>
        <div class="filtroCuerpo mb-4">
            <form:form action="guardarMovimiento" >		  
                <div class="form-group">
                <span>Seleccionar movimiento</span>
                     <select name="item" class="form-select form-select-sm form-select-innova minimal">		    		
                                   <c:if test="${(empty ingresoPersona.fechaIn) and (not empty ingresoPersona.fechaFin)}">
                                       <option value="ingreso" >Ingreso a Base</option>
                                       <option value="egreso" disabled=disabled>Salida de Base</option>
                                   </c:if>
                                   
                                   <c:if test="${(not empty ingresoPersona.fechaIn) and (empty ingresoPersona.fechaFin)}">
                                       <option value="ingreso" disabled=disabled>Ingreso a Base</option>
                                       <option value="egreso" >Salida de Base</option>
                                   </c:if>
                                   
                                   <c:if test="${(empty ingresoPersona.fechaIn) and (empty ingresoPersona.fechaFin)}">
                                       <option value="ingreso">Ingreso a Base</option>
                                       <option value="egreso" >Salida de Base</option>
                                   </c:if>
                                   
                                   <c:if test="${(not empty ingresoPersona.fechaIn) and (not empty ingresoPersona.fechaFin)}">
                                       <option value="ingreso" >Ingreso a Base</option>
                                       <option value="egreso" disabled=disabled >Salida de Base</option>
                                   </c:if>	   
                 </select>
                
                <br><br>
                
                    <span>Detalles del movimiento</span><br> 
                    <input type="text" name="detalle" id="detalles" placeholder="Ingrese detalles del movimiento">
                   
                   <input style="display:none" type="text" name="id" value="${userSelected.id}">							
                   
                   <button type="submit" class="submit btn btn-sm">
                    <div class="d-flex flex-wrap" style="background-color: transparent;" >
                        <span class="material-icons">save</span>
                            <span>Guardar</span>
                        </div>
                    </button>
                    <br><br>	
                </div>
             
               
               
           </form:form>
        </div>
    
        <div class="filtro">
            <span>Último movimiento realizado</span> 
        </div>
        <div class="filtroCuerpo">
            <table class="table">
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
                                    <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ingresoPersona.fechaIn}" />							
                                </td>						 						
                                <td>
                                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ingresoPersona.fechaFin}" />						
                                </td>
                            </tr>			
                </tbody>
            </table>
        </div>	
    </div>
    
            

        </div>
    </div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
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
    </script>
</body>

</html>