package semana03;

import java.util.Scanner;

public class clase01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el primer número:");
        int n1 = scanner.nextInt();

        System.out.println("Por favor, ingrese el segundo número:");
        int n2 = scanner.nextInt();

        System.out.println("Por favor, ingrese el tercer número:");
        int n3 = scanner.nextInt();

        if (n2 - n1 == n3 - n2) {
            System.out.println("Los números " + n1 + ", " + n2 + ", " + n3 + " están en progresión aritmética.");
        } else {
            System.out.println("Los números " + n1 + ", " + n2 + ", " + n3 + " no están en progresión aritmética.");
        }

        scanner.close();
    }
}
