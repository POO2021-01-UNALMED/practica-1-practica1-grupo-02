package paquete1;

import java.util.Vector;

import gestion.Vuelo;

public class Empleado extends Persona {

	private String cargo;
	private String horarioTrabajo;
	private boolean disponibilidad;
	private static Vector<Empleado> empleados = new Vector<Empleado>();

	// =======================================================================
	// CONSTRUCTOR
	
	public Empleado(String nombre, Vuelo vuelo, String pasaporte, String cargo, String horarioTrabajo,
			boolean disponibilidad) {
		super(nombre, vuelo, pasaporte);
		this.cargo = cargo;
		this.horarioTrabajo = horarioTrabajo;
		this.disponibilidad = disponibilidad;
		empleados.add(this);
	}
	


	// Constructor auxiliar para la creacion de nuevos objetos de la clase Empleado	
	public Empleado(String nombre, String pasaporte, String cargo, String horarioTrabajo) {
		super(nombre, pasaporte);
		this.cargo = cargo;
		this.horarioTrabajo = horarioTrabajo;
		this.disponibilidad = true;
		empleados.add(this);
	}
	
	// ======================================================================
	// GETTERS Y SETTERS
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getHorarioTrabajo() {
		return horarioTrabajo;
	}

	public void setHorarioTrabajo(String horarioTrabajo) {
		this.horarioTrabajo = horarioTrabajo;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public static Vector<Empleado> getEmpleados() {
		return empleados;
	}

	public static void setEmpleados(Vector<Empleado> Listaempleados) {
		empleados = Listaempleados;
	}


	// ==================================
	// METODO AUXILIAR
	
	public static Empleado nuevoEmpleado(String nombre, String pasaporte, String cargo, String horario) {
		Empleado empleado = new Empleado(nombre, pasaporte, cargo, horario);
		return empleado;
	}
	
	public String toString() {
		return "- " + this.getNombre() + " se desempeña como " + this.getCargo() + " en el horario de " + this.getHorarioTrabajo() + ".";
	} 



}
