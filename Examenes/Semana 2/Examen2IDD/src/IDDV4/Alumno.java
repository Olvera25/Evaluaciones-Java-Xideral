package IDDV4;

public class Alumno {

	//Creamos las variables nombre y grupo
	String nombre;
	String grupo;
	private Especialidad esp;

	//Creamos el constructor de la clase
	public Alumno(String nombre, String grupo, Especialidad esp) {
		this.nombre = nombre;
		this.grupo = grupo;
		this.esp = esp;
	}
	
	//Creamos el método asignar	
	/*Podemos notar que la clase alumno sabe que se le asignará una
	  especialidad pero no sabe cual será, ya que esa tarea fue
	  delegada al inyector
	*/
	void Asignar() {
		System.out.print("El alumn@ " +nombre+ " del grupo "+grupo);
		esp.Asignar();
	}
	
	//Generamos Getters y Setters
	public Especialidad getEsp() {
		return esp;
	}

	public void setEsp(Especialidad esp) {
		this.esp = esp;
	}
	
}
