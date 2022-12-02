package MultiCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
	
	
	public static void main(String [] args) {
		//Declaramos las variables locales que se ocuparan en las siguientes operaciones
		//int num = 13;  
		int num1,num2;
		int suma, resta, mult, div;
		
		
		try {
			//Pediremos dos números desde consola para realizar las operaciones
			System.out.println("Porfavor, ingrese un número: ");
			num1 = extracted().nextInt();
			
			System.out.println("Porfavor, ingrese otro número: ");
			num2 = extracted().nextInt();
			
			//Operaciones
			suma = (int) num1+num2;
			resta = (int) num1-num2;
			mult = (int) num1*num2;
			div = (int) num1/num2;
			System.out.println("El resultado de la suma es: "+suma);
			System.out.println("El resultado de la resta es: "+resta);
			System.out.println("El resultado de la mult es: "+mult);
			System.out.println("El resultado de la div es: "+div);
		}catch(ArithmeticException e) {
				//Esta excepcion nos dice que aritméticamente no se puede dividir un entero en 0
			System.out.println("Aritméticamente no se puede divir entre 0");
		}catch(InputMismatchException e) {
				//Esta excepcion nos dice que el valor debe ser un entero
				//Si escribimos una cadena, un decimal, etc nos marcara esta excepción
				System.out.println("Se debe ingresar un entero");
		}catch(Exception e) {
			e.printStackTrace(System.out);
		}finally {
			//El código que se encuentre en el finally siempre se ejecutará 
			System.out.println("El objetivo del programa es hacer operaciones con enteros");
		}
	
	}

	private static Scanner extracted() {
		return new Scanner(System.in);
	}
}
