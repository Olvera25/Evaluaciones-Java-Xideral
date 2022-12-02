package IDDV2;

public class Inyector {

	//De esta forma el inyector es quien asigna la especialidad
	static void InyEsp(Alumno alu) {
		
		alu.esp = new CienciasSalud(" salud");
	}
}
