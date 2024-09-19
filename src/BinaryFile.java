import java.io.*;

public class BinaryFile {
    private static final String INPUT_BINARY_PATH = "C:\\Users\\diego\\OneDrive\\Documents\\Pruebas\\input.jpg";
    private static final String OUTPUT_BINARY_PATH = "C:\\Users\\diego\\OneDrive\\Documents\\Pruebas\\output.jpg";
    public static void execute() {
        byte[] inputBytes = readImage(INPUT_BINARY_PATH);

        if (inputBytes == null) {
            return;
        }
        if (writeImage(OUTPUT_BINARY_PATH, inputBytes)) {
            System.out.println("Se ha copiado el archivo correctamente");
        }

    }

    private static byte[] readImage(String path) {
        try (FileInputStream input = new FileInputStream(path)) {
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int bytes;

            while ((bytes = input.read(buffer)) != -1) {
                bo.write(buffer, 0, bytes);
            }
            return bo.toByteArray();
        } catch (Exception e) {
            System.out.println(e + " Error: no se ha podido leer el archivo de entrada.");
            return null;
        }
    }

    private static boolean writeImage(String path, byte[] bytes) {
        try (FileOutputStream fo = new FileOutputStream(path)) {
            fo.write(bytes);
            return true;
        } catch (Exception e) {
            System.out.println(e + " Error: no se ha podido crear la nueva imagen.");
            return false;
        }
    }
}
