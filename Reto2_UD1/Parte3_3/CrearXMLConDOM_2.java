package Reto2.Reto2AccesoADatos.src.Parte3_3;

import org.w3c.dom.Attr;
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

public class CrearXMLConDOM_2 {
    public static void main(String[] args) throws Exception {

        // Crear lista de empleados
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Añadir empleados a la lista usando el constructor personalizado
        empleados.add(new Empleado(1, "Kevin", "Gerente", true, 1234, new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-01")));
        empleados.add(new Empleado(2, "Bianca", "Analista", true, 1235, new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-15")));
        empleados.add(new Empleado(3, "Marcos", "Programadora", false, 1236, new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-20")));

        // Crear objeto Empresa
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(1001);
        empresa.setNombreEmpresa("Tech Solutions");
        empresa.setDireccion("Calle luna 33");
        empresa.setNumEmpleados(empleados.size());
        empresa.setEsPYME(true);

        // Crear DocumentBuilderFactory para construir el documento XML
        DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder bb = dBF.newDocumentBuilder();

        // Crear un documento XML vacío en memoria
        Document doc = bb.newDocument();

        // Crear nodo raíz <empresa>
        Element eleraiz = doc.createElement("empresa");
        doc.appendChild(eleraiz);

        // Crear un atributo 'id' y asignarle el valor id del empleado
        Attr attr = doc.createAttribute("id");
        attr.setValue(String.valueOf(empresa.getIdEmpresa()));

        // Asignar el atributo 'id' al nodo <empleado>
        eleraiz.setAttributeNode(attr);

        Element eleEmpresa = doc.createElement("nombreEmpresa");
        eleEmpresa.setTextContent(empresa.getNombreEmpresa());
        eleraiz.appendChild(eleEmpresa);

        Element eledireccion = doc.createElement("direccion");
        eledireccion.setTextContent(empresa.getDireccion());
        eleraiz.appendChild(eledireccion);

        Element eleEmpleados = doc.createElement("numEmpleados");
        eleEmpleados.setTextContent(String.valueOf(empresa.getNumEmpleados()));
        eleraiz.appendChild(eleEmpleados);

        Element elePYME = doc.createElement("esPYME");
        elePYME.setTextContent(String.valueOf(empresa.isEsPYME()));
        eleraiz.appendChild(elePYME);

        // Crear nodo <empleados> que contendrá todos los empleados
        Element empleadosElement = doc.createElement("empleados");
        eleraiz.appendChild(empleadosElement);

        // Formateador de fecha para las fechas en formato yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Recorrer la lista de empleados y crear nodo <empleado> para cada uno
        // problema al recorrer un foreach
        for (Empleado e : empresa.getEmpleados()) {
            Element empleadoElement = doc.createElement("empleado");

            Element id = doc.createElement("id");
            id.setTextContent(String.valueOf(e.getId()));
            empleadoElement.appendChild(id);

            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(e.getNombre());
            empleadoElement.appendChild(nombre);

            Element titulo = doc.createElement("titulo");
            titulo.setTextContent(e.getTitulo());
            empleadoElement.appendChild(titulo);

            Element activo = doc.createElement("activo");
            activo.setTextContent(String.valueOf(e.isActivo()));
            empleadoElement.appendChild(activo);

            Element numeroEmpl = doc.createElement("numeroEmpleado");
            numeroEmpl.setTextContent(String.valueOf(e.getNumeroEmpl()));
            empleadoElement.appendChild(numeroEmpl);

            Element fechaAlta = doc.createElement("fechaAlta");
            fechaAlta.setTextContent(sdf.format(e.getFechaAlta()));
            empleadoElement.appendChild(fechaAlta);

            // Añadir este empleado al nodo <empleados>
            empleadosElement.appendChild(empleadoElement);
        }

        // Configurar Transformer para escribir el XML en archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Para que el XML tenga sangría y sea legible
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Fuente DOM (el documento XML en memoria)
        DOMSource src = new DOMSource(doc);

        // Archivo de salida
        StreamResult resultado = new StreamResult(new File("empresa.xml"));

        // Ejecutar la transformación (guardar el archivo)
        transformer.transform(src, resultado);

        System.out.println("Archivo empresa.xml generado correctamente.");
    }
}

