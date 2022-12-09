package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ProfesorControllerServlet
 */
@WebServlet("/ProfesorControllerServlet")
public class ProfesorControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProfesorDbUtil profesorDbUtil;
	
	@Resource(name="jdbc/Nomina") //SE COMENTO PARA HACER USO DE JNDI
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			
			profesorDbUtil = new ProfesorDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
						
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listProfesor(request, response);
				break;
				
			case "ADD":
				addProfesor(request, response);
				break;
				
			case "LOAD":
				loadProfesor(request, response);
				break;
				
			case "UPDATE":
				updateProfesor(request, response);
				break;
			
			case "DELETE":
				deleteProfesor(request, response);
				break;
				
			default:
				listProfesor(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteProfesor(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theProfesorId = request.getParameter("profesorId");
		
		// delete student from database
		profesorDbUtil.deleteProfesor(theProfesorId);
		
		// send them back to "list students" page
		listProfesor(request, response);
	}

	private void updateProfesor(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("profesorId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String especialidad = request.getParameter("especialidad");
		
		// create a new student object
		Profesor theProfesor = new Profesor(id, nombre, apellido, email,especialidad);
		
		// perform update on database
		profesorDbUtil.updateProfesor(theProfesor);
		
		// send them back to the "list students" page
		listProfesor(request, response);
		
	}

	private void loadProfesor(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theProfesorId = request.getParameter("profesorId");
		
		// get student from database (db util)
		Profesor theProfesor = profesorDbUtil.getProfesor(theProfesorId);
		
		// place student in the request attribute
		request.setAttribute("THE_PROFESOR", theProfesor);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-profesor-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addProfesor(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		// read student info from form data
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String email = request.getParameter("email");
				String especialidad = request.getParameter("especialidad");		
		
		// create a new student object
		Profesor theProfesor = new Profesor(nombre, apellido, email,especialidad);
		
		// add the student to the database
		profesorDbUtil.addProfesor(theProfesor);
				
		// send back to main page (the student list)
		listProfesor(request, response);
	}

	private void listProfesor(
			HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Profesor> profesor = profesorDbUtil.getProfesor();
		
		for (Profesor d:profesor) {
			System.out.println(d);
		}
		
		//profesor.add(new Profesor(999, "nombre","apellido", "email","especialidad"));
		// add students to the request
		request.setAttribute("LISTA_PROFESOR", profesor);
		
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-profesor.jsp");
		dispatcher.forward(request, response);
	}

}













