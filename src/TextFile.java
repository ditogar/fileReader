import java.io.*;

public class TextFile {
    private static final String INPUT_TEXT_PATH = "C:\\Users\\diego\\OneDrive\\Documents\\Pruebas\\input.txt";
    private static final String OUTPUT_TEXT_PATH = "C:\\Users\\diego\\OneDrive\\Documents\\Pruebas\\output.txt";
    public static void execute() {
        String text = readFile(INPUT_TEXT_PATH);
        if (text == null) {
            System.out.println("Error: No se ha podido leer el archivo input");
            return;
        }
        if (writeFile(OUTPUT_TEXT_PATH, text.toUpperCase())) {
            System.out.println("Se ha escrito el texto en mayúsculas correctamente en el archivo");
        }
    }

    private static String readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
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

    private static boolean writeFile(String path, String text) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Se ha creado un nuevo archivo " + path);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                bw.write(text);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e + " Error al intentar escribir en el archivo de salida.");
            return false;
        }
    }
}