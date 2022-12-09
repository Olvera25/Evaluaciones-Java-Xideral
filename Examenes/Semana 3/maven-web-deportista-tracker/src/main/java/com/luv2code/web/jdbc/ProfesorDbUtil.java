package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProfesorDbUtil {

	private DataSource dataSource;

	public ProfesorDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Profesor> getProfesor() throws Exception {
		
		List<Profesor> profesor = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "Select * from Profesor";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
				String especialidad = myRs.getString("especialidad");
				
				// create new student object
				Profesor tempProfesor = new Profesor(id, nombre, apellido, email, especialidad);
				
				// add it to the list of deportistas
				profesor.add(tempProfesor);				
			}
			
			return profesor;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addProfesor(Profesor theProfesor) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into Profesor "
					   + "(nombre, apellido, email,especialidad) "
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theProfesor.getNombre());
			myStmt.setString(2, theProfesor.getApellido());
			myStmt.setString(3, theProfesor.getEmail());
			myStmt.setString(4, theProfesor.getEspecialidad());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Profesor getProfesor(String theProfesorId) throws Exception {

		Profesor theProfesor = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int profesorId;
		
		try {
			// convert student id to int
			profesorId = Integer.parseInt(theProfesorId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from Profesor where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, profesorId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
				String especialidad = myRs.getString("especialidad");
				
				// use the deportistaId during construction
				theProfesor = new Profesor(profesorId, nombre, apellido, email,especialidad);
			}
			else {
				throw new Exception("Could not find student id: " + profesorId);
			}				
			
			return theProfesor;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateProfesor(Profesor theProfesor) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update Profesor "
						+ "set nombre=?, apellido=?, email=?, especialidad=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theProfesor.getNombre());
			myStmt.setString(2, theProfesor.getApellido());
			myStmt.setString(3, theProfesor.getEmail());
			myStmt.setString(4, theProfesor.getEspecialidad());
			myStmt.setInt(5, theProfesor.getId());
			
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteProfesor(String theProfesorId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int profesorId = Integer.parseInt(theProfesorId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from Profesor where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, profesorId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















