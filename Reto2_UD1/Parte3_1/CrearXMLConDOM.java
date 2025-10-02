package Reto2.Reto2AccesoADatos.src.Parte3_1;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CrearXMLConDOM {
    public static void main(String[] args) throws Exception {
    // Crear una lista de alumnos manualmente
    List<Alumno> alumnos = new ArrayList<>();

    // Agregamos algunos alumnos con datos reales
    alumnos.add(new Alumno("Adrian Mauricio", "Quispe Huarcaya",
            new SimpleDateFormat("yyyy-MM-dd").parse("2006-05-20"),
            "Avenida del Sol", 42));

    alumnos.add(new Alumno("Kevin Andres", "Ramirez Atehortua",
            new SimpleDateFormat("yyyy-MM-dd").parse("2007-12-15"),
            "Calle Luna", 10));

    alumnos.add(new Alumno("Marcos Adam", "Martinez Ouhabi",
            new SimpleDateFormat("yyyy-MM-dd").parse("2007-08-14"),
            "Calle Domingo Rodelgo ", 57));

    alumnos.add(new Alumno("Bianca Stefania", "Amariutei",
            new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-21"),
            "Avenida de la tolerancia ", 8));

    // la forma de construir objetos  es con DocumentBuilder
    DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();

    // Crea un DocumentBuilder para construir documentos XML
    DocumentBuilder db = dBF.newDocumentBuilder();

    // Crea un nuevo documento XML vacio en memoria
    Document doc = db.newDocument();

    // Crea el nodo raíz del XML: <alumnos> (representa el documento XML que estas construyendo)
    Element rz = doc.createElement("alumnos");

    // Añade el nodo raiz al documento
    doc.appendChild(rz);

    // Recorremos la lista de alumnos y creamos nodos XML por cada uno
    for (Alumno a : alumnos) {
    // Element es una clase de la API DOM en Java, que representa un elemento XML dentro de un documento.
        Element eleAlumno = doc.createElement("alumno");

        Element eleNom = doc.createElement("nombre");
        eleNom.setTextContent(a.getNombre()); // Establece el texto
        eleAlumno.appendChild(eleNom); // Añade al nodo <alumno>


        Element eleApe = doc.createElement("apellidos");
        eleApe.setTextContent(a.getApellidos());
        eleAlumno.appendChild(eleApe);


        Element eleNac = doc.createElement("anoNacimiento");
        // Formatear la fecha en formato (yyyy-MM-dd)
        eleNac.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(a.getAnoNacimiento()));
        eleAlumno.appendChild(eleNac);

        // Crear nodo <direccion>
        Element eleDireccion = doc.createElement("direccion");

        Element eleCall = doc.createElement("calle");
        eleCall.setTextContent(a.getDireccion().getCalle());
        eleDireccion.appendChild(eleCall);

        Element eleNum = doc.createElement("numero");
        eleNum.setTextContent(String.valueOf(a.getDireccion().getNumero()));
        eleDireccion.appendChild(eleNum);

        // Añadir <direccion> a <alumno>
        eleAlumno.appendChild(eleDireccion);

        // añade un nodo hijo llamado eleAlumno al nodo rz
        rz.appendChild(eleAlumno);
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
    StreamResult resultado = new StreamResult(new File("alumnos.xml"));

    // Ejecuta la transformacion (genera el archivo XML)
    transformador.transform(src, resultado);

    System.out.println("Archivo alumnos.xml se a generado correctamente.");
}
}


