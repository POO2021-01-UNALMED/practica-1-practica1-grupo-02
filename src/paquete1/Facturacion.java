package paquete1;
import gestion.*;

public class Facturacion {
	private int total = 0;
	private float descuento = 0;
	private int costoInicial;
	private Pasajero pasajero;
	private Vuelo vuelo;
	private Equipaje equipaje;
	
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
	
	// Métodos
}
