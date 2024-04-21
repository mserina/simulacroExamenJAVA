package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import dtos.Pasajeros;
import utiles.utilidades;

public class OperacionImplementacion implements OperacionInterfaz {

	static String ruta = "C:\\Users\\Usuario\\Desktop\\ARCHIVOS\\regsitroABC.txt";
	utilidades util = new utilidades();
	static FileWriter sw;

	public void darAltaPaciente(Scanner sc, List<Pasajeros> pasajero) {

		boolean cerrar = false;

		String dni = "";

		System.out.println("Inserte DNI");

		while (!cerrar) {
			dni = sc.next();
			if (pasajero.size() > 0) {
				for (Pasajeros p : pasajero) {
					if (!p.getDni().equals(dni)) {
						cerrar = true;
					} else {
						System.out.println("Inserte otra vez el DNI");
					}
				}
			} else {
				cerrar = true;
			}
		}
		System.out.println("¿Va en vehiculo? s/n");
		String cocheS = sc.next();
		boolean coche = respuestasBoleean(cocheS);
		System.out.println("¿Va a embarcar? s/n");
		String embarcaS = sc.next();
		boolean embarca = respuestasBoleean(embarcaS);
		System.out.println("¿Tiene mercancia? s/n");
		String mercanciaS = sc.next();
		boolean mercancia = respuestasBoleean(mercanciaS);
		System.out.println("Inserte fecha del ticket de embarque (yyyy-MM-dd HH:mm)");
		String fechaTicket = sc.next();
		// Para pasar la fecha del usuario de string a fecha

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");
		LocalDateTime parsedDate = LocalDateTime.parse(fechaTicket, formatter);
		long id = util.idGenerator(pasajero);

		try {

			Pasajeros nuevoPasajero = new Pasajeros(dni, coche, embarca, mercancia, parsedDate, id);

			nuevoPasajero.setZonaDestino(asignacionSPuerta(nuevoPasajero));

			pasajero.add(nuevoPasajero);

		}

		catch (Exception e) {
			throw e;
		}
	}

	public void verPasajeros(List<Pasajeros> p) {

		for (Pasajeros pa : p) {

			System.out.println(" ");
			System.out.println("DNI: " + pa.getDni());
			System.out.println("ZONA: " + pa.getZonaDestino());
			System.out.println("FECHA TICKET: " + pa.getFechaTicket());
			System.out.println(" ");
		}
	}

	private String asignacionSPuerta(Pasajeros p) {

		String zona = "";
		if ((p.getMercancia().equals(true)) & p.getEmbarca().equals(true)) {

			zona = "P-SE";
		}
		if ((p.getMercancia().equals(false)) & p.getEmbarca().equals(true)) {

			zona = "P-SN";
		}

		if ((p.getCoche().equals(true)) & p.getEmbarca().equals(false)) {

			zona = "P-SO";

		}

		return zona;
	}

	private boolean respuestasBoleean(String h) {

		boolean respuesta = false;

		if (h.equals("s")) {
			respuesta = true;

		} else {
			respuesta = false;
		}

		return respuesta;
	}

	public void accesoPuerto(List<Pasajeros> p, Scanner sc) throws Exception {

		System.out.println("Inserte el DNI del pasajero");
		String dniInsertado = sc.next();

		try {

			for (Pasajeros pasajero : p) {
				if (dniInsertado.equals(pasajero.getDni())) {
					
					// ZONA SN
					if(pasajero.getZonaDestino().equals("P-SN"))
						puertaSN(p, dniInsertado);
					
					// ZONA SE
					if (pasajero.getZonaDestino().equals("P-SE")) {
						puertaSE(p,dniInsertado, sc);
					}

					// ZONA SO
					if (pasajero.getZonaDestino().equals("P-SO")) {

					
						sw = new FileWriter(ruta, true);
						sw.write("\n");
						sw.write("-------------------------------------------------- ");
						sw.write(" DNI: " + pasajero.getDni() + "\n");
						sw.write(" ZONA DESTINO: " + pasajero.getZonaDestino() + "\n");
						sw.write(" FECHA DE PASO:" + pasajero.getFechaHoy() + "\n");
						sw.write(" --------------------------------------------------");
						sw.close();

						
						puertaOE_ON(p, dniInsertado);
					}
					
				}
				else
				{
					System.out.println("El dni no existe");
				}
			}

		} catch (Exception e) {
			throw e;
		}
	}

	
	private void puertaSN(List<Pasajeros> pasajero, String dniInsertado) throws IOException {
		// ZONA SN
		try {
			for(Pasajeros p : pasajero) {
				if(dniInsertado.equals(dniInsertado)) {
					if (p.getZonaDestino().equals("P-SN")) {
						System.out.println("El pasajero fue enbarcado en la puerta SN");
						sw = new FileWriter(ruta, true);
						sw = new FileWriter(ruta, true);
						sw.write("\n");
						sw.write("-------------------------------------------------- " + "\n");
						sw.write(" DNI: " + p.getDni() + "\n");
						sw.write(" ZONA DESTINO: " + p.getZonaDestino() + "\n");
						sw.write(" FECHA DE PASO:" + p.getFechaHoy() + "\n");
						sw.write(" --------------------------------------------------");
						
						sw.close();
					} else {
						System.out.println("El pasajero tiene asignado una zona distinta");
					}
				}
			}	
		}catch(IOException e) {
			throw e;
		}

	}
	
	
	private void puertaOE_ON(List<Pasajeros> pasajeros, String dniInsertado) throws IOException{

		for (Pasajeros p : pasajeros) {
			if (dniInsertado.equals(p.getDni())) {
				try {
					if (p.getMercancia().equals(true) & (p.getEmbarca().equals(false))) {

						p.setZonaDestino("P-OE");

						if (p.getZonaDestino().equals("P-OE")) {

							System.out.println("El pasajero fue a la puerta OE");
							
							sw = new FileWriter(ruta, true);
							sw.write("\n");
							sw.write("-------------------------------------------------- " + "\n");
							sw.write(" DNI: " + p.getDni() + "\n");
							sw.write(" ZONA DESTINO: " + p.getZonaDestino() + "\n");
							sw.write(" FECHA DE PASO:" + p.getFechaHoy() + "\n");
							sw.write(" --------------------------------------------------");
							
							sw.close();

						}

					}
					else 
					{
						p.setZonaDestino("P-ON");
						//ZONA ON
						System.out.println("El pasajero embarco en la puerta ON");
						sw = new FileWriter(ruta, true);
						sw.write("\n");
						sw.write("-------------------------------------------------- " + "\n");
						sw.write(" DNI: " + p.getDni() + "\n");
						sw.write(" ZONA DESTINO: " + p.getZonaDestino() + "\n");
						sw.write(" FECHA DE PASO:" + p.getFechaHoy() + "\n");
						sw.write(" --------------------------------------------------");
						
						sw.close();
					}

				}
				catch(IOException e) {
					throw e;
				}
			}
		}

	}

	private void puertaSE(List<Pasajeros> pasajero, String dniInsertado, Scanner sc) throws IOException {
		// ZONA SE
		try {
			for(Pasajeros p : pasajero) {
				if(dniInsertado.equals(dniInsertado)) {
					if (p.getZonaDestino().equals("P-SE")) {
						
						sw = new FileWriter(ruta, true);
						sw = new FileWriter(ruta, true);
						sw.write("\n");
						sw.write("-------------------------------------------------- " + "\n");
						sw.write(" DNI: " + p.getDni() + "\n");
						sw.write(" ZONA DESTINO: " + p.getZonaDestino() + "\n");
						sw.write(" FECHA DE PASO:" + p.getFechaHoy() + "\n");
						sw.write(" --------------------------------------------------");
						
						sw.close();

						
					
						p.setZonaDestino("PIF");
						
						pif(pasajero,dniInsertado, sc);
					} 
					else 
					{
						System.out.println("El pasajero tiene asignado una zona distinta");
					}
				}
			}	
		}catch(IOException e) {
			throw e;
		}
	}
	
	private void pif(List<Pasajeros> pasajero, String dniInsertado, Scanner sc) throws IOException{
		
		try {
			for(Pasajeros p : pasajero) {
				if(dniInsertado.equals(dniInsertado)) {
					sw = new FileWriter(ruta, true);
					sw.write("\n");
					sw.write("-------------------------------------------------- " + "\n");
					sw.write(" DNI: " + p.getDni() + "\n");
					sw.write(" ZONA DESTINO: " + p.getZonaDestino() + "\n");
					sw.write(" FECHA DE PASO:" + p.getFechaHoy() + "\n");
					sw.write(" --------------------------------------------------");
					
					sw.close();

					
					System.out.println("Verifique si es apto o no s/n");
					String respuesta = sc.next();
					if(respuesta.equals("s"))
					{
						p.setApta(true);
						p.setZonaDestino("P-EN");
						puertaEN(pasajero, dniInsertado);
					}
					else 
					{
						p.setApta(false);
						System.out.println("Su mercancia no es apta");
						p.setZonaDestino("P-SE");
					}
				}
			}
		}
		catch(IOException e) {
			throw e;
		}
		
	}
	
	private void puertaEN(List<Pasajeros> pasajero, String dniInsertado) throws IOException{
		System.out.println("Su vehiculo ha envarcado en la puerta EN");
		try{
			for(Pasajeros p : pasajero) {
				if(dniInsertado.equals(dniInsertado)) {
					sw = new FileWriter(ruta, true);
					sw.write("\n");
					sw.write("-------------------------------------------------- " + "\n");
					sw.write(" DNI: " + p.getDni() + "\n");
					sw.write(" ZONA DESTINO: " + p.getZonaDestino() + "\n");
					sw.write(" FECHA DE PASO:" + p.getFechaHoy() + "\n");
					sw.write(" --------------------------------------------------");
					
					sw.close();

				}
			}
				
		}
		catch(IOException e){
			throw e;
		}
	}
}
