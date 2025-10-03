package Reto2.Reto2AccesoADatos.src.Ejercicios2;

//Ejercicio nr.3 y 5 del PDF "Ejercicios2"

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PruebaEmpresa {
	public static void main(String[] args) {
		XStream xstream1 = new XStream(new DomDriver());
		
		// Le damos los permisos para las dos clases
		xstream1.allowTypes(new Class[] { Empresa.class , Empleado.class });
		
	// ---------------GENERAMOS LOS EMPLEADOS---------------
		Empleado e1 = new Empleado();
		e1.setId(12);
		e1.setNombre("Juan");
		e1.setTitulo("Analista");
		e1.setActivo(false);
		Date fecha1 = new Date("08/05/2015");
		e1.setFechaAlta(fecha1);
		
        Empleado e2 = new Empleado();
		e2.setId(14);
		e2.setNombre("Pedro");
		e2.setTitulo("Programador");
		e2.setActivo(true);
		e2.setFechaAlta(fecha1);
        
	// ---------------GENERAMOS LA EMPRESA---------------
        Empresa emp1 = new Empresa();
        emp1.setDireccion("calle empresa");
        emp1.setEsPYME(true);
        URL nuevaURL;
		try {
			nuevaURL = new URL("http://www.miempresa.es");
			emp1.setUrle(nuevaURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
              
        
     // ---------------AÑADIMOS EMPLEADOS A EMPRESA---------------
        emp1.addEmpleado(e1);
        emp1.addEmpleado(e2);
        
        xstream1.alias("empleado", Empleado.class);
		xstream1.alias("empresa", Empresa.class);
		
		xstream1.aliasField("cif", Empresa.class, "idEmpresa");
		xstream1.useAttributeFor(Empresa.class, "idEmpresa");
		
		
		xstream1.aliasField("nre", Empleado.class, "id");
		xstream1.useAttributeFor(Empleado.class, "id");
		
		xstream1.aliasField("cargo", Empleado.class, "titulo");
		xstream1.aliasField("alta", Empleado.class, "fechaAlta");
		
		xstream1.aliasField("web", Empleado.class, "urle");
		xstream1.aliasField("tipo", Empleado.class, "esPYME");
        
        //Convertimos el objeto persona a xml invocando el método toXML
  		String xml=xstream1.toXML(emp1);
  		
  		System.out.println("Objeto convertido a XML mediante toXML: \n" + xml);		
  		
  		//Reconstruimos un objeto Proveedor a partir del XML generado invocando el método fromXML
  		Empresa empRecons=(Empresa)xstream1.fromXML(xml);
  		
  		System.out.println("\nObjeto reconstruido de XML mediante fromXML: \n" 
  							+ empRecons.toString());
       
	    }
	
		
}
