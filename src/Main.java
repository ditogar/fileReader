public class Main {
    public static void main(String[] args) {
        // Si no se han introducido argumentos
        if (args.length < 1) {
            System.out.println("No se han introducido opciones");
        } 
        // Si se introduce text
        else if (args[0].equalsIgnoreCase("text")){
            TextFile.execute();
        }
        // Si se introduce binary 
        else if (args[0].equalsIgnoreCase("binary")) {
            BinaryFile.execute();
        }
        System.exit(0);
    }    
}