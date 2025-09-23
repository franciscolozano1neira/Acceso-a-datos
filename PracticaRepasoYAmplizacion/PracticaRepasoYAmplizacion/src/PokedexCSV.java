/* 3 Cread una colección de objetos de tu interés (libros, coches, etc.) y
haz la prueba de concepto de guardarla y recuperarla a ficheros CSV mediante
PrintWriter y BufferedReader. Probad a intercambiar ficheros y ver si os los
lee el programa del compañero en su ordenador. Algunas pruebas adicionales
¿trata bien los acentos y las eñes? prueba a guardar con varias
codificaciones distintas ¿Qué pasa si generas el archivo CSV con un
procesador de textos (Word/Writer)? ¿Qué pasa si un nombre contiene una
coma, podrías solucionarlo?*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* metodo para solucionar las comillas y comas*/
public class PokedexCSV {
    public PokedexCSV() throws IOException {
    }

    public static void main(String[] args) {
        List<Pokemon> pokedex = new ArrayList<>();
        Pokemon Pikachu = new Pokemon(25, "Pikachu", "Eléctrico");
        Pokemon Charmander = new Pokemon(4, "Charmander", "fuego");
        Pokemon Bulbasaur = new Pokemon(1, "Bulbasaur", "Planta/Veneno");
        Pokemon Squirtle = new Pokemon(7, "Squirtle", "agua");

        pokedex.add(new Pokemon(25, "Pikachu", "Eléctrico"));
        pokedex.add(new Pokemon(4, "Charmander", "Fuego"));
        pokedex.add(new Pokemon(7, "Squirtle", "Agua"));
        pokedex.add(new Pokemon(1, "Bulbasaur", "Planta/Veneno"));

// esto es para escribir en el csv
       try {
            PrintWriter es = new PrintWriter(new FileWriter(new File("pokedex.csv")));

            es.write("ID,Nombre,Tipo");
            for (Pokemon p : pokedex) {
                es.write(
                        (String.valueOf(p.getId())) + ", "
                                + (p.getNombre()) + ","
                                + (p.getTipo())
                );
            }
            System.out.println("Pokédex guardada en pokedex.csv");

        }catch (IOException e) {
            e.printStackTrace();
        }
// leer el csv anterior
        try{
            BufferedReader lc = new BufferedReader(new FileReader( new File("pokedex.csv")));

                String linea;
                lc.readLine();
                while ((linea = lc.readLine()) != null) {
                    String[] partes = linea.split(",");

                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String tipo = partes[2];

                    Pokemon k = new Pokemon(id, nombre, tipo);
                    System.out.println("Muestro:" + k);

                }
        }catch (IOException e){
            e.printStackTrace();
        }
/*       4-Reflexión: ¿mejoraría en algo usar ficheros binarios bien sea con
        DataOutputStream o con ObjectOutputStream (e Input) Razonad la
        respuesta.*/

        /*
         Dado que nuestra pokedex en este punto tiene poco contenido, no seria
         necesario dado que va bien y rapido al no pesar mucho, pero si en
         algun momento se va llenado de informacion, lo mas conveniente seria
          hacer los ficheros  binarios, dado que esto aporta una mejora de
          velocidad, eficiencia y rendimiento.
          Claro, todo esto si no nos importa, que no lo vayamos a poder leer
          directamente dado que seria ilegible para nosotros.

          Sacamos en conclusion que si mi programa fuera mas grande, si que deberia de
          hacer los ficheros binarios para una mayor eficiencia de los recursos,
          pero si no es necesario y con propierties o los archivos csv son suficiente.
         */
    }


}

