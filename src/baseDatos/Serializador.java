package baseDatos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import gestion.Avion;
import paquete1.Empleado;
import paquete1.Pasajero;

public class Serializador {
	//private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	public static void serializar(Avion avion) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("C:\\Users\\vladis\\OneDrive\\Documentos\\GitHub\\practica-1-practica1-grupo-02\\src\\baseDatos\\temp\\avion.txt"));
			fichero.writeObject(avion);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}
	public static void serializar(Empleado empleado) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("C:\\Users\\vladis\\OneDrive\\Documentos\\GitHub\\practica-1-practica1-grupo-02\\src\\baseDatos\\temp\\avion.txt"));
			fichero.writeObject(empleado);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}
	public static void serializar(Pasajero pasajero) {
		try{
			ObjectOutputStream fichero= new ObjectOutputStream(new FileOutputStream("C:\\Users\\vladis\\OneDrive\\Documentos\\GitHub\\practica-1-practica1-grupo-02\\src\\baseDatos\\temp\\avion.txt"));
			fichero.writeObject(pasajero);
			fichero.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
}
