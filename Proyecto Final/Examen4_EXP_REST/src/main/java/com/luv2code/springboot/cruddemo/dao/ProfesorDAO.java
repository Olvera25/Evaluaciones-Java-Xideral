package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Profesor;

public interface ProfesorDAO {

	List<Profesor> findAll();
	
	Profesor findById(int theId);
	
	void save(Profesor theProfesor);
	
	void deleteById(int theId);
	
}
