package gestion;

import java.util.Vector;

import gestion.Vuelo;

public class Empleado extends Persona {
	
	// ================================================================================
	// ATRIBUTOS
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
	

	// =======================================================================
	// CONSTRUCTOR AUXILIAR
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
	// METODOS AUXILIAR
	
	public static Empleado nuevoEmpleado(String nombre, String pasaporte, String cargo, String horario) {
		Empleado empleado = new Empleado(nombre, pasaporte, cargo, horario);
		return empleado;
	}
	
	public String toString() {
		return "- " + this.getNombre() + " se desempe?a como " + this.getCargo() + " en el horario de " + this.getHorarioTrabajo() + ".";
	} 
	
	public static Empleado encontrarEmpleado(String codigo) {
		int i = 0;
		Empleado encontrado = null;
		while (i < empleados.size()) {
			if (empleados.get(i).getPasaporte().equals(codigo)) {
				encontrado = empleados.get(i);
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
