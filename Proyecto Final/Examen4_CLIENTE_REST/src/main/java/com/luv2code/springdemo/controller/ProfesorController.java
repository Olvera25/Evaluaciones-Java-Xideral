package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.model.Profesor;
import com.luv2code.springdemo.service.ProfesorService;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

	// need to inject our profesor service
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/list")
	public String listProfesors(Model theModel) {
		
		// get profesors from the service
		List<Profesor> theProfesors = profesorService.getProfesors();
				
		// add the profesors to the model
		theModel.addAttribute("profesors", theProfesors);
		
		return "list-profesors";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Profesor theProfesor = new Profesor();
		
		theModel.addAttribute("profesor", theProfesor);
		
		return "profesor-form";
	}
	
	@PostMapping("/saveProfesor")
	public String saveProfesor(@ModelAttribute("profesor") Profesor theProfesor) {
		
		// save the profesor using our service
		profesorService.saveProfesor(theProfesor);	
		
		return "redirect:/profesor/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("profesorId") int theId,
									Model theModel) {
		
		// get the profesor from our service
		Profesor theProfesor = profesorService.getProfesor(theId);	
		
		// set profesor as a model attribute to pre-populate the form
		theModel.addAttribute("profesor", theProfesor);
		
		// send over to our form		
		return "profesor-form";
	}
	
	@GetMapping("/delete")
	public String deleteProfesor(@RequestParam("profesorId") int theId) {
		
		// delete the profesor
		profesorService.deleteProfesor(theId);
		
		return "redirect:/profesor/list";
	}
}










