package IDDV4;

//Ejemplo inyección de dependecias por constructor

public class Principal {

	public static void main(String[] args) {
		
		Alumno alu = Inyector.getAlumno();
		alu.Asignar(); 
		
		
		
	}

}
 