package paquete1;

import gestion.*;

public class Facturacion {
	private double total = 0;
	private double descuento = 0;
	private double costoInicial = 0;
	private Pasajero pasajero;
	private Vuelo vuelo;
	private boolean multas = false;

	
	// *************************************************************************************************
	// Constructores
	// *************************************************************************************************
	
	public Facturacion() {
		this(null, null);
		this.descuento = 0;
		this.total = 0;
		this.costoInicial = 0;
	}
	
	public Facturacion(Pasajero pasajero, Vuelo vuelo) {
		this.pasajero = pasajero;
		this.vuelo = vuelo;
		this.costoInicial = this.costoInicial(pasajero.getVuelo().getLugarPartida(), pasajero.getVuelo().getDestino());
		this.descuento = this.descuento();
		this.total = this.calcularCostos();
	}
	
	// *************************************************************************************************
	// Métodos
	// *************************************************************************************************
	
	public double multaEquipaje() {
		int i = 0;
		double multa = 0;
		while (i < this.pasajero.getEquipaje().size()) {
			if (this.pasajero.getEquipaje().get(i).soprepeso() == true) {
				this.multas = true;
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
		
		if (this.pasajero.getClase().equals("Primera Clase")) {
			if (this.pasajero.getEquipaje().size() > 4) {
				this.multas = true;
				double carga = this.pasajero.getEquipaje().size() - 4;
				carga = carga*35;
				multa = multa + carga;
			}
		}
		else {
			if (this.pasajero.getEquipaje().size() > 3) {
				this.multas = true;
				double carga = this.pasajero.getEquipaje().size() - 3;
				carga = carga*35;
				multa = multa + carga;
			}
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
		
		if (this.pasajero.getMillas() >= 1000 && this.pasajero.getMillas() <= 50000) {
			double descMillaje = this.pasajero.getMillas()/100000;
			descMillaje = descMillaje * 2;
			double precio = this.costoInicial - descuento;
			descuento = descuento + (precio * descMillaje);
			this.pasajero.setMillas(0);
		}
		else if (this.pasajero.getMillas() > 50000) {
			descuento = this.costoInicial;
			float diferencia = this.pasajero.getMillas() - 50000;
			this.pasajero.setMillas(diferencia);
		}
		return descuento;
	}
	
	public double costoInicial(Aeropuerto origen, Aeropuerto destino) {
		double costo = this.vuelo.distancia(origen, destino) * 0.24;
		return costo;
	}
	
	public double calcularCostos() {
		return this.costoInicial + this.multaEquipaje() - this.descuento;
	}
	public String toString() {
		if(this.multas) {
			return "*******************************************************"+"\n"+
					"FACTURACIÓN DEL PASAJERO: "+this.pasajero.getNombre()+"\n"+
					"COSTO DEL VUELO: "+this.costoInicial+"\n"+
					"DESCUENTOS: "+this.descuento+"\n"+
					"**** EL PASAJERO PRESENTA MULTAS ****"+"\n"+
					"MULTA POR EQUIPAJE: "+this.multaEquipaje()+"\n"+"\n"+
					"TOTAL A COBRAR: "+this.total+"\n"+
					"*******************************************************";
		}
		else {
			return "*******************************************************"+"\n"+
					"FACTURACIÓN DEL PASAJERO: "+this.pasajero.getNombre()+"\n"+
					"COSTO DEL VUELO: "+this.costoInicial+"\n"+
					"DESCUENTOS: "+this.descuento+"\n"+
					"**** EL PASAJERO NO PRESENTA MULTAS ****"+"\n"+"\n"+
					"TOTAL A COBRAR: "+this.total+"\n"+
					"*******************************************************";
		}
	}
	
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

	public boolean isMultas() {
		return multas;
	}
	public void setMultas(boolean multas) {
		this.multas = multas;
	}
	
}
