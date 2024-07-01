package semana03.Tarea01;

import java.util.Scanner;

public class Ejercicio04 {
    /*Implementar un programa en Java que permita convertir dólares a soles (tipo de cambio: 3.48)​
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese la cantidad en dolares:");
        double dolares = scanner.nextDouble();

        double soles = dolares * 3.48;

        System.out.println("La cantidad en soles es: " + soles);

        scanner.close();
    }
}
