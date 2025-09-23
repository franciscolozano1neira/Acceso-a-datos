import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializacionPokedex{
    public static void main(String[] args) {

        List<PokemonS> pokedex1 = new ArrayList<>();
        PokemonS Pikachu = new PokemonS(25, "Pikachu", "Eléctrico");
        PokemonS Charmander = new PokemonS(4, "Charmander", "fuego");
        PokemonS Bulbasaur = new PokemonS(1, "Bulbasaur", "Planta/Veneno");
        PokemonS Squirtle = new PokemonS(7, "Squirtle", "agua");

        pokedex1.add(new PokemonS(25, "Pikachu", "Eléctrico"));
        pokedex1.add(new PokemonS(4, "Charmander", "Fuego"));
        pokedex1.add(new PokemonS(7, "Squirtle", "Agua"));
        pokedex1.add(new PokemonS(1, "Bulbasaur", "Planta/Veneno"));

        try {ObjectOutputStream oes = new ObjectOutputStream
              (new FileOutputStream("pokedex.ser"));
         oes.writeObject(pokedex1);
            System.out.println("Pokédex serializada correctamente en pokedex.ser");
      } catch (IOException e) {
          e.printStackTrace();
      }

      try {ObjectInputStream olc = new ObjectInputStream
                  (new FileInputStream("pokedex.ser"));
          List<PokemonS> pokedexRecuperada = (List<PokemonS>) olc.readObject();
          System.out.println("Pokédex deserializada correctamente:");
          for (PokemonS p : pokedexRecuperada) {
              System.out.println(p);
           }
        } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
     }
    }
}
