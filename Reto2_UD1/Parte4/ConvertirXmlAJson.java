package Reto2.Reto2AccesoADatos.src.Parte4;

import Reto2.Reto2AccesoADatos.src.Ejercicios2.Empleado;

import java.io.File;

public class ConvertirXmlAJson {
    public static void main(String[] args) {

            try {
                // Cargar los mapeadores
                XmlMapper xmlMapper = new XmlMapper();
                ObjectMapper jsonMapper = new ObjectMapper();

                // Leer el archivo XML con múltiples <record>
                ListaEmpleados lista = xmlMapper.readValue(new File("empleadosPojo.xml"), ListaEmpleados.class);

                // Convertir a JSON con formato bonito
                String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(lista);

                // Imprimir JSON por consola
                System.out.println(json);

                // Guardar en archivo
                jsonMapper.writeValue(new File("empleadosPojo.json"), lista);

                System.out.println("✅ Conversión completada: empleados.json creado.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

