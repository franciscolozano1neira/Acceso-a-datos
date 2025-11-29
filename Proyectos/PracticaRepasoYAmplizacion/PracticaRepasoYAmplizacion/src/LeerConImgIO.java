import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class LeerConImgIO {
    public static void main(String[] args) throws Exception {
        BufferedImage img = ImageIO.read(new File("Dibujo ejer2.bmp"));
        System.out.println("Ancho: " + img.getWidth() + ", Alto: " + img.getHeight());
    }
}

