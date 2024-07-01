package semana05.examen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
    public static double suma(List<Double> numeros) {
        return numeros.stream().reduce(0.0, Double::sum);
    }

    public static double resta(List<Double> numeros) {
        return numeros.stream().reduce(0.0, (a, b) -> a - b);
    }

    public static double elevarAlCuadrado(double numero) {
        return Math.pow(numero, 2);
    }

    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("División por cero");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {


            System.out.println("Ingrese la cantidad de números con los que trabajará:");
            int cantidad = scanner.nextInt();

            List<Double> numeros = new ArrayList<>();
            for (int i = 0; i < cantidad; i++) {
                System.out.println("Ingrese el número " + (i + 1) + ":");
                numeros.add(scanner.nextDouble());
            }

            System.out.println("Elija una operación:");
            System.out.println("1. Mostrar la suma de los números");
            System.out.println("2. Mostrar la resta de los números");
            System.out.println("3. Elevar al cuadrado la suma o resta de los números");
            System.out.println("4. Dividir la suma de los números entre la resta de estos");

            int operacion = scanner.nextInt();
            double resultado;

            switch (operacion) {
                case 1 -> resultado = suma(numeros);
                case 2 -> resultado = resta(numeros);
                case 3 -> {
                    System.out.println("Elija una operación para elevar al cuadrado:");
                    System.out.println("1. Suma de los números");
                    System.out.println("2. Resta de los números");
                    int operacionCuadrado = scanner.nextInt();
                    resultado = switch (operacionCuadrado) {
                        case 1 -> elevarAlCuadrado(suma(numeros));
                        case 2 -> elevarAlCuadrado(resta(numeros));
                        default -> throw new IllegalStateException("Operación inválida: " + operacionCuadrado);
                    };
                }
                case 4 -> {
                    double suma = suma(numeros);
                    double resta = resta(numeros);
                    if (resta == 0) {
                        System.out.println("Error: División por cero");
                        return;
                    }
                    resultado = dividir(suma, resta);
                }
                default -> throw new IllegalStateException("Operación inválida: " + operacion);
            }

            System.out.printf("El resultado es: %.2f%n", resultado);
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada incorrecta. Saliendo del programa.");
            System.exit(1);
        }
    }
}
