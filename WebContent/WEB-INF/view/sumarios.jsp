<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sumarios</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>	

</head>
<body>

<h1>SUMARIOS</h1>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Sumario</th>
      <th scope="col">Latitud</th>
      <th scope="col">Longitud</th>            
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="tempSum" items="${sumarios}">
	
		<tr>
			
			<th scope="row">${tempSum.id}</th>
			<c:choose>
				<c:when test="${tempSum.digital}==null">
					<td>S/N</td>
				</c:when>
				<c:otherwise>
					<td>${tempSum.digital}</td>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${tempSum.latitud}==null">
					<td>S/N</td>
				</c:when>
				<c:otherwise>
					<td>${tempSum.latitud}</td>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${tempSum.longitud}==null">
					<td>S/N</td>
				</c:when>
				<c:otherwise>
					<td>${tempSum.longitud}</td>
				</c:otherwise>
			</c:choose>
			
		</tr>	
	</c:forEach>
  </tbody>
</table>

</body>
</html>