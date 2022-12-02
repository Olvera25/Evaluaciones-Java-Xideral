package IDDV2;

public class Alumno {

	//Creamos las variables nombre y grupo
	String nombre;
	String grupo;
	
	Especialidad esp;
	
	//Creamos el constructor de la clase
	public Alumno(String nombre, String grupo) {
		this.nombre = nombre;
		this.grupo = grupo;
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
	
}
