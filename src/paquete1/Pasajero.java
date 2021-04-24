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
		
}
