package viaje;

public class Mazunte extends Destino{
	
	int ppersona = 1000;//Representa el precio por persona 
	int pdias = 700;//Representa el precio por día
	
	//Creamos el contructor
	Mazunte(int persona, int dias) {
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
		return "Viajaran a Mazunte "+persona+" personas por " +dias+ " dias ";
	}
}
