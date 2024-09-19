import java.io.*;

public class TextInput {
    public static void execute() {
        String inputPath = "";
        String outputPath = "";

        String text = readFile(inputPath);
    }

    private static String readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e + " Error al intentar leer el archivo de entrada.");
            return null;
        }
    }

    private static void writeFile(String path, String text) {
        File file = new File(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Se ha creado un nuevo archivo " +  path);
            }
        } catch (Exception e) {
            System.out.println(e + " Error al intentar escribir en el archivo de salida.");
        }
    }
}