package paquete1;

import gestion.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Facturacion {
	private double total = 0;
	private double descuento = 0;
	private double costoInicial = 0;
	private Pasajero pasajero;
	private Vuelo vuelo;
	private Equipaje equipaje;
	
	static Scanner entrada = new Scanner(System.in);
	
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
		this.costoInicial = this.costoInicial();
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
	
	public double costoInicial() {
		double costo = this.vuelo.distancia() * 0.24;
		return costo;
	}
	// multaCancelacion()
	// calcularCostos()
	// toString()
	
	// *************************************************************************************************
	// Getters and Setters
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
	
	public static void main(String[] args) {
		
		// ==== FLOTA DE LA COMPAÑÍA ===
		Avion avionUno = new Avion("HK-2687", "Airbus A320neo", 153, 8, 120000);
		Avion avionDos = new Avion("HK-7862", "Airbus A320neo", 153, 8, 120000);
		Avion avionTres = new Avion("HK-6546", "Airbus A320neo", 153, 8, 120000);
		
		// ==== DESTINO DE LA COMPAÑÍA ====
		Aeropuerto medellin = new Aeropuerto("MDE", "Aeropuerto Internacional José María Córdova",
				"Medellín", "Colombia", 2142, 6.167222F, -75.426667F);
		Aeropuerto bogota = new Aeropuerto("BOG", "Aeropuerto Internacional Eldorado", "Bogotá",
				"Colombia", 2648, 4.701389F, -74.146944F);
		Aeropuerto cali = new Aeropuerto("CLO", "Aeropuerto Internacional Alfonso Bonilla Aragón",
				"Cali", "Colombia", 962, 3.543056F, -76.381389F);
		Aeropuerto sanAndres = new Aeropuerto("ADZ", "Aeropuerto Internacional Gustavo Rojas Pinilla",
				"San Andrés", "Colombia", 6, 12.583611F, -81.711111F);
		Aeropuerto miami = new Aeropuerto("MIA", "Aeropuerto Internacional de Miami", "Miami",
				"Estados Unidos", 2, 25.793333F, -80.290556F);
		Aeropuerto ciudadPanama = new Aeropuerto("PTY", "Aeropuerto Internacional de Tocumen",
				"Ciudad de Panamá", "Panamá", 41, 9.071389F, -79.383611F);
		
		Scanner entrada = new Scanner(System.in);
		// !!!!!!!! Agregar constructor con el nombre del archivo aquí !!!!!!!!!!!
			// TODO Agregar el constructor con la serialización del documento
		int opcion;
		do {
			System.out.println("¡Bievenido a POO Airways!");
			System.out.println("¿Qué desea hacer?");
			System.out.println("1. Registrar un nuevo vuelo.");
			System.out.println("2. Registrar un empleado.");
			System.out.println("3. Check-in de pasajero.");
			System.out.println("4. Mostrar los vuelos programados.");
			System.out.println("5. Mostrar la flota de POO Airways.");
			System.out.println("6. Mostrar los empleados de la compañía.");
			System.out.println("7. Cambiar el estado de un avión.");
			System.out.println("8. Cambiar el estado de un aeropuerto.");
			System.out.println("9. Terminar.");
			System.out.println("Teclee el número de la opción que desea ejecutar");
			
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1 : nuevoVuelo();
				break;
			case 2 : nuevoEmpleado();
				break;
			case 3 : checkIn();
				break;
			case 4 : System.out.println("Hola");
				break;
			case 5 : System.out.println("Hola");
			break;
			case 6 : System.out.println("Hola");
				break;
			case 7 : System.out.println("Hola");
				break;
			case 8 : System.out.println("Hola");
			break;
			
			}
		}
			while (opcion != 9);
		
	}
	
	static void nuevoVuelo() {
		// Entrada de parámetros
		System.out.println("\n¿Cuál es el código IATA del aeropuerto de origen?");
		String aeropuertoOrigen = entradaTxt();
		System.out.println("¿Cuál es el código IATA del aeropuerto de destino?");
		String aeropuertoDestino = entradaTxt();
		System.out.println("¿Cuál es el código del vuelo?");
		String codigoVuelo = entradaTxt();
		System.out.println("¿Cuándo sale el vuelo?");
		String fechaVuelo = entradaTxt();
		System.out.println("¿Cuál es la matrícula del avión a utilizar?");
		String avionVuelo = entradaTxt();
		
		// Búsqueda del aeropuerto de origen
		Aeropuerto aeroOrigen = Aeropuerto.buscarAeropuerto(aeropuertoOrigen);
		if (aeroOrigen == null) {
			System.out.println("Debe ingresar un código válido:\n" +
								"BOG, CLO, MDE, MIA, PTY o ADZ");
			return;
		}
		
		// Búsqueda del aeropuerto de partida
		Aeropuerto aeroDestino = Aeropuerto.buscarAeropuerto(aeropuertoDestino);
		if (aeroDestino == null) {
			System.out.println("YYYYDebe ingresar un código válido:\n" +
								"BOG, CLO, MDE, MIA, PTY o ADZ.\n" +
								"Considere que debe ser diferente al anterior.");
			System.out.println("el aeroDest es nulo");
			return;
		}
		
		// Búsqueda del avión
		Avion avion = Avion.buscarAvion(avionVuelo);
		if (avion == null) {
			System.out.println("Debe ingresar una matrícula válida:\n" +
								"HK-2687, HK-7862 o HK-6546\n" +
								"Considere que debe ser diferente al anterior.");
			return;
		}
		
		//Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, aeroOrigen, aeroDestino, fechaVuelo, avion);
		Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, Aeropuerto.aeropuertos.get(0), Aeropuerto.aeropuertos.get(1), fechaVuelo, Avion.aviones.get(1));
		System.out.println("¡Muy bien! Se ha registro el vuelo " + codigoVuelo + " que parte de " +
							aeroOrigen.getCiudad() + "\ncon destino a " + aeroDestino.getCiudad() + ", con fecha " + 
							vuelo.getFecha() + "\ny que será operado por POO Airways en el avión con matrícula " + avion.getMatricula() + "\n");
		
		System.out.println("OK!");
	}
	
	static void nuevoEmpleado() {
		// Ingreso de la información necesaria
		System.out.println("\n¿Cuál es el nombre completo del empleado");
		String nombre = entradaTxt();
		System.out.println("¿Cuál es el pasaporte del empleado?");
		String pasaporte = entradaTxt();
		System.out.println("¿Cuál es el cargo del empleado?");
		String cargo = entradaTxt();
		System.out.println("¿Cuál es el horario del empleado?");
		String horario = entradaTxt();
		
		// Creación de un nuevo empleado
		Empleado empleado = Empleado.nuevoEmpleado(nombre, pasaporte, cargo, horario);
		System.out.println("¡Muy bien!\n" +  "Se ha creado el empleado con nombre " + empleado.getNombre() + " y pasaporte "
							+ empleado.getPasaporte() + ",\n" + "siendo su cargo el de " + empleado.getCargo() + " y con horario " +
							empleado.getHorarioTrabajo() + ".");
		
	}
	
	static void checkIn() { /// TERMINAR
		// Ingreso de la información necesaria
		System.out.println("\n¿Cuál es el nombre completo del pasajero?");
		String nombre = entradaTxt();
		System.out.println("¿Cuál es el pasaporte del pasajero?");
		String pasaporte = entradaTxt();
		System.out.println("¿En qué vuelo va a viajar el pasajero?");
		String vuelo = entradaTxt();
		System.out.println("¿Cuál es la fecha de nacimiento del pasajero? DD/MM/YYYY");
		String cumpleanos = entradaTxt();
		System.out.println("¿Cuántas maletas lleva el pasajero para guardar en bodega?");
		int numeroMaletas = (int) entradaLong();
		System.out.println("¿En qué clase vuelva el pasajero? Teclee la opcion adecuada.");
		String clase;
		System.out.println("\n1. Primera clase.");
		System.out.println("2. Clase económica/turista.");
		int opcion = (int) entradaLong();
			// Registro de la clase según la opción que corresponda
			switch(opcion) {
			case 1 : clase = "A";
			case 2 : clase = "B";
			}
		System.out.println("¿El pasajero es miembro del programa de viajero frecuente?");
		String frecuente = entradaTxt();
		
		boolean viajeroFrec = false;
		
		// Viajero frecuente
		if (frecuente.contains("s")) {
			viajeroFrec = true;
		}
		
		// Creación de maletas
	}
	
	static String entradaTxt() {
		return entrada.nextLine();
	}
	
	static long entradaLong() {
		return entrada.nextLong();
	}
	
}
