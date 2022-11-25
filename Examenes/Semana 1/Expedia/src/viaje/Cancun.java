package viaje;

public class Cancun extends Destino{

	int ppersona = 1000;//Representa el precio por persona 
	int pdias = 500;//Representa el precio por día
	
	//Creamos el contructor
	Cancun(int persona, int dias) {
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
		return "Viajaran a Cancún "+persona+" personas por " +dias+ " dias ";
	}

	
}
