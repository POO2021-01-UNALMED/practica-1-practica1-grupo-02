package paquete1;

import java.util.Vector;

import gestion.Vuelo;

public class Empleado extends Persona {

	private String cargo;
	private String horarioTrabajo;
	private boolean disponibilidad;
	Vector<Empleado> empleados = new Vector<Empleado>();

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

	// =======================================================================
	// CONSTRUCTOR
	
	public Empleado(String nombre, Vuelo vuelo, String pasaporte, String cargo, String horarioTrabajo,
			boolean disponibilidad, Vector<Empleado> empleados) {
		super(nombre, vuelo, pasaporte);
		this.cargo = cargo;
		this.horarioTrabajo = horarioTrabajo;
		this.disponibilidad = disponibilidad;
		this.empleados = empleados;
	}

	// ==================================
	// METODO AUXILIAR
	
	public static Empleado nuevoEmpleado(String nombre, String pasaporte, String cargo, String horario) {
		Empleado empleado = new Empleado(nombre, pasaporte, cargo, horario);
		return empleado;
}



}
