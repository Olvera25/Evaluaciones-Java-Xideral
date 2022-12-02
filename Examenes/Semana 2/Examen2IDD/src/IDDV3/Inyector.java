package IDDV3;

public class Inyector {

	//De esta forma el inyector es quien asigna la especialidad
	static void InyEsp(Alumno alu, Alumno alu1, Alumno alu2) {
		
		/*Como Especialidad ahora es private solo se puede 
		  inicializar mediante el método setter*/
		alu.setEsp(new CienciasSalud(" salud"));
		alu1.setEsp(new Informatica(" informatica"));
		alu2.setEsp(new Arquitectura(" arquitectura"));
		
	}
}
