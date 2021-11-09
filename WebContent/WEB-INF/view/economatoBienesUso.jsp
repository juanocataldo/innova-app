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
                <h3 style="color: rgb(255, 196, 0);">Ampliaci�n SIFPA</h3>
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
                    <span>Bienes de Uso</span>
                
                    <a href="${pageContext.request.contextPath}/nuevoBienUso" id="estado">
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
                    <form:form action="searchBU" method="GET">
                    
                    <div class="row">
                        <div class="col-md-4">
                            <span>Elemento</span><br><input type="text" name="nombreSearch" style="width:100%;" >	
                        </div>
                        
                        <div class="col-md-4">
                            
                        </div>
                        
                        <div class="col-md-4">
                            
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
                                <th scope="col">Stock</th>				
                                <th scope="col">Acci�n</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tempElemento" items="${listado}">
                                <tr>
                                    <td>${tempElemento.id}</td>
                                    <td>${tempElemento.nombre}</td>
                                    <td>${tempElemento.stock}</td>					
                                    <td>
                                        <a href="">
                                        <button class="botonAccion btn btn-sm" style="background-color:#5BBFDD;width:40px;font-size:5px">							
                                                <span class="material-icons" style="color:white">edit</span>							
                                        </button>
                                        </a>
                                        <button class="botonAccion btn btn-sm" style="background-color:red;width:40px;font-size:5px">							
                                                <span class="material-icons" style="color:white">arrow_downward</span>							
                                        </button>
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