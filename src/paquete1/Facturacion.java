package paquete1;

import gestion.*;

public class Facturacion {
	private double total = 0;
	private double descuento = 0;
	private double costoInicial = 0;
	private Pasajero pasajero;
	private Vuelo vuelo;
	private boolean multas = false;
	private boolean canjeaMillas = false;

	
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
		this.costoInicial = this.costoInicial();
		this.descuento = this.descuento();
		this.total = this.calcularCostos();
		this.pasajero.setCobro(this);
	}
	
	// *************************************************************************************************
	// Métodos
	// *************************************************************************************************
	
	public int multaEquipaje() {
		int i = 0;
		int multa = 0;
		while (i < this.pasajero.getEquipaje().size()) {
			if (this.pasajero.getEquipaje().get(i).soprepeso() == true) {
				this.multas = true;
				if (this.pasajero.getEquipaje().get(i).getTipo().equals("Mano")) {
					if (this.pasajero.getClase().equals("Primera Clase")) {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 12;
						multa += tope * 15;
					}
					else {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 10;
						multa += tope * 12;
					}
				}
				else if (this.pasajero.getEquipaje().get(i).getTipo().equals("Bodega")) {
					if (this.pasajero.getClase().equals("Primera Clase")) {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 25;
						multa += tope * 20;
					}
					else {
						int tope = this.pasajero.getEquipaje().get(i).getMasa() - 20;
						multa += tope * 18;
					}
				}
			}
			i ++;
		}
		
		if (this.pasajero.getClase().equals("Primera Clase")) {
			if (this.pasajero.getEquipaje().size() > 4) {
				this.multas = true;
				int carga = this.pasajero.getEquipaje().size() - 4;
				carga = carga*35;
				multa = multa + carga;
			}
		}
		else {
			if (this.pasajero.getEquipaje().size() > 3) {
				this.multas = true;
				int carga = this.pasajero.getEquipaje().size() - 3;
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
		
		this.descuento = Math.round(descuento*10.0)/10.0;
		return Math.round(descuento*10.0)/10.0;
	}
	
	public double canjearMillas() {
		this.canjeaMillas = true;
		double descMillaje = 0;
		float millas = this.pasajero.getMillas();
		if (millas >= 1000 && millas <= 50000) {
			descMillaje = millas/100000;
			descMillaje = descMillaje * 2;
			double precio = this.costoInicial - this.descuento();
			descMillaje = precio * descMillaje;
			this.pasajero.setMillas(0);
		}
		else if (millas > 50000) {
			descMillaje = this.costoInicial - this.descuento();
			float diferencia = millas - 50000;
			this.pasajero.setMillas(diferencia);
		}
		else {
			this.canjeaMillas = false;
			descMillaje = 0;
		}
		
		return Math.round(descMillaje*10.0)/10.0;
	}
	
	public double costoInicial() {
		double costo = this.vuelo.distancia(this.vuelo.getLugarPartida(), this.vuelo.getDestino()) * 0.24;
		if (this.pasajero.getClase().equals("Primera Clase")) {
			double incremento = costo * 0.15;
			costo = costo + incremento;
		}
		this.costoInicial = Math.round(costo*10.0)/10.0;
		return Math.round(costo*10.0)/10.0;
	}
	
	public double calcularCostos() {
		double total = 0;
		if (this.canjeaMillas) {
			total = this.costoInicial() + this.multaEquipaje() - this.descuento() - this.canjearMillas();
			this.total = Math.round(total*10.0)/10.0;
		}
		else {
			total = this.costoInicial() + this.multaEquipaje() - this.descuento();
			this.total = Math.round(total*10.0)/10.0;
		}
		return Math.round(total*10.0)/10.0;
	}
	public String toString() {
		if(this.multas) {
			return "*******************************************************"+"\n"+
					"FACTURACIÓN DEL PASAJERO: "+this.pasajero.getNombre()+"\n"+
					"COSTO DEL VUELO: "+this.costoInicial+" USD"+"\n"+
					"DESCUENTOS: "+this.descuento+" USD"+"\n"+
					"****** EL PASAJERO PRESENTA MULTAS ******"+"\n"+
					"MULTA POR EQUIPAJE: "+this.multaEquipaje()+" USD"+"\n"+"\n"+
					"TOTAL A COBRAR: "+this.total+" USD"+"\n"+
					"*******************************************************";
		}
		else {
			return "*******************************************************"+"\n"+
					"FACTURACIÓN DEL PASAJERO: "+this.pasajero.getNombre()+"\n"+
					"COSTO DEL VUELO: "+this.costoInicial+" USD"+"\n"+
					"DESCUENTOS: "+this.descuento+" USD"+"\n"+
					"****** EL PASAJERO NO PRESENTA MULTAS ******"+"\n"+"\n"+
					"TOTAL A COBRAR: "+this.total+" USD"+"\n"+
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

	public boolean isCanjeaMillas() {
		return canjeaMillas;
	}
	public void setCanjeaMillas(boolean canjeaMillas) {
		this.canjeaMillas = canjeaMillas;
	}
	
	
	
}
