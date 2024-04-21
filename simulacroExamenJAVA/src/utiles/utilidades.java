package utiles;

import java.util.List;

import dtos.Pasajeros;

public class utilidades {

	public long idGenerator(List<Pasajeros> pasajeros) {
		
		int tamano = pasajeros.size();
		long idNuevo;
		
		
		
		if(tamano > 0) {
			
			idNuevo = pasajeros.get(pasajeros.size()-1).getId();
			
		}else {
			
			idNuevo = 1;
		}
		
		return idNuevo;
		
	}
	
}
