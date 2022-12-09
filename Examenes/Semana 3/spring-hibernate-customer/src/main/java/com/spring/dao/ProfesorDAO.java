package com.spring.dao;

import java.util.List;

import com.spring.entity.Profesor;

public interface ProfesorDAO {

	public List<Profesor> getProfesors();

	public void saveProfesor(Profesor theProfesor);

	public Profesor getProfesor(int theId);

	public void deleteProfesor(int theId);
	
}
