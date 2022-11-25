package viaje;

//Definimos una clase abstracta 
public abstract class Destino {
	
	//Declaramos variables 
	int persona;
	int dias;
	
	//Creamos el contructor
	Destino(int persona, int dias){
		this.persona = persona;
		this.dias = dias;
	}
	
	//Creamos el método abstracto costo que sera sobrescrito
	abstract int costo();
	
}
