package gestion;

import java.util.Date;
import java.util.Vector;
import paquete1.Pasajero;
import paquete1.Empleado;

public class Vuelo {
	// ================================================================================
	// ATRIBUTOS
	private String codigo;
	private Aeropuerto lugarPartida;
	private Aeropuerto destino;
	private Date fecha;
	private Vector<Pasajero> pasajeros = new Vector<>();
	private Avion avion;
	private Vector<Empleado> tripulacion = new Empleado<>();
	private boolean estado;
	private float costoGasolina;
	
	// ================================================================================
	// CONSTRUCTOR
	public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, Date fecha, Avion avion) {
		this.codigo = codigo;
		this.lugarPartida = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.avion = avion;
		avion.vuelos.add(this);
	}
	
	// ================================================================================
	// METODOS
	public void disponibilidad() {
		// Obtener estados de disponibilidad
		estado = false;
		boolean origen = lugarPartida.isEstado();
		boolean destino = destino.isEstado();
		boolean vuelo = this.isDisponibilidad();
		
		// Modificar estado del vuelo
		if (origen && destino && vuelo) {
			estado = true;
		}
		
		// Bonificacion a los pasajeros por afectacion
		if (estado) {
			System.out.println("¡Enhorabuena! El vuelo está programado y en orden\n" +
								"¡Alas y buen viento!");
		}
		
		else {
			System.out.println("Lo sentimos, pero el vuelo ha sido cancelado\n" + 
								"Todos los pasajeros recibirán millan en compensación");
			for (Pasajero pasajero : pasajeros) {
				if (pasajero.getClase().equals("A")) {
					pasajero.setMillas() = getMillas() + 350;
					System.out.println("El pasajero " + pasajero.getNombre() + " ha recibido 350 millas.");
				}
				else if (pasajero.getClase().equals("B")) {
					pasajero.setMillas() = getMillas() + 100;
					System.out.println("El pasajero " + pasajero.getNombre() + " ha recibido 100 millas.");
				}
			}
		}
	}

	public float distancia() {
		// Valores basicos <- estan dados en radianes
		float latDest = this.destino.getLat() / (180/Math.PI);;
		float lonDest = this.destino.getLon() / (180/Math.PI);;
		float latOrig = this.lugarPartida.getLat() / (180/Math.PI);;
		float lonOrig = this.lugarPartida.getLon() / (180/Math.PI);;

		// Se usa la ecuacion de Haversine
		float distance = Math.sin(latDest) * Math.sin(latOrig);
		distance += Math.cos(latDest) * Math.cos(latOrig) * Math.cos(lonDest - lonOrig);
		distance = Math.acos(distance);
		distance = 3963 * distance;
		return distance;
	}
	
	// ================================================================================
	// GETTERS Y SETTERS

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Aeropuerto getLugarPartida() {
		return lugarPartida;
	}

	public void setLugarPartida(Aeropuerto lugarPartida) {
		this.lugarPartida = lugarPartida;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Vector<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Vector<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Vector<Empleado> getTripulacion() {
		return tripulacion;
	}

	public void setTripulacion(Vector<Empleado> tripulacion) {
		this.tripulacion = tripulacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCostoGasolina() {
		return costoGasolina;
	}

	public void setCostoGasolina() {
		float distancia = this.distancia() / 1.609;
		float gasolina;
		float totalEquipaje;
		gasolina = (this.pasajeros.size() + this.tripulacion.size()) * 100;
		for (Pasajero pasajero : pasajeros) {
			for (int i = 0; i < pasajero.equipaje.size(); i++) {
				totalEquipaje += pasajero.equipaje.get(i).getMasa();
			}
		}
		totalEquipaje += tripulacion.size()* 2 * 23;
		totalEquipaje *= 1.05;
		gasolina += this.avion.getMasa() + totalEquipaje;
		gasolina *= 0.50;
		this.costoGasolina = gasolina;
		
	}
}