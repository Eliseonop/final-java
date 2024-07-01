package semana01.Tarea01;

import java.util.Scanner;

public class ProblemaMatematico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el valor de a:");
        double a = scanner.nextDouble();

        System.out.println("Por favor, ingrese el valor de b:");
        double b = scanner.nextDouble();

        System.out.println("Por favor, ingrese el valor de c:");
        double c = scanner.nextDouble();


        double resultado = a * b + c;

        System.out.println("El resultado de la fórmula a * b + c es: " + resultado);

        scanner.close();
    }
}
