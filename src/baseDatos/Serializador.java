package baseDatos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import gestion.*;
import paquete1.Empleado;
import paquete1.Pasajero;

public class Serializador {

	
	public static void serializarAviones(Vector<Avion> vector) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\avion.txt"));
			fichero.writeObject(vector);
			fichero.close();
			
		}catch(Exception e) {
			System.out.println("peepe");
		}
		
	}
	
	public static void serializarAeropuertos(Vector<Aeropuerto> aeropuertos) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\aeropuerto.txt"));
			fichero.writeObject(aeropuertos);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
	
	public static void serializarVuelo(Vector<Vuelo> vector) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\vuelo.txt"));
			fichero.writeObject(vector);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}

	
}
