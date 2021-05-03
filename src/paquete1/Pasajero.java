package paquete1;

import java.util.ArrayList;
import gestion.Vuelo;

public class Pasajero extends Persona {
	

	private String cumpleaños;
	private ArrayList<Equipaje> equipaje;
	private String clase;
	private Facturacion cobro;
	private float millas;
	private boolean viajeroFrecuente;
	static private ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
	
	
	// ===========================================================================================
	// CONSTRUCTOR
	
	public Pasajero(String nombre, Vuelo vuelo, String pasaporte, String cumpleaños, ArrayList<Equipaje> equipaje,
			String clase, Facturacion cobro, boolean viajeroFrecuente) {
		super(nombre, vuelo, pasaporte);
		this.cumpleaños = cumpleaños;
		this.equipaje = equipaje; //**
		this.clase = clase;
		this.cobro = cobro;
		this.cobro.setPasajero(this);
		this.viajeroFrecuente = viajeroFrecuente;
		vuelo.pasajeros.add(this);
		pasajeros.add(this);
		this.millaje();
	}
	
	// Constructor auxiliar para la creacion de nuevos objetos de la clase Pasajero
	public Pasajero(String nombre, String pasaporte, Vuelo vuelo, String cumpleaños, String clase, boolean viajeroFrecuente) {
		super(nombre, pasaporte);
		this.cumpleaños = cumpleaños;
		this.clase = clase;
		this.viajeroFrecuente = viajeroFrecuente;
		this.setVuelo(vuelo);
		vuelo.pasajeros.add(this);
		pasajeros.add(this);
		this.millaje();
		this.cobro = new Facturacion(this, vuelo);
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
	// Métodos auxiliares
	static public Pasajero nuevoPasajero(String nombre, String pasaporte, Vuelo vuelo, String cumpleanos, String clase, boolean frecuente) {
		Pasajero pasajero = new Pasajero(nombre, pasaporte, vuelo, cumpleanos, clase, frecuente);
		return pasajero;
	}
	
	public static Pasajero encontrarPasajero(String codigo) {
		int i = 0;
		Pasajero encontrado = null;
		while (i < pasajeros.size()) {
			if (pasajeros.get(i).getPasaporte().equals(codigo)) {
				encontrado = pasajeros.get(i);
				break;
			}
			else {
				encontrado = null;
			}
			i++;
		}
		return encontrado;
	}
		
	// ==================================
	// METODOS
	public void millaje() {
		float distancia = this.getVuelo().distancia(this.getVuelo().getLugarPartida(), 
				this.getVuelo().getDestino());  
		this.millas += distancia/100;
	}
	
	public String toString() {
		return "El pasajero "+this.getNombre()+" ha sido inscrito al vuelo "+this.getVuelo().getCodigo()+"\n"+
				"que parte desde "+this.getVuelo().getLugarPartida().getCiudad()+" con destino a la ciudad de "+this.getVuelo().getDestino().getCiudad()+"\n"+
				"El vuelo partirá el día "+this.getVuelo().getFecha();
	}
}
