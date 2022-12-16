<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Profesores</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Nomina Profesores</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Profesor -->
		
			<input type="button" value="Agregar Profesor"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Especialidad</th>
					<th>Opciones</th>
				</tr>
				
				<!-- loop over and print our profesors -->
				<c:forEach var="tempProfesor" items="${profesors}">
				
					<!-- construct an "update" link with profesor id -->
					<c:url var="updateLink" value="/mvc/showFormForUpdate">
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>					

					<!-- construct an "delete" link with profesor id -->
					<c:url var="deleteLink" value="/mvc/delete">
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempProfesor.nombre} </td>
						<td> ${tempProfesor.apellido} </td>
						<td> ${tempProfesor.email} </td>
						<td> ${tempProfesor.especialidad} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Está seguro de querer borrar este profesor?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>














