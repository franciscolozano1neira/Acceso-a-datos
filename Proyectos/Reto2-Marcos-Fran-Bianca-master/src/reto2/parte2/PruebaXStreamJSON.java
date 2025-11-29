package reto2.parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class PruebaXStreamJSON {

	public static void main(String[] args) {

		//Declaramos un bloque try para lanzar los escritores, lectores y demas variables que sueltan errores
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("libro.json")));
				BufferedReader br = new BufferedReader(new FileReader(new File("libro.json")));) {
			
			Libro elquijote = new Libro("El Quijote","Miguel de Cervantes","Nisu",233,1605);
			Libro elproblemadelostrescuerpos = new Libro("El problema de los tres cuerpos","Cixin Liu","Nova",350,2021);
		// Declaramos la variable xstream1 de la clase XStream que usaremos para serializar los objetos a json
		// y para deserializarlos
			XStream xstream1 = new XStream(new JettisonMappedXmlDriver());
			xstream1.addPermission(AnyTypePermission.ANY);
		// Creamos las listas de Libros
			List misLibros = new ArrayList<Libro>();
			List misLibros2;
		// Añadimos los Libros a la lista
			misLibros.add(elquijote);
			misLibros.add(elproblemadelostrescuerpos);
		// Creamos la variable json y en ella metemos el resultado de posar a json la lista de libros
			String json = xstream1.toXML(misLibros);
			System.out.println("JSON generado:\n" + json+"\n\n");
		//Escribimos en el archivo
			bw.write(json);
			bw.close();
		// Leemos el archivo json
			String linea = br.readLine();
			System.out.println("JSON leido:");
			System.out.println(linea);

		// Añadimos a la segunda lista (hasta ahora vacia) los libros leidos del archivo json
		// y los mostramos por pantalla
			misLibros2 = (List<Libro>) xstream1.fromXML(linea);
			System.out.println("\nLibros como objetos leidos:\n"+misLibros2.toString().replaceAll("\\]\\[","\n"));
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
