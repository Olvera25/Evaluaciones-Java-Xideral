<!DOCTYPE html>
<html>

<head>
	<title>Actualizar Profesor</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Actualizar Profesor</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar Profesor</h3>
		
		<form action="ProfesorControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="profesorId" value="${THE_PROFESOR.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${THE_PROFESOR.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="apellido" 
								   value="${THE_PROFESOR.apellido}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_PROFESOR.email}" /></td>
					</tr>
					<tr>
						<td><label>Especialidad:</label></td>
						<td><input type="text" name="especialidad" 
								   value="${THE_PROFESOR.especialidad}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="ProfesorControllerServlet">Regresar a la interfaz principal</a>
		</p>
	</div>
</body>

</html>











