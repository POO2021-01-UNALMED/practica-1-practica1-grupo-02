package gestion;

import java.util.Vector;
import java.util.Iterator;

public class Avion {
	// ================================================================================
	// ATRIBUTOS
	private String matricula;
	Vector<Vuelo> vuelos = new Vector<>();
	private String modelo;
	private int capacidad;
	private int numeroTripulacion;
	private boolean disponibilidad;
	private int masa;
	public static Vector<Avion> aviones = new Vector<Avion>();

	// ================================================================================
	// CONSTRUCTOR
	public Avion(String matricula, String modelo, int capacidad, int tripulacion, int masa) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.numeroTripulacion = tripulacion;
		this.masa = masa;
		Avion.aviones.add(this);
	}

	// ================================================================================
	// GETTERS Y SETTERS

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Vector<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(Vector<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNumeroTripulacion() {
		return numeroTripulacion;
	}

	public void setNumeroTripulacion(int numeroTripulacion) {
		this.numeroTripulacion = numeroTripulacion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getMasa() {
		return masa;
	}

	public void setMasa(int masa) {
		this.masa = masa;
	}

	// Metodos auxiliares
	static public Avion buscarAvion(String matricula) {
		Iterator<Avion> iteradorAvion = aviones.iterator();
		while(iteradorAvion.hasNext()) {
			Avion avion = (Avion) iteradorAvion.next();
			if (avion.matricula.equals(matricula)) {
				return avion;
			}
		}
		return null;
	}
}
