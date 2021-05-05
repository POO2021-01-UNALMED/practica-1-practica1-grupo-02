package baseDatos;
import java.io.*;

import gestion.Avion;
import gestion.Vuelo;
import paquete1.*;

public class Deserializador {
	
	public static void deserializar(Avion avion) {
		System.out.println("unn");
		try{
			ObjectInputStream recuperar_fichero= new ObjectInputStream(new FileInputStream("C:\\Users\\vladis\\OneDrive\\Documentos\\GitHub\\practica-1-practica1-grupo-02\\src\\baseDatos\\temp\\avion.txt"));
			Avion [] avionRecuperado = (Avion[]) recuperar_fichero.readObject();
			recuperar_fichero.close();
			for(Avion e : avionRecuperado) {
				System.out.println(e);
			}
		} catch(Exception e) {
			
		}
	}
	/*
	public static void deserializar(Avion avion) {
		try{
			ObjectInputStream recuperar_fichero= new ObjectInputStream(new FileInputStream("C:\\Users\\vladis\\OneDrive\\Documentos\\GitHub\\practica-1-practica1-grupo-02\\src\\baseDatos\\temp\\avion.txt"));
			Avion [] avionRecuperado = (Avion[]) recuperar_fichero.readObject();
			recuperar_fichero.close();
			for(Avion e : avionRecuperado) {
				System.out.println(e);
			}
		} catch(Exception e) {
			
		}
	}
	*/
	
	public static void deserializar(Empleado empleado) {
		try{
			ObjectInputStream recuperar_fichero= new ObjectInputStream(new FileInputStream("C:\\Users\\vladis\\OneDrive\\Documentos\\GitHub\\practica-1-practica1-grupo-02\\src\\baseDatos\\temp\\empleados.txt"));
			Empleado [] empleadosRecuperado = (Empleado[]) recuperar_fichero.readObject();
			recuperar_fichero.close();
			for(Empleado e : empleadosRecuperado) {
				System.out.println(e);
			}
		} catch(Exception e) {
			
		}
	}
	
	public static void deserializar(Pasajero pasajero) {
		try{
			ObjectInputStream recuperar_fichero= new ObjectInputStream(new FileInputStream("C:\\Users\\vladis\\OneDrive\\Documentos\\GitHub\\practica-1-practica1-grupo-02\\src\\baseDatos\\temp\\pasajeros.txt"));
			Pasajero [] pasajerosRecuperado = (Pasajero[]) recuperar_fichero.readObject();
			recuperar_fichero.close();
			for(Pasajero e : pasajerosRecuperado) {
				System.out.println(e);
			}
		} catch(Exception e) {
			
		}
	}

}
