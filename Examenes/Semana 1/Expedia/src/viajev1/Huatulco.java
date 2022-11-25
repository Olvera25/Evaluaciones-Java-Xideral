package viajev1;

public class Huatulco implements Destino{

	//Definimos las variables que ocuparemos 
	int persona, dias;
	
	int ppersona = 1000;//Representa el precio por persona
	
	int pdias = 500;//Representa el precio por día
	
	//Creamos el constructor
	Huatulco(int persona, int dias){
		this.persona = persona;
		this.dias = dias;
	}
	
	//Sobrescribimos el método costo
	@Override
	public int costo() {
		return (persona*ppersona) + (dias*pdias);
	}
	
	//Sobrescribimos el método toString para que nos envíe el mensaje dependiendo el destino.
	@Override
	public String toString() {
		return "Viajaran a Cancún "+persona+" personas por " +dias+ " dias ";
	}
}
