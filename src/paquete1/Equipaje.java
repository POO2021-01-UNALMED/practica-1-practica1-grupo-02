package paquete1;

public class Equipaje {
	private Pasajero pasajero;
	private String tipo;
	private int masa;
	private boolean permitido;
	
	// *************************************************************************************************
	// Constructores
	// *************************************************************************************************
	
	public Equipaje() {
		this.pasajero = null;
		this.tipo = " ";
		this.masa = 0;
		this.permitido = false;
	}
	
	public Equipaje(Pasajero pasajero, String tipo, int masa) {
		this.pasajero = pasajero;
		this.tipo = tipo;
		this.masa = masa;
		this.permitido = this.checkear();
		if (this.permitido) {
			this.pasajero.nuevoEquipaje(this);
		}
		this.soprepeso();
	}
	
	// *************************************************************************************************
	// Métodos
	// *************************************************************************************************
	
	static public Equipaje nuevoEquipaje() {
		return null;
	}
	
	public boolean soprepeso() {
		boolean sobrepeso = false;
		if (this.permitido == true) {
			if(this.tipo.equals("Mano")) {
				if (this.pasajero.getClase().equals("Primera Clase")) {
					if (this.masa > 12) {
						sobrepeso = true;
					}
					else {
						sobrepeso = false;
					}
				}
				else {
					if (this.masa > 10) {
						sobrepeso = true;
					}
					else {
						sobrepeso = false;
					}
				}
			}
			else if (this.tipo.equals("Bodega")) {
				if (this.pasajero.getClase().equals("Primera Clase")) {
					if (this.masa > 25) {
						sobrepeso = true;
					}
					else {
						sobrepeso = false;
					}
				}
				else {
					if (this.masa > 20) {
						sobrepeso = true;
					}
					else {
						sobrepeso = false;
					}
				}
			}
		}
		return sobrepeso;
	}
	
	public boolean checkear() {
		boolean ok = false;
		if (this.tipo.equals("Mano") || this.tipo.equals("Bodega")) {
			ok = true;
		}
		else {
			ok = false;
		}
		return ok;
	}
	
	public String toString() {
		if (this.permitido) {
			return "Equipaje de "+this.getTipo()+" perteneciente a "+this.getPasajero().getNombre()+"\n"+
					"Peso: "+this.getMasa()+"\n"+"El equipaje ha sido permitido";
		}
		else {
			return "Equipaje de "+this.getTipo()+" perteneciente a "+this.getPasajero().getNombre()+"\n"+
					"Peso: "+this.getMasa()+"\n"+"El equipaje ha sido denegado";
		}
	}
	
	// *************************************************************************************************
	// Getters & Setters
	// *************************************************************************************************

	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public int getMasa() {
		return masa;
	}
	public void setMasa(int masa) {
		this.masa = masa;
	}

	public boolean isPermitido() {
		return permitido;
	}
	public void setPermitido(boolean permitido) {
		this.permitido = permitido;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
