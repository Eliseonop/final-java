package semana03.Tarea01;

import java.util.Scanner;

public class Ejercicio03 {
    /*Escribir un programa que, dado un monto total, lo descomponga en monto a pagar e IGV (18%)*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el monto total:");
        double montoTotal = scanner.nextDouble();

        double igv = montoTotal * 0.18;
        double montoAPagar = montoTotal - igv;

        System.out.println("El monto a pagar es: " + montoAPagar);
        System.out.println("El IGV es: " + igv);

        scanner.close();

    }
}
