package paquete1;

import java.util.ArrayList;
import gestion.Vuelo;

public class Pasajero extends Persona {
	

	private String cumpleaños;
	private ArrayList<Equipaje> equipaje; //**
	private String clase;
	private Facturacion cobro;
	private int millas;
	private boolean viajeroFrecuente;
	
	
	// ===========================================================================================
	// CONSTRUCTOR
	
	public Pasajero(String nombre, Vuelo vuelo, String pasaporte, String cumpleaños, ArrayList<Equipaje> equipaje,
			String clase, Facturacion cobro, boolean viajeroFrecuente) {
		super(nombre, vuelo, pasaporte);
		this.cumpleaños = cumpleaños;
		this.equipaje = equipaje; //**
		this.clase = clase;
		this.cobro = cobro;
		this.viajeroFrecuente = viajeroFrecuente;
		vuelo.pasajeros.add(this);
	}
	
	// Constructor auxiliar para la creacion de nuevos objetos de la clase Pasajero
	public Pasajero(String nombre, String pasaporte, Vuelo vuelo, String cumpleaños, String clase, boolean viajeroFrecuente) {
		super(nombre, pasaporte);
		this.cumpleaños = cumpleaños;
		this.clase = clase;
		this.viajeroFrecuente = viajeroFrecuente;
		this.setVuelo(vuelo);
		vuelo.pasajeros.add(this);
	}



	// ======================================================================
	// GETTERS Y SETTERS
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
	public void nuevoEquipaje(Equipaje equipaje) {
		this.equipaje.add(equipaje);
	}
	public ArrayList<Equipaje> getEquipaje() {
		return equipaje;
	}
	
	public String getCumpleaños() {
		return cumpleaños;
	}
	public void setCumpleaños(String cumpleaños) {
		this.cumpleaños = cumpleaños;
	}
	
	public int getMillas() {
		return millas;
	}
	public void setMillas(int millas) {
		this.millas = millas;
	}
	
	public boolean isViajeroFrecuente() {
		return viajeroFrecuente;
	}
	public void setViajeroFrecuente(boolean viajeroFrecuente) {
		this.viajeroFrecuente = viajeroFrecuente;
	}
	
	
	public Facturacion getCobro() {
		return cobro;
	}

	public void setCobro(Facturacion cobro) {
		this.cobro = cobro;
	}

	public void setEquipaje(ArrayList<Equipaje> equipaje) {
		this.equipaje = equipaje;
	}

	// ======================================================================
	// Métodos auxiliares
	static public Pasajero nuevoPasajero(String nombre, String pasaporte, Vuelo vuelo, String cumpleanos, String clase, boolean frecuente) {
		Pasajero pasajero = new Pasajero(nombre, pasaporte, vuelo, cumpleanos, clase, frecuente);
		return pasajero;
	}
		
}
