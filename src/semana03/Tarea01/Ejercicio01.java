package semana03.Tarea01;

import java.util.Scanner;

public class Ejercicio01 {
    /*Escribir un programa que calcule el área de una figura geométrica cualquiera.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese la base del triángulo:");
        double base = scanner.nextDouble();

        System.out.println("Por favor, ingrese la altura del triángulo:");
        double altura = scanner.nextDouble();

        double area = (base * altura) / 2;

        System.out.println("El área del triángulo es: " + area);

        scanner.close();
    }
}
