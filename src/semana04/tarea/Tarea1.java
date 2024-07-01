package semana04.tarea;

import java.util.Scanner;

public class Tarea1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, elija la operación que desea realizar:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        short operacion = scanner.nextShort();


        System.out.println("Por favor, ingrese el primer número:");
        double num1 = scanner.nextDouble();

        System.out.println("Por favor, ingrese el segundo número:");
        double num2 = scanner.nextDouble();

        double resultado = 0;
//        Tarea1 tarea1 = new Tarea1();

        switch (operacion) {


            case 1:
                resultado = suma(num1, num2);
                break;
            case 2:
                resultado = resta(num1, num2);
                break;
            case 3:
                resultado = multiplicacion(num1, num2);
                break;
            case 4:
                resultado = division(num1, num2);
                break;
            default:
                System.out.println("Operación inválida");
                return;
        }

        System.out.println("El resultado es: " + resultado);

        scanner.close();
    }

    public static double suma(double num1, double num2) {
        return num1 + num2;
    }

    private static double resta(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    public static double division(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Error: División por cero");
            return 0;
        }
    }
}
