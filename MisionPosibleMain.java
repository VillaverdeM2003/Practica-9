import java.util.Scanner;

public class MisionPosibleMain {
    public static void main(String[] args) {
        Escenario e = new Escenario("Nostromo");

        
        String nombreArchivo = "ConfiguraciónInicial.txt";
        e.cargarElementos(nombreArchivo);

        System.out.println("Estado inicial del escenario:");
        System.out.println(e);

        try (
        Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese la posición (renglon columna) de la bomba a detonar: ");
            int renglon = scanner.nextInt();
            int columna = scanner.nextInt();
            Elemento elemento = e.campoDeBatalla[renglon][columna];

            if (elemento instanceof Bomba) {
                ((Bomba) elemento).explotar();
            } else {
                System.out.println("No hay una bomba en esa posición.");
            }
        }

        
        System.out.println("Estado del escenario después de la detonación:");
        System.out.println(e);

     
        e.guardarEstadoActual(nombreArchivo);
        System.out.println("El estado actual se ha guardado en " + nombreArchivo);
    }

}
