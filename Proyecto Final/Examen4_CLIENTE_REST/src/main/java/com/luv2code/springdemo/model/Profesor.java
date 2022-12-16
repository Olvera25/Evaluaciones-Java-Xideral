package com.luv2code.springdemo.model;

public class Profesor {

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String especialidad;
	
	
	public Profesor() {
	}
	
	public Profesor(int id, String nombre, String apellido, String email, String especialidad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.especialidad = especialidad;
	}

	public Profesor(String nombre, String apellido, String email, String especialidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", especialidad=" + especialidad + "]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
		
}











