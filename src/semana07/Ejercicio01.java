package semana07;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        boolean continuar;

        do {

            System.out.println("========== PARA HACER LAS OPERACIONES ========");

            System.out.print("Ingrese un número: ");
            int numero = lectura.nextInt();
            System.out.println("========== MENU ========");

            System.out.println("Elija una operación:");
            System.out.println("1. Determinar si el número es primo");
            System.out.println("2. Calcular el factorial del número");
            int operacion = lectura.nextInt();

            switch (operacion) {
                case 1:
                    if (esPrimo(numero)) {
                        System.out.println("El número " + numero + " es primo.");
                    } else {
                        System.out.println("El número " + numero + " no es primo.");
                    }
                    break;
                case 2:
                    System.out.println("El factorial de " + numero + " es " + factorial(numero) + ".");
                    break;
                default:
                    System.out.println("Operación no válida. Por favor, elige 1 o 2.");
                    break;
            }

            System.out.print("¿Desea continuar operando? (SI / NO): ");
            continuar = lectura.next().toUpperCase().equalsIgnoreCase("NO");

        } while (!continuar);

    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int factorial(int numero) {
        int resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static int factorialRecursivo(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }

}
