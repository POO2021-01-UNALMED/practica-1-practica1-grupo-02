package gestion;

import java.io.Serializable;
import java.util.Vector;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import paquete1.Pasajero;
import paquete1.Empleado;

public class Vuelo implements Serializable{
	// ================================================================================
	// ATRIBUTOS
	private String codigo;
	private Aeropuerto lugarPartida;
	private Aeropuerto destino;
	private String fecha;
	public Vector<Pasajero> pasajeros = new Vector<>();
	private Avion avion;
	private Vector<Empleado> tripulacion = new Vector<>();
	private boolean estado;
	private float costoGasolina;
	static Vector<Vuelo> vuelos = new Vector<Vuelo>();
	private float distancia;

	
	// ================================================================================
	// CONSTRUCTOR
	public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, String fecha, Avion avion) {
		this.codigo = codigo;
		this.lugarPartida = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.avion = avion;
		avion.vuelos.add(this);
		origen.vuelos.add(this);
		destino.vuelos.add(this);
		vuelos.add(this);
		this.distancia = distancia(origen, destino);
		this.setCostoGasolina(this.distancia);

	}
	
	// ================================================================================
	// METODOS
	public void disponibilidad() {
		// Obtener estados de disponibilidad
		// TODO Cambiar de void a String
		estado = false;
		boolean aircraft = this.avion.isDisponibilidad();
		boolean origen = this.lugarPartida.isEstado();
		boolean destino = this.destino.isEstado();
		
		// Modificar estado del vuelo
		if (origen && destino && aircraft) {
			estado = true;
		}
		
		// Bonificacion a los pasajeros por afectacion
		if (estado) {
			System.out.println("¡Enhorabuena! El vuelo está programado y en orden\n" +
								"¡Alas y buen viento!");
		}
		
		else {
			System.out.println("Lo sentimos, pero el vuelo ha sido cancelado\n" + 
								"Todos los pasajeros recibirán millas en compensación");
			for (Pasajero pasajero : pasajeros) {
				if (pasajero.getClase().equals("A")) {
					pasajero.setMillas(pasajero.getMillas() + 350);
					System.out.println("El pasajero " + pasajero.getNombre() + " ha recibido 350 millas.");
				}
				else if (pasajero.getClase().equals("B")) {
					pasajero.setMillas(pasajero.getMillas() + 100);
					System.out.println("El pasajero " + pasajero.getNombre() + " ha recibido 100 millas.");
				}
			}
		}
	}

	public float distancia(Aeropuerto origen, Aeropuerto destino) {
		// Valores basicos <- estan dados en radianes
		float latDest = (float) (origen.getLat() / (180/Math.PI));;
		float lonDest = (float) (origen.getLon() / (180/Math.PI));;
		float latOrig = (float) (destino.getLat() / (180/Math.PI));;
		float lonOrig = (float) (destino.getLon() / (180/Math.PI));;

		// Se usa la ecuacion de Haversine
		float distance = (float) (Math.sin(latDest) * Math.sin(latOrig));
		distance += Math.cos(latDest) * Math.cos(latOrig) * Math.cos(lonDest - lonOrig);
		distance = (float) Math.acos(distance);
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
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
		return (int) costoGasolina;
	}

	public void setCostoGasolina(float distance) {
		float distancia = (float) (distance / 1.609);
		float gasolina;
		float totalEquipaje = 0;
		gasolina = (this.pasajeros.size() + this.tripulacion.size()) * 100;
		for (Pasajero pasajero : pasajeros) {
			for (int i = 0; i < pasajero.getEquipaje().size(); i++) {
				totalEquipaje += pasajero.getEquipaje().get(i).getMasa();
			}
		}
		totalEquipaje += tripulacion.size()* 2 * 23;
		totalEquipaje *= 1.05;
		gasolina += this.avion.getMasa() + totalEquipaje;
		gasolina *= 0.002 * distancia;
		this.costoGasolina = gasolina;		
	}	

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public static Vector<Vuelo> getVuelos() {
		return vuelos;
	}

	public static void setVuelos(Vector<Vuelo> vuelos) {
		Vuelo.vuelos = vuelos;
	}

	// Métodos auxiliares
	static public Vuelo nuevoVuelo(String codigo, Aeropuerto origen, Aeropuerto destino, String fecha, Avion avion) {
		Vuelo vuelo = new Vuelo(codigo, origen, destino, fecha, avion);
		return vuelo;
	}
	
	public String toString() {
		return "El vuelo " + this.getCodigo() + " de POO Airways sale del aeropuerto " +  this.getLugarPartida().getCodigo() + " de la ciudad de " +
				this.getLugarPartida().getCiudad() + "\n el día " +  this.getFecha() + " con destino al aeropuerto de " + this.getDestino().getCodigo() + 
				" de la ciudad de " + this.getDestino().getCiudad() + ".\nDe momento este vuelo tiene " + this.getPasajeros().size() + "y se estima que" +
				" su costo de gasolina equivale a unos " + this.getCostoGasolina() + " USD.";
	}
	
	public static Vuelo getVuelo(String codigo) {
		int i = 0;
		Vuelo encontrado = null;
		while (i < vuelos.size()) {
			if (vuelos.get(i).getCodigo().equals(codigo)) {
				encontrado = vuelos.get(i);
				break;
			}
			else {
				encontrado = null;
			}
			i++;
		}
		return encontrado;
	}
	
}