import java.io.*;

public class TextFile {
    private static final String INPUT_TEXT_PATH = "/home/46948549y/Documents/Pruebas/input.txt";
    private static final String OUTPUT_TEXT_PATH = "/home/46948549y/Documents/Pruebas/output.txt";
    public static void execute() {
        String text = readFile();
        if (text == null) {
            System.out.println("Error: No se ha podido leer el archivo input");
            return;
        }
        if (writeFile(text.toUpperCase())) {
            System.out.println("Se ha escrito el texto en mayúsculas correctamente en el archivo");
        }
    }

    private static String readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_TEXT_PATH))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e + " Error al intentar leer el archivo de entrada.");
            return null;
        }
    }

    private static boolean writeFile(String text) {
        File file = new File(OUTPUT_TEXT_PATH);
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Se ha creado un nuevo archivo " + OUTPUT_TEXT_PATH);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write(text);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e + " Error al intentar escribir en el archivo de salida.");
            return false;
        }
    }
}