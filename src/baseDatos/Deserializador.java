package baseDatos;
import java.io.*;

import gestion.*;

import paquete1.*;

public class Deserializador {
	private static File rutatemp = new File("src\\baseDatos\\temp\\avion.txt");
	
	
	public static void deserializar() {
		
		//File[] docs = rutatemp.listFiles();
		
		// --- Forma numero 1
		
		FileInputStream fis;
		ObjectInputStream ois;
		        
			try {
				fis= new FileInputStream(rutatemp);
				ois = new ObjectInputStream(fis);
				Aeropuerto [] avionRecuperado = (Aeropuerto[]) ois.readObject();
				ois.close();
				for(Aeropuerto e : avionRecuperado) {
					System.out.println(e);
				}
			}catch(Exception e) {
				System.out.println("no lee el archivo");
			}
			
			// --- Forma numero 2
		/*
				try {
ObjectInputStream recuperar_fichero= new ObjectInputStream(new FileInputStream("src\\baseDatos\\temp\\avion.txt" ));
				  Avion [] avionRecuperado = (Avion[]) recuperar_fichero.readObject();
				  recuperar_fichero.close();
				 	for(Avion e : avionRecuperado) {
					System.out.println(e);
					}
	}catch(Exception e) {
		System.out.println("no lee el archivo");
	}
*/
		
				
			
		}
	

	/*
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
*/
}
