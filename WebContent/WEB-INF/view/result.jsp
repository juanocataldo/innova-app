<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<td>#</td>
			<td>User</td>
			<td>PERID</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tempUsers" items="${searchUsers}">
				<tr>
					<td>${tempUsers.id}</td>
					<td>${tempUsers.userName}</td>
					<td>${tempUsers.perid}</td>
				</tr>
		</c:forEach>
		
	</tbody>
</table>
</body>
</html>