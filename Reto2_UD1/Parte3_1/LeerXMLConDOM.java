package Reto2.Reto2AccesoADatos.src.Parte3_1;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;

public class LeerXMLConDOM {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML generado
            File archivo = new File("alumnos.xml");

            // Configurar DocumentBuilder para leer XML
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = dBF.newDocumentBuilder();

            // Parsear el documento XML y obtener el DOM
            Document doc = dB.parse(archivo);
            // El método normalize() pertenece a la interfaz Node del API DOM en Java y sirve
            // para limpiar y simplificar la estructura interna del nodo al que se aplica
            doc.getDocumentElement().normalize();

            // Para obtener la lista de nodos <alumno> se utiliza el método getElementsByTagName
            NodeList nList = doc.getElementsByTagName("alumno");

            // recorrer uno por uno todos los nodos alumno que están dentro del XML
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nAlumno:");

                    // Obtener y muestra cada etiqueta
                    System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Apellidos: " + eElement.getElementsByTagName("apellidos").item(0).getTextContent());
                    System.out.println("Año Nacimiento: " + eElement.getElementsByTagName("anoNacimiento").item(0).getTextContent());

                    // Obtiener la direccion que es un nodo hijo dentro de alumno
                    Element direccion = (Element) eElement.getElementsByTagName("direccion").item(0);
                    System.out.println("Dirección:");
                    System.out.println("  Calle: " + direccion.getElementsByTagName("calle").item(0).getTextContent());
                    System.out.println("  Número: " + direccion.getElementsByTagName("numero").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
