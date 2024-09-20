import java.io.*;

public class BinaryFile {
    private static final String INPUT_BINARY_PATH = "/home/46948549y/Documents/Pruebas/input.png";
    private static final String OUTPUT_BINARY_PATH = "/home/46948549y/Documents/Pruebas/output.png";
    public static void execute() {
        byte[] inputBytes = readBinary();

        if (inputBytes == null) {
            return;
        }
        if (writeBinary(inputBytes)) {
            System.out.println("Se ha copiado el archivo correctamente");
        }
    }

    private static byte[] readBinary() {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(INPUT_BINARY_PATH))) {
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

    private static boolean writeBinary(byte[] bytes) {
        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(OUTPUT_BINARY_PATH))) {
            output.write(bytes);
            return true;
        } catch (Exception e) {
            System.out.println(e + " Error: no se ha podido crear la nueva imagen.");
            return false;
        }
    }
}
