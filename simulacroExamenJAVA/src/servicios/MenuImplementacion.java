package servicios;

import java.util.Scanner;


public class MenuImplementacion implements MenuInterfaz {

	
	Scanner sc = new Scanner (System.in);
	
	public int opcionSeleccion() {
		Integer opcion;
		
		System.out.println(" ");
		System.out.println("0[] CERRAR");
		System.out.println("1[] ALTA PASAJERO");
		System.out.println("2[] ACCESO AL PUERTO");
		
		
		opcion = sc.nextInt(); 
		return opcion;
	}
}
