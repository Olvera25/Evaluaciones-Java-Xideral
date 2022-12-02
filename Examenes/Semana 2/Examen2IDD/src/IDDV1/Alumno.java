package IDDV1;

public class Alumno {

	String nombre;
	String grupo;
	
	
	//Arquitectura esp;
	Informatica esp;
	
	
	public Alumno(String nombre, String grupo) {
		this.nombre = nombre;
		this.grupo = grupo;
	}
	
	void Asignar() {
		System.out.print("El alumn@ " +nombre+ " del grupo "+grupo);
		esp = new Informatica(" informatica ");
		esp.Asignar();
	}
	
}
