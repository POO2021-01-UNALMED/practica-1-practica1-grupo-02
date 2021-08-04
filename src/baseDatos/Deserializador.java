package baseDatos;
import java.io.*;
import java.util.Vector;

import gestion.*;

import paquete1.*;

public class Deserializador {
	private static String ruta = System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\";
	private static File rutaAviones = new File(ruta + "avion.txt");
	
	
	public static void deserializarAviones() {
		
		FileInputStream fis;
		ObjectInputStream ois;	        
			try {
				fis= new FileInputStream(rutaAviones);
				ois = new ObjectInputStream(fis);
				Vector<Avion> aviones = (Vector<Avion>) ois.readObject();
				ois.close();
				for(Avion e : aviones) {
					System.out.println(e);
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}		
		}
	

	
	private static File rutaAeropuerto = new File(ruta + "aeropuerto.txt");
	
	public static void deserializarAeropuertos() {
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis= new FileInputStream(rutaAeropuerto);
			ois = new ObjectInputStream(fis);
			Vector<Aeropuerto> aeropuertos = (Vector<Aeropuerto>) ois.readObject();
			ois.close();
			for(Aeropuerto e : aeropuertos) {
				System.out.println(e);
			}
		} catch(Exception e) {
			
		}
	}
	
	private static File rutaVuelo = new File(ruta + "vuelo.txt");
	public static void deserializarVuelos() {
		FileInputStream fis;
		ObjectInputStream ois;
		try{
			fis= new FileInputStream(rutaVuelo);
			ois = new ObjectInputStream(fis);
			Vector<Vuelo> vuelos = (Vector<Vuelo>) ois.readObject();
			ois.close();
			for(Vuelo e : vuelos) {
				System.out.println(e);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	private static File rutaEmpleado = new File(ruta + "empleado.txt");
	public static void deserializarEmpleados() {
		FileInputStream fis;
		ObjectInputStream ois;
		try{
			fis= new FileInputStream(rutaEmpleado);
			ois = new ObjectInputStream(fis);
			Vector<Empleado> empleados = (Vector<Empleado>) ois.readObject();
			ois.close();
			for(Empleado e : empleados) {
				System.out.println(e);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
