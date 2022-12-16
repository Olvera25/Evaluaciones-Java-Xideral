package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Profesor;
import com.luv2code.springboot.cruddemo.service.ProfesorService;

@RestController
@RequestMapping("/rest")
public class ProfesorRestController {

	private ProfesorService profesorService;
	
	@Autowired
	public ProfesorRestController(ProfesorService theProfesorService) {
		profesorService = theProfesorService;
	}
	
	// expose "/profesors" and return list of profesors
	@GetMapping("/profesors")
	public List<Profesor> findAll() {
		return profesorService.findAll();
	}

	// add mapping for GET /profesors/{profesorId}
	
	@GetMapping("/profesors/{profesorId}")
	public Profesor getProfesor(@PathVariable int profesorId) throws Exception {
		
		Profesor theProfesor = profesorService.findById(profesorId);
		
		if (theProfesor == null) {
			throw new Exception("Profesor id not found - " + profesorId);
		}
		
		return theProfesor;
	}
	
	// add mapping for POST /profesors - add new profesor
	
	@PostMapping("/profesors")
	public Profesor addProfesor(@RequestBody Profesor theProfesor) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProfesor.setId(0);
		
		profesorService.save(theProfesor);
		
		return theProfesor;
	}
	
	// add mapping for PUT /profesors - update existing profesor
	
	@PutMapping("/profesors")
	public Profesor updateProfesor(@RequestBody Profesor theProfesor) {
		
		profesorService.save(theProfesor);
		
		return theProfesor;
	}
	
	// add mapping for DELETE /profesors/{profesorId} - delete profesor
	
	@DeleteMapping("/profesors/{profesorId}")
	public String deleteProfesor(@PathVariable int profesorId) {
		
		Profesor tempProfesor = profesorService.findById(profesorId);
		
		// throw exception if null
		
		if (tempProfesor == null) {
			throw new RuntimeException("Profesor id not found - " + profesorId);
		}
		
		profesorService.deleteById(profesorId);
		
		return "Deleted profesor id - " + profesorId;
	}
	
}










