<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Profesor</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-profesor-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Nomina Profesores</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Profesor</h3>
	
		<form:form action="saveProfesor" modelAttribute="profesor" method="POST">

			<!-- need to associate this data with profesor id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="apellido" /></td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label>Especialidad:</label></td>
						<td><form:input path="especialidad" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/mvc/employees">Regresa a la interfaz principal</a>
		</p>
	
	</div>

</body>

</html>










