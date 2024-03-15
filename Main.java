import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public Main(){
        Ubicacion ubicacion0 = new Ubicacion(0, "Estás sentado en la clase de programación");
        Ubicacion ubicacion1 = new Ubicacion(1, "Estás en la cima de una montaña");
        Ubicacion ubicacion2 = new Ubicacion(2, "Estás bañándote en la playa");
        Ubicacion ubicacion3 = new Ubicacion(3, "Estás dentro de un edificio muy alto");
        Ubicacion ubicacion4 = new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion ubicacion5 = new Ubicacion(5, "Estás en un bosque");

        ubicaciones.put(0, ubicacion0);
        ubicaciones.put(1, ubicacion1);
        ubicaciones.put(2, ubicacion2);
        ubicaciones.put(3, ubicacion3);
        ubicaciones.put(4, ubicacion4);
        ubicaciones.put(5, ubicacion5);

        ubicacion1.addExit("N", 5);
        ubicacion1.addExit("S", 0);
        ubicacion1.addExit("E", 2);
        ubicacion1.addExit("O", 4);
        ubicacion1.addExit("Q", 0);

        ubicacion2.addExit("O", 1);
        ubicacion2.addExit("Q", 0);

        ubicacion3.addExit("S", 0);
        ubicacion3.addExit("Q", 0);

        ubicacion4.addExit("E", 1);
        ubicacion4.addExit("Q", 0);

        ubicacion5.addExit("S", 1);
        ubicacion5.addExit("O", 3);
        ubicacion5.addExit("Q", 0);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        int ubicacionActual = 1;

        while (true) {
            Ubicacion ubicacion = ubicaciones.get(ubicacionActual);
            System.out.println(ubicacion.getDescripcion());
            System.out.print("Tus salidas válidas son: ");

            for (String direccion : ubicacion.getExits().keySet()) {
                System.out.print(direccion + ", ");
            }
            System.out.println();
            System.out.print("INPUT: ");
            String direccionElegida = scanner.nextLine().toUpperCase();
            if (ubicacion.getExits().containsKey(direccionElegida)) {
                ubicacionActual = ubicacion.getExits().get(direccionElegida);
            } else if (direccionElegida.equals("Q")) {
                break;
            } else {
                System.out.println("No puede ir en esa dirección.");
            }
        }

        System.out.println("¡Gracias por jugar!");
    }

    public static void main(String[] args) {
        Main juego = new Main();
        juego.playGame();
    }
}