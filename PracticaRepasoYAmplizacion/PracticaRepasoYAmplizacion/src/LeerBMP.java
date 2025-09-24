import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerBMP {
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile("Dibujo ejer2.bmp","rw");
       //rf.seek(18);
        rf.seek(22);
       // rf.seek(40);

        int width = Integer.reverse(rf.readInt()); // anchura
        int heigth = Integer.reverse(rf.readInt()); // altura

        System.out.println("El ancho es de: " + width+ " y el alto es: "+ heigth);

        rf.close();
    }
}
