package Reto2.Reto2AccesoADatos.src.Parte3_3;


import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;

public class LeerXMLConDOM_2 {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML generado
            File archivo = new File("empresa.xml");

            // Configurar DocumentBuilder para leer XML
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = dBF.newDocumentBuilder();

            // Parsear el documento XML y obtener el DOM
            Document doc = dB.parse(archivo);
            doc.getDocumentElement().normalize();

            // Obtener el nodo raíz <empresa>
            Element empresaElement = doc.getDocumentElement();

            System.out.println("ID Empresa (atributo): " + empresaElement.getAttribute("id"));
            System.out.println("Nombre Empresa: " + empresaElement.getElementsByTagName("nombreEmpresa").item(0).getTextContent());
            System.out.println("Dirección: " + empresaElement.getElementsByTagName("direccion").item(0).getTextContent());
            System.out.println("Número de empleados: " + empresaElement.getElementsByTagName("numEmpleados").item(0).getTextContent());
            System.out.println("Es PYME: " + empresaElement.getElementsByTagName("esPYME").item(0).getTextContent());

            // Obtener el nodo <empleados>
            NodeList empleadosList = empresaElement.getElementsByTagName("empleados");
            if (empleadosList.getLength() > 0) {
                Element empleadosElement = (Element) empleadosList.item(0);

                // Obtener todos los nodos <empleado>
                NodeList empleadoNodes = empleadosElement.getElementsByTagName("empleado");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                for (int i = 0; i < empleadoNodes.getLength(); i++) {
                    Node empNode = empleadoNodes.item(i);
                    if (empNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element empElement = (Element) empNode;
                        System.out.println("\nEmpleado " + (i + 1) + ":");

                        System.out.println("  ID: " + empElement.getElementsByTagName("id").item(0).getTextContent());
                        System.out.println("  Nombre: " + empElement.getElementsByTagName("nombre").item(0).getTextContent());
                        System.out.println("  Título: " + empElement.getElementsByTagName("titulo").item(0).getTextContent());
                        System.out.println("  Activo: " + empElement.getElementsByTagName("activo").item(0).getTextContent());
                        System.out.println("  Número Empl: " + empElement.getElementsByTagName("numeroEmpl").item(0).getTextContent());
                        System.out.println("  Fecha Alta: " + empElement.getElementsByTagName("fechaAlta").item(0).getTextContent());
                    }
                }
            } else {
                System.out.println("No hay empleados en el XML.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
