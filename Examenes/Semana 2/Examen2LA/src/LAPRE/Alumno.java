package LAPRE;

public class Alumno {

	private String nombre;
	private String especialidad;
	private int matricula;
	
	//Generamos el contructor con todos los valores
	public Alumno(String nombre, String especialidad, int matricula) {
		super();
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.matricula = matricula;
	}
	
	//Generamos el método toString
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", especialidad=" + 
	especialidad + ", matricula=" + matricula + "]";
	}

	//Generamos Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public double getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	
}
