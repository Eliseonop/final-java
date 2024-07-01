package semana05.examen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.println("Ingrese el nombre del empleado:");
            String nombre = entrada.nextLine().toUpperCase();

            System.out.println("Ingrese el cargo del empleado:");
            String cargo = entrada.nextLine();

            System.out.println("Ingrese el número de identificación interno del empleado:");
            String id = entrada.nextLine();

            System.out.println("Ingrese el correo electrónico del empleado:");
            String email = entrada.nextLine();

            System.out.println("Ingrese el número de celular del empleado:");
            String celular = entrada.nextLine();

            System.out.println("Ingrese el género del empleado: \n1. Masculino \n2. Femenino");
            char genero = entrada.nextInt() == 1 ? 'M' : 'F';

            System.out.println("Ingrese el estado civil del empleado: \n1. Soltero \n2. Casado");
            String estadoCivil = entrada.nextInt() == 1 ? "soltero" : "casado";

            System.out.println("¿El empleado tiene un préstamo de la compañía? \n1. Si \n2. No");
            String tienePrestamo = entrada.nextInt() == 1 ? "S" : "N";

            System.out.println("Ingrese el salario mensual del empleado:");
            double salarioMensual = entrada.nextDouble();


            int diasVencimiento = 0;
            if (tienePrestamo.equalsIgnoreCase("S")) {
                System.out.println("Ingrese el número de días para el vencimiento de la siguiente cuota:");
                diasVencimiento = entrada.nextInt();
            }

            String nivelSalarial;
            if (salarioMensual >= 10000) {
                nivelSalarial = "A+";
            } else if (salarioMensual >= 8000) {
                nivelSalarial = "A";
            } else if (salarioMensual >= 5000) {
                nivelSalarial = "B";
            } else {
                nivelSalarial = "C";
            }

            String mensajeVencimiento = "";
            if (diasVencimiento <= 0) {
                mensajeVencimiento = "***** ATENCIÓN *****\n\nSU CUOTA VENCIÓ, COMUNIQUESE CON RRHH";
            } else if (diasVencimiento <= 5) {
                mensajeVencimiento = "*** ATENCIÓN ***\n\n" + diasVencimiento + " DÍAS PARA EL VENCIMIENTO DE SU CUOTA";
            } else if (diasVencimiento <= 10) {
                mensajeVencimiento = diasVencimiento + " DÍAS PARA EL VENCIMIENTO DE SU CUOTA";
            } else if (diasVencimiento <= 15) {
                mensajeVencimiento = diasVencimiento + " días para el vencimiento de su cuota";
            }

            String titulo;
            if (genero == 'M') {
                titulo = estadoCivil.equalsIgnoreCase("casado") ? "SR." : "SR.";
            } else {
                titulo = estadoCivil.equalsIgnoreCase("casado") ? "SRA." : "SRTA.";
            }

            System.out.println("\n\nSW Factory S.A.C.\n\nwww.swfactory123456.com.pe\n\ncontacto@swfactory123456.com.pe\n\nJesús María, Lima - Perú\n\n“Building the future”\n\n");
            System.out.println("---------------------------------------------------------------------\n\n");
            System.out.println(titulo + " " + nombre + "\n\n" + cargo + "\n\n");
            System.out.println("Id: " + id + "\n\nEmail: " + email + "\n\nCelular: " + celular + "\n\nNivel Salarial: " + nivelSalarial + "\n\n");
            System.out.println("---------------------------------------------------------------------\n\n");
            System.out.println(mensajeVencimiento);
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada incorrecta. Saliendo del programa.");
            System.exit(1);
        }
    }


}
