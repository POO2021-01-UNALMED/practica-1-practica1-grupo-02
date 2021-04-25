package paquete1;

public class Persona {

	private String nombre;
	private String pasaporte;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	
	// =========================================================================================
	// Constructor
	public Persona(String nombre, String pasaporte) {
		super();
		this.nombre = nombre;
		this.pasaporte = pasaporte;
	}
	
	
}
