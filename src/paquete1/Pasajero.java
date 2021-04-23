package paquete1;

import java.util.ArrayList;

public class Pasajero extends Persona {
	
	private String pasaporte;
	private String cumpleaños;
	private ArrayList<Equipaje> equipaje;
	private String clase;
	//private String cobro;
	private int millas;
	private boolean viajeroFrecuente;
	
	
	
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

}
