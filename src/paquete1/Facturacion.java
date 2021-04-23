package paquete1;
import gestion.*;

public class Facturacion {
	private int total = 0;
	private float descuento = 0;
	private int costoInicial;
	private Pasajero pasajero;
	private Vuelo vuelo;
	private Equipaje equipaje;
	
	// *************************************************************************************************
	// Constructores
	// *************************************************************************************************
	
	public Facturacion() {
		this(0, null, null, null);
		this.descuento = 0;
		this.total = 0;
	}
	
	public Facturacion(int costoInicial, Pasajero pasajero, Vuelo vuelo, Equipaje equipaje) {
		this.costoInicial = costoInicial;
		this.pasajero = pasajero;
		this.vuelo = vuelo;
		this.equipaje = equipaje;
		//this.descuento = this.descuento();
		//this.total = this.calcularCostos();
	}
	
	// *************************************************************************************************
	// Métodos
	// *************************************************************************************************
	
	public int multaEquipaje() {
		int i = 0;
		int multa;
		while (i < this.pasajero.getEquipaje().size()) {
			if (this.pasajero.getEquipaje().get(i).soprepeso() == true) {
				this.pasajero.getEquipaje().get(i)
			}
			else {
				multa = 0;
			}
			i ++;
		}
	}
	// multaCancelacion()
	// descuento()
	// calcularCostos()
	// toString()
	
	// *************************************************************************************************
	// Getters and Setters
	// *************************************************************************************************
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public int getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(int costoInicial) {
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
