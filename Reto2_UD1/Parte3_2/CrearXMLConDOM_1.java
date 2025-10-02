package Reto2.Reto2AccesoADatos.src.Parte3_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CrearXMLConDOM_1 {
    public static void main(String[] args) throws Exception {
    // Crear una lista de alumnos manualmente
    List<Cafe> Cafes = new ArrayList<>();

    // Agregamos algunos alumnos con datos reales
        Cafe c1 = new Cafe();
        c1.setNombre("Colombiano");
        c1.setPrecio(3.5f);
        c1.setVentas(100);
        c1.setTotal(350);
        Cafes.add(c1);

        Cafe c2 = new Cafe();
        c1.setNombre("Brasileño");
        c1.setPrecio(2.9f);
        c1.setVentas(80);
        c1.setTotal(320);
        Cafes.add(c1);

        Cafe c3 = new Cafe();
        c1.setNombre("Etíope");
        c1.setPrecio(4.2f);
        c1.setVentas(60);
        c1.setTotal(252);
        Cafes.add(c1);

        Cafe c4 = new Cafe();
        c4.setNombre("Keniano");
        c4.setPrecio(5.4f);
        c4.setVentas(90);
        c4.setTotal(468);
        Cafes.add(c4);


    // la forma de construir objetos  es con DocumentBuilder
    DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();

    // Crea un DocumentBuilder para construir documentos XML
    DocumentBuilder db = dBF.newDocumentBuilder();

    // Crea un nuevo documento XML vacio en memoria
    Document doc = db.newDocument();

    // Crea el nodo raíz del XML: <alumnos> (representa el documento XML que estas construyendo)
    Element rz = doc.createElement("cafes");

    // Añade el nodo raiz al documento
    doc.appendChild(rz);

    // Recorremos la lista de alumnos y creamos nodos XML por cada uno
    for (Cafe a : Cafes) {
    // Element es una clase de la API DOM en Java, que representa un elemento XML dentro de un documento.
        Element eleCafe = doc.createElement("cafe");

        Element eleNom = doc.createElement("nombre");
        eleNom.setTextContent(a.getNombre()); // Establece el texto
        eleCafe.appendChild(eleNom); // Añade al nodo <nombre>


        Element elePr = doc.createElement("Precio");
        elePr.setTextContent(String.valueOf(a.getPrecio()));
        eleCafe.appendChild(elePr);


        Element eleVen = doc.createElement("Ventas");
        eleVen.setTextContent(String.valueOf(a.getVentas()));
        eleCafe.appendChild(eleVen);


        Element eleTotal = doc.createElement("numero");
        eleTotal.setTextContent(String.valueOf(a.getTotal()));
        eleCafe.appendChild(eleTotal);

        // añade un nodo hijo llamado eleAlumno al nodo rz
        rz.appendChild(eleCafe);
    }

    // --- Asi Guarda el arbol DOM en un archivo XML ---

    // transformadores para convertir el DOM a archivo
    TransformerFactory tRF = TransformerFactory.newInstance();

    // Crea el transformador
    Transformer transformador = tRF.newTransformer();

    // formateo de salida XML  resultante este con sangría
    transformador.setOutputProperty(OutputKeys.INDENT, "yes");

    // Fuente del DOM (el documento en memoria)
    DOMSource src = new DOMSource(doc);

    // Resultado: un archivo llamado alumnos.xml
    StreamResult resultado = new StreamResult(new File("Cafes.xml"));

    // Ejecuta la transformacion (genera el archivo XML)
    transformador.transform(src, resultado);

    System.out.println("Archivo cafes.xml se a generado correctamente.");
}
}


