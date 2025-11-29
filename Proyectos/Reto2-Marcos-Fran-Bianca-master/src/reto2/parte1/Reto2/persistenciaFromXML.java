package reto2.parte1.Reto2;

import java.io.File;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.AnyTypePermission;
import reto2.parte1.Ejercicios2.Empresa;

public class persistenciaFromXML {
	 public static void main(String[] args) {
        // Crear instancia de XStream
        XStream xstream1 = new XStream(new DomDriver());
        xstream1.addPermission(AnyTypePermission.ANY);
        xstream1.allowTypes(new Class[] { Libro.class, Biblioteca.class});

        // Estrategia de persistencia usando archivo
         PersistenceStrategy estrategia = new FilePersistenceStrategy(new File("."),xstream1);
         XmlArrayList lista = new XmlArrayList(estrategia);
        
        try {
            // Recuperar la lista de objetos desde XML usando persistencia
            for (Object obj : lista) {
                Biblioteca biblioRecons = (Biblioteca) obj;
                if (biblioRecons != null) {
                    // Iterar sobre los libros
                    for (Libro libro : biblioRecons.getContent()) {
                        System.out.println("Título: " + libro.getTitulo() +
                                "\nAutor: " + libro.getAutor() +
                                "\nAño: " + libro.getAño() +
                                "\nVentas: " + libro.getVentas());
                        System.out.println();
                    }
                } else {
                    System.out.println("No se encontraron datos en el archivo XML.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	 }
	        
	       
	 /*
	public static void main(String[] args) {
		// Dadas las notas del aula, añadimos estas dos líneas:
		XStream xstream = new XStream(new DomDriver());
		xstream.addPermission(AnyTypePermission.ANY);
			// Y aquí añadimos el ,xstream
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File("."),xstream);
		
		XmlArrayList lista = new XmlArrayList(strategy);
		
		for (Iterator it = lista.iterator(); it.hasNext(); ) {
			nombreBiblioteca nb = (nombreBiblioteca)it.next();
			
			if (nb.getName().equals("Biblioteca José Saramago")) {
				System.out.println("Borrando Biblioteca José Saramago");
				it.remove();
			} else {
				System.out.println(nb.getName() + " no ha sido borrado.");
			}
		}
	}*/
}
