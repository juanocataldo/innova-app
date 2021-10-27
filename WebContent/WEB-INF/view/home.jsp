<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	

<title>Innova</title>
</head>
<body>
<br>
<h1>Sumarios</h1>
<a href="sumarios">Entrar</a>

<a href="${pageContext.request.contextPath}/search">Buscar</a>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">User Name</th>
      <th scope="col">Person ID</th>      
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="tempUser" items="${users}">
	
		<tr>
			<th scope="row">${tempUser.id}</th>
			<td>${tempUser.userName}</td>
			<td>${tempUser.perid}</td>
		</tr>	
	</c:forEach>
  </tbody>
</table>



</body>
</html>