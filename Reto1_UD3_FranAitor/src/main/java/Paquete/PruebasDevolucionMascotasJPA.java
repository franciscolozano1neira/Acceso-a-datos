package Paquete;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*

1.Prueba de concepto: elegid una base de datos de los retos de temas anteriores, del curso pasado o de las propuestas en el curso
(tema 2 - Bases de datos de ejemplos-20241021 Archivo ) y realizar una aplicación (o reutilizad las de los retos anteriores) que mediante EclipseLink
realice un CRUD sobre una de las entidades de dicha base de datos haciendo el correspondiente mapeo a objetos de Java. En este caso dejad que cree las
tablas el propio EclipseLink sin especificar @Tabla ni @Column.

2.Prueba completa: explorad las distintas posibilidades de hacer que la aplicación cree las tablas, que solo las modifique ante cambios o que se
limite a usar las tablas y datos ya existentes. Cambia mediante @Table y @Column el mapeo para que se corresponda exactamente con los nombres de la
base de datos original.

*/

public class PruebasDevolucionMascotasJPA {

	 public static void main(String[] args) {
	    	
	    	//Leer

	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadMascotas");
	        EntityManager em = emf.createEntityManager();

	        try {
	            em.getTransaction().begin();

	            // Consulta JPQL moderna
	            List<Mascotas> mascota = em
	                    .createQuery("SELECT p FROM Mascotas p", Mascotas.class)
	                    .getResultList();

	            for (Mascotas p : mascota) {
	               //  System.out.println("Nombre: " + p.getNombre()); con esto solo devuelve el nombre pero si
					System.out.println(p);// deberia devolver todos los parametros del toString
	            }

	            //em.getTransaction().commit(); esto no es necesario
	            
	            Mascotas mascota2 = em.find(Mascotas.class, 2L);
	            //En el find siempre se debe de buscar por la clase primaria
				System.out.println("Mascota con ID: 2");
	            System.out.println(mascota2);

	        } catch (Exception e) {
	            e.printStackTrace();
	            if (em.getTransaction().isActive()) {
	                em.getTransaction().rollback();
	            }
	        } finally {
	            em.close();
	            emf.close();
	        }
	    }
	}
