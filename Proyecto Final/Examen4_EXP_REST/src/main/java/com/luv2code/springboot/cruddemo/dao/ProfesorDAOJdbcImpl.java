package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Profesor;

@Repository
public class ProfesorDAOJdbcImpl implements ProfesorDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Profesor> findAll() {
		System.out.println("Implementación DAO con JDBC findAll(): " + dataSource);

		List<Profesor> listaProfesors = new ArrayList<>();

		String sql = "select * from profesor";

		try (Connection myConn = dataSource.getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql);) {

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

				// add it to the list of students
				listaProfesors.add(tempProfesor);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProfesors;
	}

	@Override
	public Profesor findById(int theId) {
		
		System.out.println("Implementación DAO con JDBC findById(): ");
		Profesor theProfesor = null;

		try (Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = createPreparedStatement(myConn, theId);
			ResultSet myRs = myStmt.executeQuery();) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
				String especialidad = myRs.getString("especialidad");

				// use the studentId during construction
				theProfesor = new Profesor(theId, nombre, apellido, email, especialidad);
			} else {
				throw new SQLException("Could not find profesor id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theProfesor;
	}

	private PreparedStatement createPreparedStatement(Connection con, int profesorId) throws SQLException {
		String sql = "select * from profesor where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, profesorId);
		return ps;
	}

	@Override
	public void save(Profesor theProfesor) {
		String sql = "";

		if (theProfesor.getId() == 0)
			sql = "insert into profesor (nombre, apellido, email, especialidad) values (?, ?, ?, ?)";
		else
			sql = "update profesor set nombre=?, apellido=?, email=?, especialidad=? where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			myStmt.setString(1, theProfesor.getNombre());
			myStmt.setString(2, theProfesor.getApellido());
			myStmt.setString(3, theProfesor.getEmail());
			myStmt.setString(4, theProfesor.getEspecialidad());
			

			if (theProfesor.getId() != 0)
				myStmt.setInt(5, theProfesor.getId());

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(int theId) {
		
		try (Connection myConn = dataSource.getConnection(); 
			 PreparedStatement myStmt = myConn.prepareStatement("delete from profesor where id=?")) {
			
			myStmt.setInt(1, theId);
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
