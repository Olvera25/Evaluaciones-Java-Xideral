package viaje;

public class Huatulco extends Destino{

	int ppersona = 800;//Representa el precio por persona 
	int pdias = 500;//Representa el precio por día
	
	//Creamos el contructor
	Huatulco(int persona, int dias) {
		super(persona,dias);
	}
	
	//Sobrescribimos el método costo
	@Override
	int costo() {
		return (persona*ppersona) + (dias*pdias);
	}
	
	//Sobrescribimos el método toString para que nos envíe el mensaje dependiendo el destino.
	@Override
	public String toString() {
		return "Viajaran a Huatulco "+persona+" personas por " +dias+ " dias ";
	}
}
