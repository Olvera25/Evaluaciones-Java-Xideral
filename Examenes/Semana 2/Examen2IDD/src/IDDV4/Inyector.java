package IDDV4;

public class Inyector {

	//De esta forma el inyector es quien asigna la especialidad
	static Alumno getAlumno() {
		
		//Especialidad Arquitectura = new Arquitectura(" arquitectura");
		Especialidad Informatica = new Informatica(" informática");

		return new Alumno("Eduardo Orlando","308", Informatica);
		
	} 
}
