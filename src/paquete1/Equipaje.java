package paquete1;

public class Equipaje {
	private Pasajero pasajero;
	private int masa;
	private boolean permitido;
	
	public Equipaje() {
		this.pasajero = null;
		this.masa = 0;
		this.permitido = true;
	}
	
	public Equipaje(Pasajero pasajero, int masa, boolean permitido) {
		this.pasajero = pasajero;
		this.masa = masa;
		this.permitido = permitido;
	}
	
	// Métodos
}
