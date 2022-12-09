import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	//Comprueba que el resultado que regrese la opreación sea TRUE
	@Test
	void testOperacion() {
		Calculadora calcu = new Calculadora(1,1,2,3);
		boolean resultado = calcu.operacion();
		assertEquals("TRUE",resultado);
	}
	
	
	//Comprueba que el resultado de la suma sea 1010
	@Test
	void testSuma() {
		Calculadora calcu = new Calculadora(1000,10);
		int resultado = calcu.suma();
		assertEquals(1010,resultado);
	}

	//Comprueba que el resultado de la resta sea 1000
	@Test
	void testResta() {
		Calculadora calcu = new Calculadora(1000,0);
		int resultado = calcu.resta();
		assertEquals(1000,resultado);
	}

	//Comprueba que el resultado de la multiplicación sea -30
	@Test
	void testMultiplica() {
		Calculadora calcu = new Calculadora(-15,2);
		int resultado = calcu.suma();
		assertEquals(-35,resultado);
	}

	//Comprueba que el resultado de la división sea 1
	@Test
	void testDivide() {
		Calculadora calcu = new Calculadora(0,0);
		int resultado = calcu.divide();
		assertEquals(1,resultado);
	}

}
