package LAPRE;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Principal {

	public static void main(String[] args) {
		
		//Creamos la variable que almacenará el número de elementos que tendrá la lista de alumnos
		int numele;
		
		//Creamos las variables que almacenaran el nombre, especialidad y matrícula del alumno.
		String nombre;
		String especialidad;
		int matricula;
		
		
		/*Realizamos el Scanner dentro del un bloque try with resources para
		asegurarnos que aunque exista una excepción se cierre el Scanner
		*/
		try (Scanner sc = new Scanner(System.in)) {
			
			//Creamos la lista de alumnos
			List<Alumno> listaAlumnos = new ArrayList<>();
			
			
			//Pedimos que el usuario ingrese el número de elementos de la lista
			System.out.println("Ingrese el número de elementos de la lista");
			numele = sc.nextInt();
			
			//Usamos un for para llenar la lista a partir de datos de consola
			for(int i = 0; i<numele; i++) {
				System.out.println("Ingrese el nombre del alumno");
				nombre = sc.next();
				System.out.println("-----------------------");
				System.out.println("Ingrese la especialidad");
				especialidad = sc.next();
				System.out.println("-----------------------");
				System.out.println("Ingrese la matrícula");
				matricula = sc.nextInt();
				
				//Añadimos un alumno a la lista con los datos que se pidio anteriormente
				listaAlumnos.add(new Alumno(nombre,especialidad,matricula));
			}
			
			
			
			//Creamos las lambdas 
			//En esta la condición para que se imprima el alumno el nombre debe tener un tamaño mayor a 3  
			mostrarAlumno(listaAlumnos, w -> w.getNombre().length()>3);
			
			//En esta la condición para que se imprima es que la matricula sea mayor a 1000
			mostrarAlumno(listaAlumnos, w -> w.getMatricula() > 1000);
			
			
		}		
		
		
	}
	
	//Creamos el método éstatico mostrarAlumno
	static void mostrarAlumno(List<Alumno> lista, Predicado<Alumno> p ) {
		//Creamos un for each para la lista
		for(Alumno e :lista) {
			//Comprobamos si cumpre la Lambda y si lo cumple, imprime los datos del alumno
			if (p.probar(e))
				System.out.println(e);
		}
		
	}

}
