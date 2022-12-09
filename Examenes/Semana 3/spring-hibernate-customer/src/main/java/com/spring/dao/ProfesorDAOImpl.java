package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Profesor;

@Repository
public class ProfesorDAOImpl implements ProfesorDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Profesor> getProfesors() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Profesor> theQuery = 
				currentSession.createQuery("from Profesor order by apellido",
											Profesor.class);
		
		// execute query and get result list
		List<Profesor> profesor = theQuery.getResultList();
				
		// return the results		
		return profesor;
	}

	@Override
	public void saveProfesor(Profesor theProfesor) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the profesor ... finally LOL
		currentSession.saveOrUpdate(theProfesor);
		
	}

	@Override
	public Profesor getProfesor(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Profesor theProfesor = currentSession.get(Profesor.class, theId);
		
		return theProfesor;
	}

	@Override
	public void deleteProfesor(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Profesor where id=:profesorId");
		theQuery.setParameter("profesorId", theId);
		
		theQuery.executeUpdate();		
	}

}











