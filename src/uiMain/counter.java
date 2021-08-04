package uiMain;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import baseDatos.Deserializador;
import baseDatos.Serializador;
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
		Aeropuerto sidney = new Aeropuerto("SYD", "Aeropuerto Internacional Kingsford Smith", "Sídney",
				"Australia", 9, -33.9460983F, 151.177002F);
		Aeropuerto losAngeles = new Aeropuerto("LAX", "Aeropuerto Internacional de Los Ángeles", "Los Ángeles",
				"Estados Unidos", 93, 34.0194F, -118.411F);
		Aeropuerto newYork = new Aeropuerto("JFK", "Aeropuerto Internacional John F. Kennedy", "Nueva York",
				"Estados Unidos", 10, 40.63333F, -73.783333F);
		
		// ==== VUELOS POR DEFECTO ====
		
		Vuelo vuelo1 = new Vuelo("101", medellin, bogota, "06/10/2021", avionUno);
		Vuelo vuelo2 = new Vuelo("102", medellin, cali, "13/09/2021", avionUno);
		Vuelo vuelo3 = new Vuelo("103", medellin, sanAndres, "24/03/2022", avionDos);
		Vuelo vuelo4 = new Vuelo("201", medellin, miami, "24/07/2021", avionDos);
		Vuelo vuelo5 = new Vuelo("301", medellin, sidney, "19/01/2022", avionTres);

		// ==== PASAJEROS POR DEFECTO ====
	
		Pasajero arnulfo = new Pasajero("Arnulfo Rodríguez", "10000", vuelo3, "18/10/1988", "Clase Turista", false);
		Pasajero justin = new Pasajero("Justin del Socorro", "10001", vuelo4, "10/08/1995", "Primera Clase", true);
		
		// ==== EMPLEADOS POR DEFECTO ====
		
		Empleado jefe = new Empleado("Rodolfo Gold", vuelo3 , "12344", "Jefe", "lunes-viernes", true);
		Empleado azafata1 = new Empleado("Rosario Gray", vuelo3 , "12355", "Azafata", "lunes-sabado", true);
		Empleado azafata2 = new Empleado("Mulata Price", vuelo4 , "12366", "Azafata", "lunes-sabado", true);
		
		Scanner entrada = new Scanner(System.in);

		
		
		int opcion;
		do {
			System.out.println("¡Bievenido a POO Airways!");
			System.out.println("¿Qué desea hacer?");
			System.out.println("1. Registrar un nuevo vuelo.");
			System.out.println("2. Registrar un empleado.");
			System.out.println("3. Check-in de un pasajero ya registrado.");
			System.out.println("4. Check-in de un pasajero nuevo.");
			System.out.println("5. Mostrar los vuelos programados.");
			System.out.println("6. Mostrar la flota de POO Airways.");
			System.out.println("7. Mostrar los empleados de la compañía.");
			System.out.println("8. Cambiar el estado de un avión.");
			System.out.println("9. Cambiar el estado de un aeropuerto.");
			System.out.println("10. Serializar y Deserializar");
			System.out.println("0. Terminar.");
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
				checkIn1();
				break;
			case 4:
				checkIn2();
				break;
			case 5:
				vuelosProgramados();
				break;
			case 6:
				flota();
				break;
			case 7:
				empleados();
				break;
			case 8:
				cambioEstadoAvion();
				break;
			case 9:
				cambioEstadoAeropuerto();
				break;
			case 0:
				Serializador.serializarAeropuertos(Aeropuerto.getAeropuertos());
				Serializador.serializarAviones(Avion.getAviones());
				Serializador.serializarVuelo(Vuelo.getVuelos());
				Serializador.serializarEmpleado(Empleado.getEmpleados());
				break;
			case 10:			
				
				SerializaryDeserializar();
				break;
			}
		} while (opcion != 0);

	}
	
	
	// ====================================================================================================
	// 1. Registrar un nuevo vuelo.
	static void nuevoVuelo() {
		// Entrada de parámetros
		System.out.println("\n¿Cuál es el código IATA del aeropuerto de origen?");
		String aeropuertoOrigen = entradaTxt();
		// Búsqueda del aeropuerto de origen
		Aeropuerto aeroOrigen = Aeropuerto.buscarAeropuerto(aeropuertoOrigen);
		while (aeroOrigen == null) {
			System.out.println("Debe ingresar un código válido:\n" + "BOG, CLO, MDE, MIA, LAX, JFK, SYD, PTY o ADZ");
			aeropuertoOrigen = entradaTxt();
			aeroOrigen = Aeropuerto.buscarAeropuerto(aeropuertoOrigen);
		}

		System.out.println("¿Cuál es el código IATA del aeropuerto de destino?");
		String aeropuertoDestino = entradaTxt();
		// Búsqueda del aeropuerto de destino
		Aeropuerto aeroDestino = Aeropuerto.buscarAeropuerto(aeropuertoDestino);
		while (aeroDestino == null || aeroDestino == aeroOrigen) {
			System.out.println("Debe ingresar un código válido:\n" + "BOG, CLO, MDE, MIA, LAX, JFK, SYD, PTY o ADZ.\n"
					+ "Considere que debe ser diferente al anterior.");
			aeropuertoDestino = entradaTxt();
			aeroDestino = Aeropuerto.buscarAeropuerto(aeropuertoDestino);
		}

		System.out.println("¿Cuál es el código del vuelo?");
		String codigoVuelo = entradaTxt();

		System.out.println("¿Cuándo sale el vuelo? DD/MM/YYYY");
		String fechaVuelo = entradaTxt();

		System.out.println("¿Cuál es la matrícula del avión a utilizar?");
		String avionVuelo = entradaTxt();
		// Búsqueda del avión
		Avion avion = Avion.buscarAvion(avionVuelo);
		while (avion == null) {
			System.out.println("Debe ingresar una matrícula válida:\n" + "HK-2687, HK-7862 o HK-6546");
			avionVuelo = entradaTxt();
			avion = Avion.buscarAvion(avionVuelo);
		}

		// Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, aeroOrigen, aeroDestino,
		// fechaVuelo, avion);
		Vuelo vuelo = Vuelo.nuevoVuelo(codigoVuelo, aeroOrigen, aeroDestino, fechaVuelo, avion);
		//Vuelo.getVuelos().add(vuelo);***
		
		System.out.println("¡Muy bien! Se ha registro el vuelo " + codigoVuelo + " que parte de "
				+ aeroOrigen.getCiudad() + "\ncon destino a " + aeroDestino.getCiudad() + ", con fecha "
				+ vuelo.getFecha() + "\ny que será operado por POO Airways en el avión con matrícula "
				+ avion.getMatricula());
		System.out.println("El costo de gasolina es de: " +  vuelo.getCostoGasolina() + " USD, con una distancia de: " + vuelo.getDistancia() + " millas.");
		System.out.println("\n");
	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 2. Registrar un nuevo empleado
	static void nuevoEmpleado() {
		// Ingreso de la información necesaria
		
		System.out.println("\n¿Cuál es el nombre completo del empleado");
		String nombre = entradaTxt();
		System.out.println("¿Cuál es el pasaporte del empleado? (5 dígitos)");
		String pasaporte = entradaTxt();
		
		
		System.out.println(pasaporte.length());
		
		while ( pasaporte.length() != 5 ||Empleado.encontrarEmpleado(pasaporte) != null ) {
			System.out.println("El código del pasaporte ya se encuentra registrado o es invalido");
			pasaporte = entradaTxt();

		}		
		
		
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
	// 3. Check-in de pasajero ya registrado.
	static void checkIn1() {
		System.out.println("Por favor, ingrese el número del pasaporte del pasajero (5 dígitos).");
		String passport = entradaTxt();
		while (passport.length() != 5 || Pasajero.encontrarPasajero(passport) == null) {
			System.out.println("El número ingresado no es válido o no se encuentra registrado.");
			passport = entradaTxt();
		}
		Pasajero registrado = Pasajero.encontrarPasajero(passport);
		System.out.println("El pasajero encontrado es "+registrado.getNombre());
		System.out.println("\nIngrese el código del nuevo vuelo donde se le hará check-in.");
		String codigoo = entradaTxt();
		Vuelo nuevoVuelo;
		while (Vuelo.getVuelo(codigoo) == null) {
			System.out.println("Por favor, ingrese un código válido de vuelo (Ej. 101, 102, 103, 201, 301)");
			codigoo = entradaTxt();
		}
		nuevoVuelo = Vuelo.getVuelo(codigoo);
		registrado.setVuelo(nuevoVuelo);
		System.out.println("¿En qué clase volará el pasajero? Teclee la opcion adecuada.");
		String nuevaClase;
		System.out.println("\n 1. Primera Clase.");
		System.out.println(" 2. Clase Económica/Turista.");
		int opcioon = (int) entradaLong();
		
		// Registro de la clase según la opción que corresponda
		while (opcioon != 1 && opcioon != 2) {
			System.out.println("Ingrese sólo 1 ó 2");
			opcioon = (int) entradaLong();
		}
		if (opcioon == 1) {
			nuevaClase = "Primera Clase";
		}
		else {
			nuevaClase = "Clase Turista";
		}
		registrado.setClase(nuevaClase);
		
		// Equipaje
		registrado.setEquipaje(new ArrayList<Equipaje>());
		System.out.println("¿Cuántas maletas lleva el pasajero para guardar en bodega?");
		int numeroMaletasB = (int) entradaLong();
		int i = 0;
		int x = i+1;
		while (i < numeroMaletasB) {
			System.out.println("Ingrese el peso de la maleta número "+x+" (En kg y números enteros)."+"\n"+
								"-------------------------------------------------------------------"+"\n"+
								"Nota: El peso máximo es de 25 kg para Primera Clase y de 20 kg para la Clase Turista "+"\n"+
								"Se le cobrará multa por cada kg adicional.");
			int pesoB = (int) entradaLong();
			new Equipaje(registrado, "Bodega", pesoB);
			i++;
			x++;
		}
		System.out.println("¿Cuántas maletas de mano lleva?");
		int numeroMaletasM = (int) entradaLong();
		int j = 0;
		int h = j+1;
		while (j < numeroMaletasM) {
			System.out.println("Ingrese el peso de la maleta número "+h+" (En kg y números enteros)."+"\n"+
								"-------------------------------------------------------------------"+"\n"+
								"Nota: El peso máximo es de 12 kg para Primera Clase y de 10 kg para la Clase Turista "+"\n"+
								"	   Se le cobrará multa por cada kg adicional.");
			int pesoM = (int) entradaLong();
			new Equipaje(registrado, "Mano", pesoM);
			j++;
			h++;
		}
		if (registrado.getClase().equals("Primera Clase")) {
			if (numeroMaletasM + numeroMaletasB > 4) {
				System.out.println("Ha excedido el número máximo de maletas (4) para Primera Clase, \n"+
									"se le cobrarán 35 USD por cada maleta adicional."+"\n"+
									"-------------------------------------------------------------------");
			}
		}
		else {
			if (numeroMaletasM + numeroMaletasB > 3) {
				System.out.println("Ha excedido el número máximo de maletas (3) para la Clase Turista, \n"+
									"se le cobrarán 35 USD por cada maleta adicional."+"\n"+
									"-------------------------------------------------------------------");
			}
		}
		
		// Millas acumuladas
		if (registrado.getMillas() >= 1000) {
			System.out.println("El pasajero tiene "+registrado.getMillas()+" millas acumuladas. Recuerde que\n"+
								"cada 1000 millas el pasajero obtiene un 2% de descuento sobre el costo del vuelo\n"+
								"¿Desea canjear las millas o seguir acumulándolas para otro vuelo?\n");
			System.out.println("Pulse 1 para canjear las millas acumuladas.");
			System.out.println("Pulse 2 para seguir acumulando millas.");
			System.out.println("------------------------------------------------------------------------------------");
			int eleccion = (int) entradaLong();
			while (eleccion != 1 && eleccion != 2) {
				System.out.println("Pulse un número válido.");
				eleccion = (int) entradaLong();
			}
			if (eleccion == 1) {
				System.out.println(registrado.getMillas()+" se aplicarán al descuento.\n"+
									"Si la cifra es mayor a 50000 el vuelo será gratis y el sobrante se acumula.");
				registrado.getCobro().canjearMillas();
				System.out.println("El descuento aplicado por millas será de "+registrado.getCobro().canjearMillas()+" USD.\n");
			}
		}
		
		// Finalización
		registrado.getCobro().calcularCostos();
		
		System.out.println("¡Reinscripción finalizada con éxito! \n"
						+ "----------------------------------");
		System.out.println("Pulse 1 para ver el resumen de la inscripción.");
		System.out.println("Pulse 2 para ver la facturación del pasajero.");
		System.out.println("Pulse 3 para salir al menú principal. \n");
		int opc = (int) entradaLong();
		while (opc != 3) {
			if (opc == 1) {
				System.out.println(registrado);
				System.out.println("------------------------------------------------");
				System.out.println("Pulse 1 para ver el resumen de la inscripción.");
				System.out.println("Pulse 2 para ver la facturación del pasajero.");
				System.out.println("Pulse 3 para salir al menú principal. \n");
				opc = (int) entradaLong();
			}
			else if (opc == 2) {
				System.out.println(registrado.getCobro());
				System.out.println("------------------------------------------------");
				System.out.println("Pulse 1 para ver el resumen de la inscripción.");
				System.out.println("Pulse 2 para ver la facturación del pasajero.");
				System.out.println("Pulse 3 para salir al menú principal. \n");
				opc = (int) entradaLong();
			}
			else {
				System.out.println("Pulse un número válido.");
				opc = (int) entradaLong();
			}
		}
		
	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 4. Check-in de pasajero nuevo.
	static void checkIn2() {
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
			System.out.println("Por favor, ingrese un código válido de vuelo (Ej. 101, 102, 103, 201, 301)");
			codigo = entradaTxt();
		}
		vuelo = Vuelo.getVuelo(codigo);
		System.out.println("¿Cuál es la fecha de nacimiento del pasajero? DD/MM/YYYY");
		String cumpleanos = entradaTxt();
		System.out.println("¿En qué clase volará el pasajero? Teclee la opcion adecuada.");
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
		int x = i+1;
		while (i < numeroMaletasB) {
			System.out.println("Ingrese el peso de la maleta número "+x+" (En kg y números enteros)."+"\n"+
								"-------------------------------------------------------------------"+"\n"+
								"Nota: El peso máximo es de 25 kg para Primera Clase y de 20 kg para la Clase Turista "+"\n"+
								"Se le cobrará multa por cada kg adicional.");
			int pesoB = (int) entradaLong();
			new Equipaje(pasAux, "Bodega", pesoB);
			i++;
			x++;
		}
		System.out.println("¿Cuántas maletas de mano lleva?");
		int numeroMaletasM = (int) entradaLong();
		int j = 0;
		int h = j+1;
		while (j < numeroMaletasM) {
			System.out.println("Ingrese el peso de la maleta número "+h+" (En kg y números enteros)."+"\n"+
								"-------------------------------------------------------------------"+"\n"+
								"Nota: El peso máximo es de 12 kg para Primera Clase y de 10 kg para la Clase Turista "+"\n"+
								"	   Se le cobrará multa por cada kg adicional.");
			int pesoM = (int) entradaLong();
			new Equipaje(pasAux, "Mano", pesoM);
			j++;
			h++;
		}
		if (pasAux.getClase().equals("Primera Clase")) {
			if (numeroMaletasM + numeroMaletasB > 4) {
				System.out.println("Ha excedido el número máximo de maletas (4) para Primera Clase, \n"+
									"se le cobrarán 35 USD por cada maleta adicional."+"\n"+
									"-------------------------------------------------------------------");
			}
		}
		else {
			if (numeroMaletasM + numeroMaletasB > 3) {
				System.out.println("Ha excedido el número máximo de maletas (3) para la Clase Turista, \n"+
									"se le cobrarán 35 USD por cada maleta adicional."+"\n"+
									"-------------------------------------------------------------------");
			}
		}
		System.out.println("¿El pasajero es miembro del programa de viajero frecuente?");
		String frecuente = entradaTxt();
		while (!(frecuente.equals("S")) && !(frecuente.equals("N"))) {
			System.out.println("Reponda S o N");
			frecuente = entradaTxt();
		}
		
		if (frecuente.equals("S")) {
			pasAux.setViajeroFrecuente(true);
		}
		else {
			pasAux.setViajeroFrecuente(false);
		}
		
		pasAux.getCobro().calcularCostos();
		
		System.out.println("¡Inscripción finalizada con éxito! \n"
						+ "----------------------------------");
		System.out.println("Pulse 1 para ver el resumen de la inscripción.");
		System.out.println("Pulse 2 para ver la facturación del pasajero.");
		System.out.println("Pulse 3 para salir al menú principal. \n");
		int opc = (int) entradaLong();
		while (opc != 3) {
			if (opc == 1) {
				System.out.println(pasAux);
				System.out.println("------------------------------------------------");
				System.out.println("Pulse 1 para ver el resumen de la inscripción.");
				System.out.println("Pulse 2 para ver la facturación del pasajero.");
				System.out.println("Pulse 3 para salir al menú principal. \n");
				opc = (int) entradaLong();
			}
			else if (opc == 2) {
				System.out.println(pasAux.getCobro());
				System.out.println("------------------------------------------------");
				System.out.println("Pulse 1 para ver el resumen de la inscripción.");
				System.out.println("Pulse 2 para ver la facturación del pasajero.");
				System.out.println("Pulse 3 para salir al menú principal. \n");
				opc = (int) entradaLong();
			}
			else {
				System.out.println("Pulse un número válido.");
				opc = (int) entradaLong();
			}
		}

	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 5. Mostrar los vuelos programados.
	static void vuelosProgramados() {
		System.out.println("Los vuelos programados en este momento son: ");
		for (int i = 0; i < Vuelo.getVuelos().size(); i++) {
			System.out.println(Vuelo.getVuelos().get(i).toString());
		}
		System.out.println("\n");
;	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 6. Mostrar la flota de POO Airways.
	static void flota() {
		System.out.println("\n" + "La flota de POO Airways está conformada por: ");
		for (int i = 0; i < Avion.getAviones().size(); i++) {
			System.out.println(Avion.getAviones().get(i).toString());
		}
		System.out.println("\n");
	}
	
	// ====================================================================================================
	
	// ====================================================================================================
	// 7. Mostrar la flota de POO Airways.
	static void empleados() {
		System.out.println("\n" + "Los empleados de POO Airways son: ");
		for (int i = 0; i < Empleado.getEmpleados().size(); i++) {
			System.out.println(Empleado.getEmpleados().get(i).toString());
			}
		System.out.println("\n");
		}
		
	// ====================================================================================================
	
	// ====================================================================================================
	// 8. Cambio de estado de un avión.
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
		case 1: avion.setDisponibilidad(true); break;
		case 2: 
			avion.setDisponibilidad(false);
			for(int i = 0; i < avion.getVuelos().size(); i++) {
				System.out.println("Canges por cancelación para los pasajeros del vuelo " + avion.getVuelos().get(i).getCodigo());
				avion.getVuelos().get(i).disponibilidad();
			}
			break;
		}
		System.out.println("\n");
		
		
	}
	// ====================================================================================================
	
	// ====================================================================================================
	// 9. Cambiar el estado de un aeropuerto
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
		case 1: aeropuerto.setEstado(true); break;
		case 2: 
			aeropuerto.setEstado(false);
			for(int i = 0; i < aeropuerto.getVuelos().size(); i++) {
				System.out.println("Canges por cancelación para los pasajeros del vuelo " + aeropuerto.getVuelos().get(i).getCodigo());
				aeropuerto.getVuelos().get(i).disponibilidad();
			}
			break;
		}
		
	}
	
	// ====================================================================================================
	
	// ====================================================================================================
	static void SerializaryDeserializar() {
		Serializador.serializarAeropuertos(Aeropuerto.getAeropuertos());
		Serializador.serializarAviones(Avion.getAviones());
		Serializador.serializarVuelo(Vuelo.getVuelos());
		Serializador.serializarEmpleado(Empleado.getEmpleados());
		
		Deserializador.deserializarAviones();
		Deserializador.deserializarAeropuertos();
		Deserializador.deserializarVuelos();
		Deserializador.deserializarEmpleados();
	}
	
	
	
	
	static String entradaTxt() {
		return entrada.nextLine();
	}

	static long entradaLong() {
		return entrada.nextLong();
	}

}
