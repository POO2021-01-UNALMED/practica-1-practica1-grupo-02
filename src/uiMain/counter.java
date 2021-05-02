package uiMain;

import java.util.Scanner;
import java.util.Vector;

import gestion.*;
import paquete1.*;

public class counter {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		// ==== FLOTA DE LA COMPAÑÍA ===
		Avion avionUno = new Avion("HK-2687", "Airbus A320neo", 153, 8, 41000);
		Avion avionDos = new Avion("HK-7862", "Airbus A320neo", 153, 8, 41000);
		Avion avionTres = new Avion("HK-6546", "Airbus A320neo", 153, 8, 41000);

		// ==== DESTINO DE LA COMPAÑÍA ====
		Aeropuerto medellin = new Aeropuerto("MDE", "Aeropuerto Internacional José María Córdova", "Medellín",
				"Colombia", 2142, 6.167222F, -75.426667F);
		Aeropuerto bogota = new Aeropuerto("BOG", "Aeropuerto Internacional Eldorado", "Bogotá", "Colombia", 2648,
				4.701389F, -74.146944F);
		Aeropuerto cali = new Aeropuerto("CLO", "Aeropuerto Internacional Alfonso Bonilla Aragón", "Cali", "Colombia",
				962, 3.543056F, -76.381389F);
		Aeropuerto sanAndres = new Aeropuerto("ADZ", "Aeropuerto Internacional Gustavo Rojas Pinilla", "San Andrés",
				"Colombia", 6, 12.583611F, -81.711111F);
		Aeropuerto miami = new Aeropuerto("MIA", "Aeropuerto Internacional de Miami", "Miami", "Estados Unidos", 2,
				25.793333F, -80.290556F);
		Aeropuerto ciudadPanama = new Aeropuerto("PTY", "Aeropuerto Internacional de Tocumen", "Ciudad de Panamá",
				"Panamá", 41, 9.071389F, -79.383611F);

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
				flota();
				break;
			case 6:
				empleados();
				break;
			case 7:
				cambioEstadoAvion();
				break;
			case 8:
				cambioEstadoAeropuerto();
				break;

			}
		} while (opcion != 9);

	}
	
	
	// ====================================================================================================
	// 1. Registrar un nuevo vuelo.
	static void nuevoVuelo() {
		// Entrada de parámetros
		System.out.println("\n¿Cuál es el código IATA del aeropuerto de origen?");
		String aeropuertoOrigen = entradaTxt();
		// Búsqueda del aeropuerto de origen
		Aeropuerto aeroOrigen = Aeropuerto.buscarAeropuerto(aeropuertoOrigen);
		if (aeroOrigen == null) {
			System.out.println("Debe ingresar un código válido:\n" + "BOG, CLO, MDE, MIA, PTY o ADZ");
			return;
		}

		System.out.println("¿Cuál es el código IATA del aeropuerto de destino?");
		String aeropuertoDestino = entradaTxt();
		// Búsqueda del aeropuerto de destino
		Aeropuerto aeroDestino = Aeropuerto.buscarAeropuerto(aeropuertoDestino);
		if (aeroDestino == null) {
			System.out.println("Debe ingresar un código válido:\n" + "BOG, CLO, MDE, MIA, PTY o ADZ.\n"
					+ "Considere que debe ser diferente al anterior.");
			System.out.println("el aeroDest es nulo");
			return;
		}

		System.out.println("¿Cuál es el código del vuelo?");
		String codigoVuelo = entradaTxt();

		System.out.println("¿Cuándo sale el vuelo?");
		String fechaVuelo = entradaTxt();

		System.out.println("¿Cuál es la matrícula del avión a utilizar?");
		String avionVuelo = entradaTxt();
		// Búsqueda del avión
		Avion avion = Avion.buscarAvion(avionVuelo);
		if (avion == null) {
			System.out.println("Debe ingresar una matrícula válida:\n" + "HK-2687, HK-7862 o HK-6546\n"
					+ "Considere que debe ser diferente al anterior.");
			return;
		}

		// Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, aeroOrigen, aeroDestino,
		// fechaVuelo, avion);
		Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, aeroOrigen, aeroDestino, fechaVuelo, avion);
		Vuelo.getVuelos().add(vuelo);
		System.out.println("¡Muy bien! Se ha registro el vuelo " + codigoVuelo + " que parte de "
				+ aeroOrigen.getCiudad() + "\ncon destino a " + aeroDestino.getCiudad() + ", con fecha "
				+ vuelo.getFecha() + "\ny que será operado por POO Airways en el avión con matrícula "
				+ avion.getMatricula());
		System.out.println("El costo de gasolina es de: " +  vuelo.getCostoGasolina() + ", con una distancia de: " + vuelo.getDistancia());
		System.out.println("\n");
	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 2. Registrar un nuevo empleado
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
		System.out.println("¡Muy bien!\n" + "Se ha creado el empleado con nombre " + empleado.getNombre()
				+ " y pasaporte " + empleado.getPasaporte() + ",\n" + "siendo su cargo el de " + empleado.getCargo()
				+ " y con horario " + empleado.getHorarioTrabajo() + ".");
		System.out.println("\n");

	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 3. Check-in de pasajero
	static void checkIn() {
		// Ingreso de la información necesaria
		// TODO Lista de pasajeros como atributo de Pasajero para poder ir registrando a los pasajeros de la aerolínea
		// y poder darles millas si vuelvan nuevamente con la aerolínea.
		System.out.println("\n¿Cuál es el nombre completo del pasajero?");
		String nombre = entradaTxt();
		System.out.println("Ingrese el número del pasaporte (5 dígitos).");
		String num = entradaTxt();
		while (num.length() != 5 || Pasajero.encontrarPasajero(num) != null) {
			System.out.println("El número ingresado no es válido o ya se encuentra registrado.");
			num = entradaTxt();
		}
		String pasaporte = num;
		System.out.println("¿En qué vuelo va a viajar el pasajero? Ingrese el código del vuelo");
		String codigo = entradaTxt();
		Vuelo vuelo;
		while (Vuelo.getVuelo(codigo) == null) {
			System.out.println("Por favor, ingrese un código válido de vuelo");
			codigo = entradaTxt();
		}
		vuelo = Vuelo.getVuelo(codigo);
		System.out.println("¿Cuál es la fecha de nacimiento del pasajero? DD/MM/YYYY");
		String cumpleanos = entradaTxt();
		System.out.println("¿En qué clase vuelva el pasajero? Teclee la opcion adecuada.");
		String clase;
		System.out.println("\n 1. Primera Clase.");
		System.out.println(" 2. Clase Económica/Turista.");
		int opcion = (int) entradaLong();
		// Registro de la clase según la opción que corresponda
		while (opcion != 1 && opcion != 2) {
			System.out.println("Ingrese sólo 1 ó 2");
			opcion = (int) entradaLong();
		}
		if (opcion == 1) {
			clase = "Primera Clase";
		}
		else {
			clase = "Clase Turista";
		}
		// Se crea un pasajero con la información que se lleva hasta el momento
		Pasajero pasAux = Pasajero.nuevoPasajero(nombre, pasaporte, vuelo, cumpleanos, clase, false);
		System.out.println("¿Cuántas maletas lleva el pasajero para guardar en bodega?");
		int numeroMaletasB = (int) entradaLong();
		int i = 0;
		while (i < numeroMaletasB) {
			System.out.println("Ingrese el peso de la maleta número "+i+" (En kg y números enteros)."+"\n"+
								"Nota: El peso máximo es de 25 kg para Primera Clase y de 20 kg para la Clase Turista "+"\n"+
								"Se le cobrará multa por cada kg adicional.");
			int pesoB = (int) entradaLong();
			new Equipaje(pasAux, "Bodega", pesoB);
			i++;
		}
		System.out.println("¿Cuántas maletas de mano lleva?");
		int numeroMaletasM = (int) entradaLong();
		while (i < numeroMaletasM) {
			System.out.println("Ingrese el peso de la maleta número "+i+" (En kg y números enteros)."+"\n"+
								"Nota: El peso máximo es de 25 kg para Primera Clase y de 20 kg para la Clase Turista "+"\n"+
								"	   Se le cobrará multa por cada kg adicional.");
			int pesoM = (int) entradaLong();
			new Equipaje(pasAux, "Mano", pesoM);
			i++;
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
	// ====================================================================================================
	
	// ====================================================================================================
	// 4. Mostrar los vuelos programados.
	static void vuelosProgramados() {
		System.out.println("Los vuelos programados en este momento son: ");
		for (int i = 0; i < Vuelo.getVuelos().size(); i++) {
			System.out.println(Vuelo.getVuelos().get(i).toString());
		}
		System.out.println("\n");
;	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 5. Mostrar la flota de POO Airways.
	static void flota() {
		System.out.println("\n" + "La flota de POO Airways está conformada por: ");
		for (int i = 0; i < Avion.getAviones().size(); i++) {
			System.out.println(Avion.getAviones().get(i).toString());
		}
		System.out.println("\n");
	}
	
	// ====================================================================================================
	
	// ====================================================================================================
	// 6. Mostrar la flota de POO Airways.
	static void empleados() {
		System.out.println("\n" + "Los empleados de POO Airways son: ");
		for (int i = 0; i < Empleado.getEmpleados().size(); i++) {
			System.out.println(Empleado.getEmpleados().get(i).toString());
			}
		System.out.println("\n");
		}
		
	// ====================================================================================================
	
	// ====================================================================================================
	// 7. Cambio de estado de un avión.
	static void cambioEstadoAvion() {
		System.out.println("¿Al avión con qué matricula le desea cambiar el estado?");
		System.out.println("1. HK-2687" + "\n2. HK-7862" + "\n3. HK-6546");
		Avion avion = null;
		int opcion = (int) entradaLong();
		switch (opcion) {
		case 1: avion = Avion.getAviones().get(0);
		case 2: avion = Avion.getAviones().get(1);
		case 3: avion = Avion.getAviones().get(2);
		}
		System.out.println("¿Cómo quiere situar la disponibilidad del avión?");
		System.out.println(" 1. Disponible" + "\n 2. No disponible");
		int opcion2 = (int) entradaLong();
		switch (opcion2 ) {
		case 1: avion.setDisponibilidad(true);
		case 2: 
			avion.setDisponibilidad(false);
			for(int i = 0; i < avion.getVuelos().size(); i++) {
				System.out.println("Canges por cancelación para los pasajeros del vuelo " + avion.getVuelos().get(i).getCodigo());
				avion.getVuelos().get(i).disponibilidad();
			}
		}
		System.out.println("\n");
		
		
	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 8. Cambiar el estado de un aeropuerto
	static void cambioEstadoAeropuerto() {
		System.out.println("¿Cuál es el código IATA del aeropuerto al cual le desea cambiar la disponibilidad?");
		System.out.println(" 1. MDE\n 2. BOG\n 3. CLO\n 4. ADZ\n 5. MIA\n 6. PTY");
		Aeropuerto aeropuerto = null;
		int opcion = (int) entradaLong();
		switch(opcion) {
		case 1: aeropuerto = Aeropuerto.getAeropuertos().get(0);
		case 2: aeropuerto = Aeropuerto.getAeropuertos().get(1);
		case 3: aeropuerto = Aeropuerto.getAeropuertos().get(2);
		case 4: aeropuerto = Aeropuerto.getAeropuertos().get(3);
		case 5: aeropuerto = Aeropuerto.getAeropuertos().get(4);
		case 6: aeropuerto = Aeropuerto.getAeropuertos().get(5);
		}
		System.out.println("¿Cómo quiere situar la disponibilidad del aeropuerto de " + aeropuerto.getCiudad() + "?");
		System.out.println(" 1. Disponible" + "\n 2. No disponible");
		int opcion2 = (int) entradaLong();
		switch (opcion2 ) {
		case 1: aeropuerto.setEstado(true);
		case 2: 
			aeropuerto.setEstado(false);
			for(int i = 0; i < aeropuerto.getVuelos().size(); i++) {
				System.out.println("Canges por cancelación para los pasajeros del vuelo " + aeropuerto.getVuelos().get(i).getCodigo());
				aeropuerto.getVuelos().get(i).disponibilidad();
			}
		}
		
	}
	
	// ====================================================================================================
	
	// ====================================================================================================
	static String entradaTxt() {
		return entrada.nextLine();
	}

	static long entradaLong() {
		return entrada.nextLong();
	}

}
