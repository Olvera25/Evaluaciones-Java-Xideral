package IDDV4;

public class CienciasSalud implements Especialidad{
	
	//Creamos la variable privada area de tipo String
	private String area;
	
	//Creamos el contructor
	public CienciasSalud(String area) {
		this.area = area;
	}
	
	//Sobrescribimos el método asignar
	@Override
	public void Asignar() {
		System.out.println(" se asigno a la especialidad de"+area);
	}
}
