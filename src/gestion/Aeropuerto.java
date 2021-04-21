package gestion;

import java.util.*;

public class Aeropuerto {
	private String codigo;
	private String nombre;
	private String ciudad;
	private  String pais;
	private int altura;
	private boolean estado;
	private float lat;
	private float lon;
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	
	// constructor
	
	public Aeropuerto(String codigo, String nombre, String ciudad, String pais, int altura, boolean estado, float lat,
			float lon, ArrayList<Vuelo> vuelos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.altura = altura;
		this.estado = estado;
		this.lat = lat;
		this.lon = lon;
		this.vuelos = vuelos;
	}

	// Getters and setters  
	
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
	
	// Metodos
	
	
	
}