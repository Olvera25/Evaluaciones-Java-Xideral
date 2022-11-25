package viaje;

import java.util.*;


/*El objetivo del programa es conocer el costo del un viaje, a partir de 2 enteros que representan, 
el número de personas y el número de días. El costo cambiara dependiendo el destino (Mazunte, Cancún, etc.)*/

public class Viaje {

	public static void main(String[] args) {
		//Creamos un ArrayList
		List<Destino> ListaDestinos = new ArrayList<>();
		ListaDestinos.add(new Cancun(2,5));
		ListaDestinos.add(new Cabos(3,3));
		ListaDestinos.add(new Huatulco(5,2));
		ListaDestinos.add(new Mazunte(2,3));
	
		//Usamos el for each para iterar los elementos del ArrayList definido en el bloque anterior
		for(Destino des:ListaDestinos) {
			System.out.println(des.toString());
			System.out.println("El costo final del viaje es: "+des.costo());
			System.out.println("-----------------------------------------");
			
		}
	}

}
