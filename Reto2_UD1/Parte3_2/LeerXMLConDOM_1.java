package Reto2.Reto2AccesoADatos.src.Parte3_2;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeerXMLConDOM_1 {
    public static void main(String[] args) throws Exception {
        // Cargar el archivo XML generado
        File inputFile = new File("Cafes.xml");

        // Configurar DocumentBuilderFactory para construir documentos XML DOM
        DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();

        // Crear un DocumentBuilder que nos permite parsear XML
        DocumentBuilder dB = dBF.newDocumentBuilder();

        // Parsear el documento XML y obtener el DOM
        Document doc = dB.parse(inputFile);

        // El método normalize limpia la estructura interna del documento
        // Agrupa nodos de texto adyacentes y elimina nodos vacíos
        doc.getDocumentElement().normalize();

        // Mostrar el nombre del nodo raíz (<cafes>)
        System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

        // Obtener lista de nodos <cafe>
        NodeList nList = doc.getElementsByTagName("cafe");

        // recorrer uno por uno todos los nodos cafe que están dentro del XML
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            // Comprobar que el nodo es de tipo ELEMENT_NODE (para evitar nodos de texto o espacios vacíos)
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                // Imprimir los datos del café accediendo a sus elementos
                System.out.println("\nCafé:");
                System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Precio: " + eElement.getElementsByTagName("precio").item(0).getTextContent());
                System.out.println("Ventas: " + eElement.getElementsByTagName("ventas").item(0).getTextContent());
                System.out.println("Total: " + eElement.getElementsByTagName("total").item(0).getTextContent());
            }
        }
    }
}




