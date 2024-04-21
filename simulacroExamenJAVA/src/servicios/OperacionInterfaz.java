package servicios;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import dtos.Pasajeros;

public interface OperacionInterfaz {


	public void accesoPuerto(List<Pasajeros> p, Scanner sc) throws Exception;
	
	public void darAltaPaciente(Scanner sc, List<Pasajeros> pasajero );
	
	public void verPasajeros(List<Pasajeros> p);
	
}
