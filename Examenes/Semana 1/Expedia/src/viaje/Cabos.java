package viaje;

public class Cabos extends Destino{
	
	int ppersona = 1500;//Representa el precio por persona 
	int pdias = 600;//Representa el precio por día
	
	//Creamos el contructor
	Cabos(int persona, int dias) {
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
		return "Viajaran a Los Cabos "+persona+" personas por " +dias+ " dias ";
	}

}
