package controladores;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.Pasajeros;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperacionImplementacion;
import servicios.OperacionInterfaz;

public class inicio {

	
	
	static List<Pasajeros> pasajero = new ArrayList<Pasajeros>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		int opcion;
		boolean cerrarMenu = false;
		MenuInterfaz mi = new MenuImplementacion();
		OperacionInterfaz op = new OperacionImplementacion();
		
		
		
		while (!cerrarMenu) {

			opcion = mi.opcionSeleccion();

			try {

				switch (opcion) {

				case 0:
					cerrarMenu = true;
					break;
				case 1:
					op.darAltaPaciente(sc, pasajero);
					break;
				case 2:
					
					op.accesoPuerto(pasajero,  sc);
					break;
				case 3:
					
					op.verPasajeros(pasajero);
					break;
				
				}
				
			} catch (Exception i) {
				System.out.println("Error" + i.getMessage());
			}
		}
	}

}
