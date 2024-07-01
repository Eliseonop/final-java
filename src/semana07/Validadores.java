package semana07;

import java.util.Scanner;

public class Validadores {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int option;
        boolean continuar = true;

        do {
            System.out.println("----- Menú -----");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            option = lectura.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Has elegido la opción 1");
                    continuar = false;
                    break;
                case 2:
                    System.out.println("Has elegido la opción 2");
                    continuar = false;
                    break;
                case 3:
                    System.out.println("Has elegido la opción 3");
                    continuar = false;
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
                    break;
            }
        } while (continuar);
    }
}
