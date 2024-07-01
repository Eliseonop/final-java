package semana8;

import java.util.Scanner;

public class ejercico1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre = "";
        String tipo = "";
        double salarioMensual = 0;
        int boletasEmitidas = 0;
        int mes = 0;
        boolean datosIngresados = false;

        while (true) {
            System.out.println("1. Ingresar nombre y tipo de empleado");
            System.out.println("2. Ingresar salario mensual, número de boletas emitidas y número de mes en curso");
            System.out.println("3. Elaborar el reporte ASCII");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    nombre = scanner.next();
                    System.out.print("Ingrese el tipo de empleado (contratado o nombrado): ");
                    tipo = scanner.next();
                    datosIngresados = true;
                    break;
                case 2:
                    System.out.print("Ingrese el salario mensual: ");
                    salarioMensual = scanner.nextDouble();
                    System.out.print("Ingrese el número de boletas emitidas: ");
                    boletasEmitidas = scanner.nextInt();
                    System.out.print("Ingrese el número de mes en curso: ");
                    mes = scanner.nextInt();
                    datosIngresados = true;
                    break;
                case 3:
                    if (!datosIngresados) {
                        System.out.println("Debe ingresar los datos del empleado primero.");
                    } else {
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Tipo: " + tipo);
                        System.out.println("Salario Mensual: " + salarioMensual);
                        System.out.println("Boletas Emitidas: " + boletasEmitidas);
                        System.out.println("Mes en Curso: " + mes);
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 4.");
                    break;
            }
        }
    }
}
