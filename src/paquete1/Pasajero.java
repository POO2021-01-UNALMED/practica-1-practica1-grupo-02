package paquete1;

import java.util.ArrayList;
import gestion.Vuelo;

public class Pasajero extends Persona {
	

	private String cumplea�os;
	private ArrayList<Equipaje> equipaje; //**
	private String clase;
	private Facturacion cobro;
	private float millas;
	private boolean viajeroFrecuente;
	
	
	// ===========================================================================================
	// CONSTRUCTOR
	
	public Pasajero(String nombre, Vuelo vuelo, String pasaporte, String cumplea�os, ArrayList<Equipaje> equipaje,
			String clase, Facturacion cobro, boolean viajeroFrecuente) {
		super(nombre, vuelo, pasaporte);
		this.cumplea�os = cumplea�os;
		this.equipaje = equipaje; //**
		this.clase = clase;
		this.cobro = cobro;
		this.viajeroFrecuente = viajeroFrecuente;
		vuelo.pasajeros.add(this);
		this.millaje();
	}
	
	// Constructor auxiliar para la creacion de nuevos objetos de la clase Pasajero
	public Pasajero(String nombre, String pasaporte, Vuelo vuelo, String cumplea�os, String clase, boolean viajeroFrecuente) {
		super(nombre, pasaporte);
		this.cumplea�os = cumplea�os;
		this.clase = clase;
		this.viajeroFrecuente = viajeroFrecuente;
		this.setVuelo(vuelo);
		vuelo.pasajeros.add(this);
		this.millaje();
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
	
	public String getCumplea�os() {
		return cumplea�os;
	}
	public void setCumplea�os(String cumplea�os) {
		this.cumplea�os = cumplea�os;
	}
	
	public float getMillas() {
		return millas;
	}
	public void setMillas(float millas) {
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
	// M�todos auxiliares
	static public Pasajero nuevoPasajero(String nombre, String pasaporte, Vuelo vuelo, String cumpleanos, String clase, boolean frecuente) {
		Pasajero pasajero = new Pasajero(nombre, pasaporte, vuelo, cumpleanos, clase, frecuente);
		return pasajero;
	}
		
	// ==================================
	// METODOS
	public void millaje() {
		float distancia = this.getVuelo().distancia(this.getVuelo().getLugarPartida(), 
				this.getVuelo().getDestino());  
		this.millas += distancia/100;
	}
}
