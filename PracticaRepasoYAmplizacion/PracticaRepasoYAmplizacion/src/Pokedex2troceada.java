/* 5 Reflexión: ¿os serviría la clase anterior para guardar una
    colección de objetos tipo libros o del estilo? ¿Cómo lo haríais?
    Documentadlo.
     */

    /* pues si la coleccion de objetos de tipo libro no es una estructura
    de mas de dos clave, dicho asi, si solo guardadmos el nombre del libro y
     el autor si, por que serian dos claves, una llave y la otra valor de
     tipo String. Pero a la hora de guardar una estructura mas
     compleja no se podria dado que ya superaria la configuracion de
      clave/valor(Properties no soporta colecciones ni estructuras
      complejas), para realizar dichos cambios si quieres seguir
      usando la clase propierties tendriamos que dividirlos en
      campos distintos lo cual lo volveria mas tedioso a la hora de
       introducir valores

     */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Pokedex2troceada {

    public static void main(String[] args) {
        Properties pokedex2 = new Properties();

        pokedex2.setProperty("pokemon1.nombre", "Pikachu");
        pokedex2.setProperty("pokemon1.tipo", "Eléctrico");
        pokedex2.setProperty("pokemon1.nivel", "25");

        pokedex2.setProperty("pokemon2.nombre", "Charmander");
        pokedex2.setProperty("pokemon2.tipo", "Fuego");
        pokedex2.setProperty("pokemon2.nivel", "15");

        pokedex2.setProperty("pokemon3.nombre", "Bulbasaur");
        pokedex2.setProperty("pokemon3.tipo", "Planta/Veneno");
        pokedex2.setProperty("pokemon3.nivel", "5");

        pokedex2.setProperty("pokemon4.nombre", "Squirtle");
        pokedex2.setProperty("pokemon4.tipo", "Agua");
        pokedex2.setProperty("pokemon4.nivel", "10");

        try {FileOutputStream f = new FileOutputStream("Pokemon2.xml");

            pokedex2.storeToXML(f, "Pokedex InicioXML", "UTF-8");
            System.out.println("Se creo bien el archivo");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {FileInputStream fm = new FileInputStream("Pokemon2.xml");
            pokedex2.loadFromXML(fm);
            System.out.println("Pokémon 1: " +
                    pokedex2.getProperty("pokemon1.nombre")
                    + " (" + pokedex2.getProperty("pokemon1.tipo")
                    + ", nivel " + pokedex2.getProperty("pokemon1.nivel") + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
