<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>

<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css" type="text/css" rel="stylesheet" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css" type="text/css" rel="stylesheet" />


</head>
<body>

<fieldset>
	<legend>Demo 1</legend>
	DNI <input type="text" id="dni">
	<input type="button" value="Demo 1" id="buttonDemo1">
	<br>
	<span id="result1"></span>
</fieldset>
<br>
<br>
<div class="container">
    <table id="tablaUsuarios" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th scope="col">DNI</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
            </tr>
        </thead>
        <tbody>        	
        </tbody>
    </table>
</div>

</body>
<script>


	$(document).ready(function(){
		$('#buttonDemo1').click(function(){
			var dni = $('#dni').val();
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
	$(document).ready(function() {
		$('#tablaUsuarios').DataTable({
		"ajax":{
			"url": '${pageContext.request.contextPath}/json',
			"dataSrc":''
		},
		"columns":[			
			{"data": 'dni'},
			{"data": 'nombre'},
			{"data": 'apellido'}
		]
	});
});
</script>

</html>