package baseDatos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import gestion.*;


public class Serializador {

	
	public static void serializarAviones(Vector<Avion> vector) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\avion.txt"));
			fichero.writeObject(vector);
			fichero.close();
			
		}catch(Exception e) {
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

	public static void serializarEmpleado(Vector<Empleado> vector) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("src\\baseDatos\\temp\\empleado.txt"));
			fichero.writeObject(vector);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}
}
