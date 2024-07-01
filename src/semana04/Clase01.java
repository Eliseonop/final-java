package semana04;

import java.util.Scanner;

public class Clase01 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);

        System.out.println("Por favor, ingrese la nota del 0 al 10:");
        int nota = leerDatos.nextInt();

        switch (nota) {
            case 0, 1, 2:
                System.out.println("Necesita reforzamiento");
                break;
            case 3:
            case 4:
                System.out.println("Desaprobado");
                break;
            case 5:
            case 6:
            case 7:
                System.out.println("Aprobado");
                break;
            case 8:
            case 9:
                System.out.println("Excelente");
                break;
            case 10:
                System.out.println("Becado");
                break;
            default:
                System.out.println("Nota no es válida");
                break;
        }

        leerDatos.close();
    }
}
