package gestion;

import java.io.Serializable;

import gestion.Vuelo;

public class Persona implements Serializable{

	// ================================================================================
	// ATRIBUTOS
	private String nombre;
	private Vuelo vuelo;
	private String pasaporte;
	
	
	
	// ===========================================================================================
	// CONSTRUCTOR
	public Persona(String nombre, Vuelo vuelo, String pasaporte) {
		super();
		this.nombre = nombre;
		this.vuelo = vuelo;
		this.pasaporte = pasaporte;
	}
	
	
	
	// ================================================================================
	// CONSTRUCTOR AUXILIAR
	public Persona(String nombre, String pasaporte) {
		super();
		this.nombre = nombre;
		this.pasaporte = pasaporte;
	}

	
	
	
	// ================================================================================
	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	

	

}
