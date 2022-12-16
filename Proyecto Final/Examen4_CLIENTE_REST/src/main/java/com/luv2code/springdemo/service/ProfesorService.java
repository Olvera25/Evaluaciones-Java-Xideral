package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.model.Profesor;

public interface ProfesorService {

	public List<Profesor> getProfesors();

	public void saveProfesor(Profesor theProfesor);

	public Profesor getProfesor(int theId);

	public void deleteProfesor(int theId);
	
}
