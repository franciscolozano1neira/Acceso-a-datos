import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AccesoPokedex {

    public static String Pokedex = "datos.bin";
    public static int size = 20;

    public static void main(String[] args){
        ArrayList<Integer> numPokemon = new ArrayList<>(size);

        File f1 = new File(Pokedex);
        // Aquí comprobaremos si el documento existe o no, después de la comprobación podremos leerlo o, en su defecto, crearlo
        if (f1.exists()) {
            // si existe, pasaremos a leerlo
            try (DataInputStream dis = new DataInputStream(new FileInputStream(f1))){
                for (int i = 0; i<size; i++){
                    numPokemon.add(dis.readInt());
                }
            } catch (IOException e) {
                System.err.println("Error leyendo: " + e.getMessage());
            }
        } else {
            // en caso de no exixtir, lo que haremos será crear uno con 20 ceros
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f1))) {
                for (int i = 0; i < size; i++) {
                    dos.writeInt(0);
                    numPokemon.add(0);
                }
            } catch (IOException e) {
                System.err.println("Error leyendo " + e.getMessage());
            }
        }
        // Y ahora configuramos el acceso aleatorio
        try (RandomAccessFile raf = new RandomAccessFile(Pokedex, "rwd");
        Scanner sc = new Scanner(System.in)){
            // Estructuralmente
            while (true){
                System.out.println("Contenido actual: ");
                for (int i=0; i<numPokemon.size(); i++){
                    System.out.println(numPokemon.get(i) + " ");
                }
                System.out.println();

                // por posición
                System.out.println("Introduce posicion a modificar (negativo para salir): ");
                int pos = sc.nextInt();
                if (pos < 0 || pos >= size){
                    System.out.println("Saliendo...");
                    break;
                }

                // nuevo valor
                System.out.println("Introduce nuevo valor: ");
                int nuevoValor = sc.nextInt();

                // actualización
                numPokemon.set(pos, nuevoValor);

                // actualizar solo esa posicion
                raf.seek(pos*4L);
                raf.writeInt(nuevoValor);
            }
        } catch (IOException e){
            System.err.println("Error en acceso " + e.getMessage());
        }
    }

}
