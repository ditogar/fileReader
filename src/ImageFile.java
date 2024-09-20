import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageFile {
    private static final String INPUT_IMAGE_PATH = "/home/46948549y/Documents/Pruebas/imagen.jpg";
    private static final String OUTPUT_IMAGE_PATH = "/home/46948549y/Documents/Pruebas/image.jpg";
    public static void execute() {
        try {
            BufferedImage image = ImageIO.read(new File(INPUT_IMAGE_PATH));
            BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int rgb = image.getRGB(j, i);

                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                    int grayRGB = (gray << 16) | (gray << 8) | gray;

                    grayImage.setRGB(j, i, grayRGB);
                }
            }
            if (ImageIO.write(grayImage, "jpg", new File(OUTPUT_IMAGE_PATH))) {
                System.out.println("Se ha convertido la imagen correctamente a escala de grises.");
            }
        } catch (Exception e) {
            System.out.println(e + " Error: no se ha podido convertir la imagen correctamente.");
        }
    }
}