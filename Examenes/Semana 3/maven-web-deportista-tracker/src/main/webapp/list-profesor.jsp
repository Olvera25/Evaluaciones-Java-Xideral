<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Profesor</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Profesor</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Agregar Profesor" 
				   onclick="window.location.href='add-profesor-form.html'; return false;"
				   class="add-profesor-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Especialidad</th>
					<th>Opciones</th>
				</tr>
				
				<c:forEach var="tempProfesor" items="${LISTA_PROFESOR}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ProfesorControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ProfesorControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempProfesor.nombre} </td>
						<td> ${tempProfesor.apellido} </td>
						<td> ${tempProfesor.email} </td>
						<td> ${tempProfesor.especialidad} </td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Desa borrar el profesor?'))) return false">
							Borrar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








