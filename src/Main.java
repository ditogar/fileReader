public class Main {
    public static void main(String[] args) {
        // Si no se han introducido argumentos
        if (args.length < 1) {
            System.out.println("No se han introducido opciones");
        } 
        // Si se introduce text
        else if (args[0].toString().toLowerCase().equals("text")){
            TextInput.execute();
        }
        // Si se introduce binary 
        else if (args[0].toString().toLowerCase().equals("binary")) {

        }
        System.exit(0);
    }    
}