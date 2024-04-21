package dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase que contiene los atributos y metodos de los pasajeros
 * msm - 160404
 */
public class Pasajeros {

	
	String dni;
	String zonaDestino;
	boolean coche = false;
	boolean embarca = false;
	boolean mercancia = false;
	boolean apta = false;
	LocalDateTime fechaHoy = LocalDateTime.now();
	LocalDateTime fechaTicket;
	long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean getApta() {
		return apta;
	}
	public void setApta(boolean apta) {
		this.apta = apta;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getZonaDestino() {
		return zonaDestino;
	}
	public void setZonaDestino(String zonaDestino) {
		this.zonaDestino = zonaDestino;
	}
	public Boolean getCoche() {
		return coche;
	}
	public void setCoche(Boolean coche) {
		this.coche = coche;
	}
	public Boolean getEmbarca() {
		return embarca;
	}
	public void setEmbarca(Boolean embarca) {
		this.embarca = embarca;
	}
	public Boolean getMercancia() {
		return mercancia;
	}
	public void setMercancia(Boolean mercancia) {
		this.mercancia = mercancia;
	}
	public LocalDateTime getFechaHoy() {
		return fechaHoy;
	}
	public void setFechaHoy(LocalDateTime fechaHoy) {
		this.fechaHoy = fechaHoy;
	}
	public LocalDateTime getFechaTicket() {
		return fechaTicket;
	}
	public void setFechaTicket(LocalDateTime fechaTicket) {
		this.fechaTicket = fechaTicket;
	}
	
	
	
	public Pasajeros(String dni, Boolean coche, Boolean embarca, Boolean mercancia, LocalDateTime fechaTicket, long id) {
		super();
		this.dni = dni;
		this.coche = coche;
		this.embarca = embarca;
		this.mercancia = mercancia;
		this.fechaTicket = fechaTicket;
		this.id = id;
	}
	
	public Pasajeros() {
		
	}
}
