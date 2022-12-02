package IDDV3;

//Ejemplo inyección de dependecias por método getter y setter

public class Principal {

	public static void main(String[] args) {
		
		Alumno alu = new Alumno("Eduardo Orlando","206");
		Alumno alu1 = new Alumno("Elizabeth Marcela","303");
		Alumno alu2 = new Alumno("Santiago Ramirez","308");
		
		
		Inyector.InyEsp(alu, alu1, alu2);
		alu.Asignar(); 
		alu1.Asignar(); 
		alu2.Asignar(); 
		
		
	}

}
 