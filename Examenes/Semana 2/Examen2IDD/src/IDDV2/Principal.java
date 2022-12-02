package IDDV2;

//Ejemplo inyección de dependecias por una variable

public class Principal {

	public static void main(String[] args) {
		
		//Creamos un objeto Alumno que tendrá dos String nombre y grupo
		Alumno alu = new Alumno("Eduardo Orlando","206");
		
		Inyector.InyEsp(alu);
		alu.Asignar(); 

	}

}
  