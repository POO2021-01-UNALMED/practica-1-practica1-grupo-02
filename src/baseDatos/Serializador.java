package baseDatos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import gestion.*;
import paquete1.Empleado;
import paquete1.Pasajero;

public class Serializador {
	
	
	public static void serializar(Avion avion) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\avion.txt"));
			fichero.writeObject(avion);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
	public static void serializar(Aeropuerto aeropuerto) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\aeropuerto.txt"));
			fichero.writeObject(aeropuerto);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
	public static void serializar(Vuelo vuelo) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\vuelo.txt"));
			fichero.writeObject(vuelo);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}

	
}
