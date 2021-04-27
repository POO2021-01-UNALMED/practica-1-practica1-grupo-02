package counter;

import java.util.Scanner;
import java.util.Vector;

import gestion.Aeropuerto;
import gestion.Avion;
import gestion.Vuelo;
import paquete1.Empleado;

public class counter {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		// ==== FLOTA DE LA COMPA��A ===
		Avion avionUno = new Avion("HK-2687", "Airbus A320neo", 153, 8, 41000);
		Avion avionDos = new Avion("HK-7862", "Airbus A320neo", 153, 8, 41000);
		Avion avionTres = new Avion("HK-6546", "Airbus A320neo", 153, 8, 41000);

		// ==== DESTINO DE LA COMPA��A ====
		Aeropuerto medellin = new Aeropuerto("MDE", "Aeropuerto Internacional Jos� Mar�a C�rdova", "Medell�n",
				"Colombia", 2142, 6.167222F, -75.426667F);
		Aeropuerto bogota = new Aeropuerto("BOG", "Aeropuerto Internacional Eldorado", "Bogot�", "Colombia", 2648,
				4.701389F, -74.146944F);
		Aeropuerto cali = new Aeropuerto("CLO", "Aeropuerto Internacional Alfonso Bonilla Arag�n", "Cali", "Colombia",
				962, 3.543056F, -76.381389F);
		Aeropuerto sanAndres = new Aeropuerto("ADZ", "Aeropuerto Internacional Gustavo Rojas Pinilla", "San Andr�s",
				"Colombia", 6, 12.583611F, -81.711111F);
		Aeropuerto miami = new Aeropuerto("MIA", "Aeropuerto Internacional de Miami", "Miami", "Estados Unidos", 2,
				25.793333F, -80.290556F);
		Aeropuerto ciudadPanama = new Aeropuerto("PTY", "Aeropuerto Internacional de Tocumen", "Ciudad de Panam�",
				"Panam�", 41, 9.071389F, -79.383611F);

		Scanner entrada = new Scanner(System.in);
		// !!!!!!!! Agregar constructor con el nombre del archivo aqu� !!!!!!!!!!!
		// TODO Agregar el constructor con la serializaci�n del documento
		int opcion;
		do {
			System.out.println("�Bievenido a POO Airways!");
			System.out.println("�Qu� desea hacer?");
			System.out.println("1. Registrar un nuevo vuelo.");
			System.out.println("2. Registrar un empleado.");
			System.out.println("3. Check-in de pasajero.");
			System.out.println("4. Mostrar los vuelos programados.");
			System.out.println("5. Mostrar la flota de POO Airways.");
			System.out.println("6. Mostrar los empleados de la compa��a.");
			System.out.println("7. Cambiar el estado de un avi�n.");
			System.out.println("8. Cambiar el estado de un aeropuerto.");
			System.out.println("9. Terminar.");
			System.out.println("Teclee el n�mero de la opci�n que desea ejecutar");

			opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				nuevoVuelo();
				break;
			case 2:
				nuevoEmpleado();
				break;
			case 3:
				checkIn();
				break;
			case 4:
				vuelosProgramados();
				break;
			case 5:
				System.out.println("Hola");
				break;
			case 6:
				System.out.println("Hola");
				break;
			case 7:
				System.out.println("Hola");
				break;
			case 8:
				System.out.println("Hola");
				break;

			}
		} while (opcion != 9);

	}
	
	
	// ====================================================================================================
	// 1. Registrar un nuevo vuelo.
	static void nuevoVuelo() {
		// Entrada de par�metros
		System.out.println("\n�Cu�l es el c�digo IATA del aeropuerto de origen?");
		String aeropuertoOrigen = entradaTxt();
		// B�squeda del aeropuerto de origen
		Aeropuerto aeroOrigen = Aeropuerto.buscarAeropuerto(aeropuertoOrigen);
		if (aeroOrigen == null) {
			System.out.println("Debe ingresar un c�digo v�lido:\n" + "BOG, CLO, MDE, MIA, PTY o ADZ");
			return;
		}

		System.out.println("�Cu�l es el c�digo IATA del aeropuerto de destino?");
		String aeropuertoDestino = entradaTxt();
		// B�squeda del aeropuerto de destino
		Aeropuerto aeroDestino = Aeropuerto.buscarAeropuerto(aeropuertoDestino);
		if (aeroDestino == null) {
			System.out.println("Debe ingresar un c�digo v�lido:\n" + "BOG, CLO, MDE, MIA, PTY o ADZ.\n"
					+ "Considere que debe ser diferente al anterior.");
			System.out.println("el aeroDest es nulo");
			return;
		}

		System.out.println("�Cu�l es el c�digo del vuelo?");
		String codigoVuelo = entradaTxt();

		System.out.println("�Cu�ndo sale el vuelo?");
		String fechaVuelo = entradaTxt();

		System.out.println("�Cu�l es la matr�cula del avi�n a utilizar?");
		String avionVuelo = entradaTxt();
		// B�squeda del avi�n
		Avion avion = Avion.buscarAvion(avionVuelo);
		if (avion == null) {
			System.out.println("Debe ingresar una matr�cula v�lida:\n" + "HK-2687, HK-7862 o HK-6546\n"
					+ "Considere que debe ser diferente al anterior.");
			return;
		}

		// Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, aeroOrigen, aeroDestino,
		// fechaVuelo, avion);
		Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, Aeropuerto.aeropuertos.get(0), Aeropuerto.aeropuertos.get(1),
				fechaVuelo, Avion.aviones.get(1));
		System.out.println("�Muy bien! Se ha registro el vuelo " + codigoVuelo + " que parte de "
				+ aeroOrigen.getCiudad() + "\ncon destino a " + aeroDestino.getCiudad() + ", con fecha "
				+ vuelo.getFecha() + "\ny que ser� operado por POO Airways en el avi�n con matr�cula "
				+ avion.getMatricula() + "\n");
		System.out.println("El costo de gasolina es de: " +  vuelo.getCostoGasolina() + ", con una distancia de: " + vuelo.getDistancia());
		System.out.println("\n");
	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 2. Registrar un nuevo empleado
	static void nuevoEmpleado() {
		// Ingreso de la informaci�n necesaria
		System.out.println("\n�Cu�l es el nombre completo del empleado");
		String nombre = entradaTxt();
		System.out.println("�Cu�l es el pasaporte del empleado?");
		String pasaporte = entradaTxt();
		System.out.println("�Cu�l es el cargo del empleado?");
		String cargo = entradaTxt();
		System.out.println("�Cu�l es el horario del empleado?");
		String horario = entradaTxt();

		// Creaci�n de un nuevo empleado
		Empleado empleado = Empleado.nuevoEmpleado(nombre, pasaporte, cargo, horario);
		System.out.println("�Muy bien!\n" + "Se ha creado el empleado con nombre " + empleado.getNombre()
				+ " y pasaporte " + empleado.getPasaporte() + ",\n" + "siendo su cargo el de " + empleado.getCargo()
				+ " y con horario " + empleado.getHorarioTrabajo() + ".");
		System.out.println("\n");

	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 3. Check-in de pasajero
	static void checkIn() { /// TERMINAR
		// Ingreso de la informaci�n necesaria
		System.out.println("\n�Cu�l es el nombre completo del pasajero?");
		String nombre = entradaTxt();
		System.out.println("�Cu�l es el pasaporte del pasajero?");
		String pasaporte = entradaTxt();
		System.out.println("�En qu� vuelo va a viajar el pasajero?");
		String vuelo = entradaTxt();
		System.out.println("�Cu�l es la fecha de nacimiento del pasajero? DD/MM/YYYY");
		String cumpleanos = entradaTxt();
		System.out.println("�Cu�ntas maletas lleva el pasajero para guardar en bodega?");
		int numeroMaletas = (int) entradaLong();
		System.out.println("�En qu� clase vuelva el pasajero? Teclee la opcion adecuada.");
		String clase;
		System.out.println("\n1. Primera clase.");
		System.out.println("2. Clase econ�mica/turista.");
		int opcion = (int) entradaLong();
		// Registro de la clase seg�n la opci�n que corresponda
		switch (opcion) {
		case 1:
			clase = "A";
		case 2:
			clase = "B";
		}
		System.out.println("�El pasajero es miembro del programa de viajero frecuente?");
		String frecuente = entradaTxt();

		boolean viajeroFrec = false;

		// Viajero frecuente
		if (frecuente.contains("s")) {
			viajeroFrec = true;
		}

		// Creaci�n de maletas
	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 4. Mostrar los vuelos programados.
	static void vuelosProgramados() {
		Vector<Vuelo> programacion = Vuelo.getVuelos();
		for (Vuelo vuelo : programacion) {
			System.out.println("El vuelo " + vuelo.getCodigo() + " de POO Airways sale del aeropuerto " +  vuelo.getLugarPartida().getCodigo() + " de la ciudad de " +
					vuelo.getLugarPartida().getCiudad() + "\n el d�a " +  vuelo.getFecha() + " con destino al aeropuerto de " + vuelo.getDestino().getCodigo() + 
					" de la ciudad de " + vuelo.getDestino().getCiudad() + ".\nDe momento este vuelo tiene " + vuelo.getPasajeros().size() + "y se estima que" +
					" su costo de gasolina equivale a unos $" + vuelo.getCostoGasolina() + ".");
		}
		System.out.println("\n");
	}
	
	// ====================================================================================================
	static String entradaTxt() {
		return entrada.nextLine();
	}

	static long entradaLong() {
		return entrada.nextLong();
	}

}