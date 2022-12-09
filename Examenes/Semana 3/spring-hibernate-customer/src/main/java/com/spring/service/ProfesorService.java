package com.spring.service;

import java.util.List;

import com.spring.entity.Profesor;

public interface ProfesorService {

	public List<Profesor> getProfesors();

	public void saveProfesor(Profesor theProfesor);

	public Profesor getProfesor(int theId);

	public void deleteProfesor(int theId);
	
}
