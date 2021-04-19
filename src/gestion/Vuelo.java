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
	private int costoGasolina;
	
	// ================================================================================
	// CONSTRUCTOR
	Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, Date fecha, Avion avion) {
		this.codigo = codigo;
		this.lugarPartida = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.avion = avion;
	}
	
	// ================================================================================
	// METODOS
	public void disponibilidad() {
		// Obtener estados de disponibilidad
		estado = false;
		boolean origen = lugarPartida.isEstado();
		boolean destino = destino.isEstado();
		boolean vuelo = isDisponibilidad();
		
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
				if (pasajero.clase.equals("A")) {
					pasajero.setMillas() = getMillas() + 350;					
				}
			}
		}
	}
	
	

}
