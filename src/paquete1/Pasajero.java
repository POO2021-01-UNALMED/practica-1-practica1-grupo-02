package paquete1;

import java.util.ArrayList;
import gestion.Vuelo;

public class Pasajero extends Persona {
	
	private String pasaporte;
	private String cumpleaños;
	private ArrayList<Equipaje> equipaje;
	private String clase;
	//private String cobro;
	private int millas;
	private boolean viajeroFrecuente;
	private Vuelo vuelo;
	
	
	// ===========================================================================================
	// CONSTRUCTOR
	
	
	public Pasajero(String nombre, String pasaporte, Vuelo vuelo, String cumpleaños, String clase, boolean viajeroFrecuente) {
		super(nombre, pasaporte);
		//pasaporte = pasaporte2;
		this.cumpleaños = cumpleaños;
		this.clase = clase;
		this.viajeroFrecuente = viajeroFrecuente;
		this.vuelo = vuelo;
		vuelo.pasajeros.add(this);
	}
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

	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
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
	
	// Métodos auxiliares
	static public Pasajero nuevoPasajero(String nombre, String pasaporte, Vuelo vuelo, String cumpleanos, String clase, boolean frecuente) {
		Pasajero pasajero = new Pasajero(nombre, pasaporte, vuelo, cumpleanos, clase, frecuente);
		return pasajero;
	}
		
}
