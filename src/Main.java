import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
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

    private static String writeFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

        } catch (Exception e) {
            System.out.println(e + " Error al intentar escribir en el archivo de salida.");
        }
    }
}