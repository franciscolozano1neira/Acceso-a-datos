package reto2.parte1.Ejercicios2;

// Ejercicio nr.1 del PDF "Ejercicios2"

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PruebaCafe2 {
	public static void main(String[] args) {
		XStream xstream1 = new XStream(new DomDriver());
		
		// Le damos los permisos para las dos clases
		xstream1.allowTypes(new Class[] { Cafe.class , Proveedor.class });
		
		//Construimos el objeto café para añadir a proveedores
		Cafe cafe1 = new Cafe();
		cafe1.setNombre("CafeIESCE");
		cafe1.setPrecio((float)5.3);
		cafe1.setVentas(43);	
		
		Cafe cafe2 = new Cafe();
		cafe1.setNombre("CafeIESSanFer");
		cafe1.setPrecio((float)6.8);
		cafe1.setVentas(43);	
		
		Proveedor proveedor1 = new Proveedor();
		proveedor1.setIdentificador(150);
		proveedor1.setNombre("Mi Proveedor");
		proveedor1.setCalle("mi calle");
		proveedor1.setCiudad("madrid");
		proveedor1.setPais("españa");
		proveedor1.setCp(28050);
		proveedor1.setEsNacional(false);
		
		// Añadimos cafe1 y cafe2 al proveedor
		proveedor1.addCafe(cafe1);
		proveedor1.addCafe(cafe2);
		
		// Le ponemos alias
		xstream1.alias("cafe", Cafe.class); // Aparece 'cafe' en vez de 'Ejercicios2.Cafe'
		xstream1.alias("proveedor", Proveedor.class); // Aparece 'proveedor' en vez de 'Ejercicios2.Proveedor'
		xstream1.aliasField("cif", Proveedor.class, "identificador");
		xstream1.useAttributeFor(Proveedor.class, "identificador");
		xstream1.aliasField("empresa", Proveedor.class, "nombre");
		xstream1.useAttributeFor(Proveedor.class, "nombre");
		
		// Hacemos que los elementos de la lista se serialicen directamente
		// como hijos del nodo padre, sin el contenedor extra de <cafes>
		xstream1.addImplicitCollection(Proveedor.class, "cafes");
		
		xstream1.aliasField("marca", Cafe.class, "nombre");
		
		// Ejercicio 8 ---------------------------------------		
		// Ponemos el nombre como atributo de cafe
		xstream1.useAttributeFor(Cafe.class, "nombre");
		
		xstream1.registerConverter(new TotalConvertidor());
		
		// Fin ejercicio 8 -----------------------------------
		
		//Convertimos el objeto persona a xml invocando el método toXML
		String xml=xstream1.toXML(proveedor1);
		
		System.out.println("Objeto convertido a XML mediante toXML: \n" + xml);		
		
		//Reconstruimos un objeto Proveedor a partir del XML generado invocando el método fromXML
		Proveedor proveedorRecons=(Proveedor)xstream1.fromXML(xml);
		
		System.out.println("\nObjeto reconstruido de XML mediante fromXML: \n" 
							+ proveedorRecons.toString());
	}
}
