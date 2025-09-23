import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PokedexProperties {

    public static void main(String[] args) {
        Properties pokedex = new Properties();
// 1 Crea el objeto Properties y mete un pequeño conjunto de pares clave/valor con el método setProperty
        pokedex.setProperty("bulbasaur", "planta/veneno");
        pokedex.setProperty("ivysaur", "planta/veneno");
        pokedex.setProperty("venusaur", "planta/veneno");
        pokedex.setProperty("charmander", "fuego");
        pokedex.setProperty("charmeleon", "fuego");
        pokedex.setProperty("charizard", "fuego/volador");
        pokedex.setProperty("squirtle", "agua");
        pokedex.setProperty("wartortle", "agua");
        pokedex.setProperty("blastoise", "agua");
        pokedex.setProperty("caterpie", "bicho");
        pokedex.setProperty("metapod", "bicho");
        pokedex.setProperty("butterfree", "bicho/volador");
        pokedex.setProperty("weedle", "bicho/veneno");
        pokedex.setProperty("kakuna", "bicho/veneno");
        pokedex.setProperty("beedrill", "bicho/veneno");
        pokedex.setProperty("pidgey", "normal/volador");
        pokedex.setProperty("pidgeotto", "normal/volador");
        pokedex.setProperty("pidgeot", "normal/volador");
        pokedex.setProperty("rattata", "normal");
        pokedex.setProperty("raticate", "normal");

//2  Guarda el objeto Properties en un fichero usando su método store y storeToXML pasándole por argumento un FileOutputStream

        try (FileOutputStream f = new FileOutputStream("Pokemon.xml")) {
            pokedex.storeToXML(f, "Pokedex InicioXML", "UTF-8");
            System.out.println("Se creo bien el archivo");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //3 Examina los ficheros creados.



    //4 Prueba la recuperación de los datos guardados en fichero mediante su método load y loadFromXML pasándole como argumento un FileInputStream
        try (FileInputStream fm = new FileInputStream("Pokemon.xml")) {
            pokedex.loadFromXML(fm);
            System.out.println(pokedex.getProperty("charmander"));
        } catch (IOException e) {
            e.printStackTrace();


        }


    }
}