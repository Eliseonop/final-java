package semana01.Tarea01;

import java.util.Scanner;

public class MontoIGV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el monto total:");
        double montoTotal = scanner.nextDouble();

        double montoAPagar = montoTotal / 1.18;
        double igv = montoTotal - montoAPagar;

        System.out.println("El monto a pagar es: " + montoAPagar);
        System.out.println("El IGV es: " + igv);

        scanner.close();
    }

}
