
public class Calculadora {

	//Creamos las variables de tipo entero que almacenaran al número
	int numero1;
	int numero2;
	int numero3;
	int numero4;
	
	//Creamos los contructores que ocuparemos
	public Calculadora(int numero1, int numero2, int numero3, int numero4) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.numero3 = numero3;
		this.numero4 = numero4;
	}


	public Calculadora(int a, int b) {
		numero1 = a;
		numero2 = b;
	}
	
	
	//Declaramos diversos métodos los cuales serán testeados
	
	//Comprueba que los primeros 2 números ingresados sean iguales y los siguientes 2 sean diferentes.
	public boolean operacion() {
		if(numero2 == numero1 && numero3 != numero4) {
			System.out.println("Se cumple la condición en la que el numero 1 y 2 son iguales mientras que numero 3 y 4 son diferentes");
			boolean rest = true;
			return rest;
		}else {
			System.out.println("No se cumple la condición en la que el numero 1 y 2 son iguales mientras que numero 3 y 4 son diferentes");
			boolean rest = true;
			return rest;
		}
	}
	
	
	//Realiza una suma entre 2 números
	public int suma() {
		int result = numero1 + numero2;
		return result;
	}
	
	//Realiza una resta entre 2 números
	public int resta() {
		int result = numero1 - numero2;
		return result;
	}
	
	//Realiza una multilicación entre 2 números
	public int multiplica() {
		int result = numero1 * numero2;
		return result;
	}
	
	//Realiza una división entre 2 números
	public int divide() {
		int result = numero1 / numero2;
		return result;
	}
	
	
}
