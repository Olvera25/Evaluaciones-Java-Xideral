package IDDV5;

//importamos java.util.Scanner para recibir datos desde consola
import java.util.Scanner;

public class Inyector {

	//Creamos leer
	private static Scanner leer;

	//De esta forma el inyector es quien asigna la especialidad
	static Alumno getAlumno() {
		
		//Especialidad Arquitectura = new Arquitectura(" arquitectura");
		Especialidad Informatica = new Informatica(" informática");
		
		//Creamos los string nombre y grupo
		String nombre, grupo;
		leer = new Scanner(System.in);
		
		//Pedimos datos desde consola y después se asignan
		System.out.println("Introduzca el nombre");
		nombre = leer.next();
		
		System.out.println("Introduzca el grupo");
		grupo = leer.next();
		return new Alumno(nombre,grupo, Informatica);
		
	} 
}
