package baseDatos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import gestion.Avion;

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
}
