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

<h1>SUMARIOS CON PERID</h1>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Sumario</th>
      <th scope="col">Perid</th>
      <th scope="col">Persona</th>                      
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="tempSum" items="${sumariosPerid}">
	
		<tr>
			
			<th scope="row">${tempSum.id}</th>
			<c:choose>
				<c:when test="${tempSum.sumid}==null">
					<td>S/N</td>
				</c:when>
				<c:otherwise>
					<td>${tempSum.sumid}</td>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${tempSum.perid}==null">
					<td>S/N</td>
				</c:when>
				<c:otherwise>
					<td>${tempSum.perid}</td>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${tempSum.perid}==null">
					<td>S/N</td>
				</c:when>
				<c:otherwise>
					<td>${tempSum.perid}</td>
				</c:otherwise>
			</c:choose>		
		</tr>	
	</c:forEach>
  </tbody>
</table>

</body>
</html>