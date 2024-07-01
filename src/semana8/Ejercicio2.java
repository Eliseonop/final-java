package semana8;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entero positivo: ");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("El número ingresado no es un entero positivo.");
            return;
        }

        int num1 = 0, num2 = 1, suma = 0;

        System.out.println("Los primeros " + N + " números de la serie Fibonacci son:");

        for (int i = 1; i <= N; ++i) {
            System.out.println(num1);

            // Sumar el número actual a la suma
            suma += num1;

            // Calcular el próximo número de la serie
            int nextNum = num1 + num2;
            num1 = num2;
            num2 = nextNum;
        }

        System.out.println("La suma de los números es: " + suma);
    }
}
