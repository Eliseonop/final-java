package semana03.Tarea01;

import java.util.Scanner;

public class Ejercicio02 {
    /*Escribir un programa que resuelva una formula matemática que utilice al menos 3 variables.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SUMA DE TRES NUMEROS");

        System.out.println("Por favor, ingrese el primer número:");
        double num1 = scanner.nextDouble();

        System.out.println("Por favor, ingrese el segundo número:");
        double num2 = scanner.nextDouble();

        System.out.println("Por favor, ingrese el tercer número:");
        double num3 = scanner.nextDouble();

        double suma = num1 + num2 + num3;

        System.out.println("La suma de los tres números es: " + suma);

        scanner.close();
    }
}
