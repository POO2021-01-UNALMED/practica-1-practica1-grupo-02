package gestion;

import java.io.Serializable;
import java.util.*;

import baseDatos.Serializador;

 public class Aeropuerto implements Serializable {
	 
	// ================================================================================
	// ATRIBUTOS
	private String codigo;
	private String nombre;
	private String ciudad;
	private String pais;
	private int altura;
	private boolean estado; // true := disponible; false := no disponible
	private float lat;
	private float lon;
	ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	public static Vector<Aeropuerto> aeropuertos = new Vector<Aeropuerto>();
	
	
	
	// ================================================================================
	// CONSTRUCTOR
	public Aeropuerto(String codigo, String nombre, String ciudad, String pais, int altura, float lat, float lon) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.altura = altura;
		this.lat = lat;
		this.lon = lon;
		this.estado = true;
		Aeropuerto.aeropuertos.add(this);
	}

	
	// ================================================================================
	// GETTERS Y SETTERS
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
	public static Vector<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public static void setAeropuertos(Vector<Aeropuerto> aeropuertos) {
		Aeropuerto.aeropuertos = aeropuertos;
	}
	
	
	// ================================================================================
	// METODOS AUXILIARES
	static public Aeropuerto buscarAeropuerto(String codigo) {
		Iterator<Aeropuerto> iteradorAeropuerto = aeropuertos.iterator();
		while(iteradorAeropuerto.hasNext()) {
			Aeropuerto aeropuerto = (Aeropuerto) iteradorAeropuerto.next();
			if (aeropuerto.codigo.equals(codigo)) {
				return aeropuerto;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "El Aeropuerto con código " + codigo + ", llamado " + nombre + ", ubicado en el país " + pais + " en la ciudad " + ciudad  
				+ ". ubicado a un altura de " + altura + " latitud de " + lat + " y longitud de " + lon + ", con un estado " + estado 
				;
	}
	
}