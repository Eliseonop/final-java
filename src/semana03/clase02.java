package semana03;

import java.util.Scanner;

public class clase02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el sexo del funcionario (femenino/masculino):");
        String sexo = scanner.nextLine().toLowerCase();

        System.out.println("Por favor, ingrese el sector del funcionario (salud/educacion/transporte):");
        String sector = scanner.nextLine().toLowerCase();

        double salarioActual;
        double porcentajeAumento;

        switch (sector) {
            case "salud":
                salarioActual = 15000;
                porcentajeAumento = (sexo.equals("femenino")) ? 0.25 : 0.20;
                break;
            case "educacion":
                salarioActual = 12000;
                porcentajeAumento = (sexo.equals("femenino")) ? 0.12 : 0.11;
                break;
            case "transporte":
                salarioActual = 18000;
                porcentajeAumento = (sexo.equals("femenino")) ? 0.20 : 0.15;
                break;
            default:
                System.out.println("Sector ingresado no es válido.");
                return;
        }

        double aumento = salarioActual * porcentajeAumento;
        double nuevoSalario = salarioActual + aumento;

        System.out.println("El salario actual es: " + salarioActual);
        System.out.println("El nuevo salario después del aumento es: " + nuevoSalario);

        scanner.close();
    }
}
