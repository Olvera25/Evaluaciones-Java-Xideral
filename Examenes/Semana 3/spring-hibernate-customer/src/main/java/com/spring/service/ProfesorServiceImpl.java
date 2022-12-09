package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProfesorDAO;
import com.spring.entity.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	// need to inject profesor dao
	@Autowired
	private ProfesorDAO profesorDAO;
	
	@Override
	@Transactional
	public List<Profesor> getProfesors() {
		return profesorDAO.getProfesors();
	}

	@Override
	@Transactional
	public void saveProfesor(Profesor theProfesor) {

		profesorDAO.saveProfesor(theProfesor);
	}

	@Override
	@Transactional
	public Profesor getProfesor(int theId) {
		
		return profesorDAO.getProfesor(theId);
	}

	@Override
	@Transactional
	public void deleteProfesor(int theId) {
		
		profesorDAO.deleteProfesor(theId);
	}
}





