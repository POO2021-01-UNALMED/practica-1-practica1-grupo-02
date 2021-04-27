package paquete1;

import gestion.*;

public class Facturacion {
	private double total = 0;
	private double descuento = 0;
	private double costoInicial = 0;
	private Pasajero pasajero;
	private Vuelo vuelo;
	private Equipaje equipaje;
	
	// *************************************************************************************************
	// Constructores
	// *************************************************************************************************
	
	public Facturacion() {
		this(null, null, null);
		this.descuento = 0;
		this.total = 0;
		this.costoInicial = 0;
	}
	
	public Facturacion(Pasajero pasajero, Vuelo vuelo, Equipaje equipaje) {
		this.pasajero = pasajero;
		this.vuelo = vuelo;
		this.equipaje = equipaje;
		this.costoInicial = this.costoInicial(pasajero.getVuelo().getLugarPartida(), pasajero.getVuelo().getDestino());
		this.descuento = this.descuento();
		//this.total = this.calcularCostos();
	}
	
	// *************************************************************************************************
	// Métodos
	// *************************************************************************************************
	
	public double multaEquipaje() {
		int i = 0;
		double multa = 0;
		while (i < this.pasajero.getEquipaje().size()) {
			if (this.pasajero.getEquipaje().get(i).soprepeso() == true) {
				if (this.pasajero.getEquipaje().get(i).getTipo().equals("Mano")) {
					if (this.pasajero.getClase().equals("Primera Clase")) {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 12;
						multa = tope * 15;
					}
					else {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 10;
						multa = tope * 12;
					}
				}
				else if (this.pasajero.getEquipaje().get(i).getTipo().equals("Bodega")) {
					if (this.pasajero.getClase().equals("Primera Clase")) {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 25;
						multa = tope * 20;
					}
					else {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 20;
						multa = tope * 18;
					}
				}
			}
			else {
				multa = 0;
			}
			i ++;
		}
		return multa;
	}
	
	public double descuento() {
		double descuento = 0;
		if (this.pasajero.isViajeroFrecuente()) {
			descuento = this.costoInicial * 0.1;
		}
		else {
			descuento = 0;
		}
		return descuento;
	}
	
	public double costoInicial(Aeropuerto origen, Aeropuerto destino) {
		double costo = this.vuelo.distancia(origen, destino) * 0.24;
		return costo;
	}
	// multaCancelacion()
	// calcularCostos()
	// toString()
	
	// *************************************************************************************************
	// Getters & Setters
	// *************************************************************************************************
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getCostoInicial() {
		return costoInicial;
	}
	public void setCostoInicial(double costoInicial) {
		this.costoInicial = costoInicial;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Equipaje getEquipaje() {
		return equipaje;
	}
	public void setEquipaje(Equipaje equipaje) {
		this.equipaje = equipaje;
	}
	
}
