package semana10;
import java.util.Date;
import java.util.Scanner;

public class Practica2 {
    static final int REQUERIMIENTOS = 20;
    static final String[] ESTADOS = {"Pendiente", "Desarrollo", "Pruebas", "Terminado"};

    static int[] numeros = new int[REQUERIMIENTOS];
    static String[] titulos = new String[REQUERIMIENTOS];
    static String[] responsables = new String[REQUERIMIENTOS];
    static String[] estados = new String[REQUERIMIENTOS];
    static int[] estimados = new int[REQUERIMIENTOS];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*--------------Mi Menu-----------------*");
            System.out.println("1. Registrar el requerimiento");
            System.out.println("2. Actualizar estado");
            System.out.println("3. Reporte de requerimientos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    registrarRequerimiento(lectura);
                    break;
                case 2:
                    actualizarEstado(lectura);
                    break;
                case 3:
                    reporteRequerimientos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        } while (opcion != 4);

        lectura.close();
    }

    public static void registrarRequerimiento(Scanner lectura) {
        if (contador >= REQUERIMIENTOS) {
            System.out.println("No se pueden registrar más requerimientos.");
            return;
        }

        System.out.print("Número de Requerimiento (tres dígitos): ");
        int numero = lectura.nextInt();
        lectura.nextLine();

        for (int i = 0; i < contador; i++) {
            if (numeros[i] == numero) {
                System.out.println("El número de requerimiento debe ser único.");
                return;
            }
        }

        System.out.print("Título: ");
        String titulo = lectura.nextLine();
        System.out.print("Responsable: ");
        String responsable = lectura.nextLine();
        System.out.print("Horas estimadas: ");
        int estimado = lectura.nextInt();
        lectura.nextLine();

        if (estimado <= 0) {
            System.out.println("Las horas estimadas deben ser mayores a cero.");
            return;
        }

        numeros[contador] = numero;
        titulos[contador] = titulo;
        responsables[contador] = responsable;
        estados[contador] = ESTADOS[0]; // Estado inicial "Pendiente"
        estimados[contador] = estimado;
        contador++;
        System.out.println("Requerimiento registrado correctamente.");
    }

    public static void actualizarEstado(Scanner lectura) {
        System.out.print("Número de Requerimiento a actualizar: ");
        int numero = lectura.nextInt();
        lectura.nextLine();

        int index = -1;
        for (int i = 0; i < contador; i++) {
            if (numeros[i] == numero) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Requerimiento no encontrado.");
            return;
        }

        System.out.println("Submenú:");
        System.out.println("2.1 Hacia Adelante");
        System.out.println("2.2 Hacia Atrás");
        System.out.println("2.3 Regresar al Menú principal");
        System.out.print("Seleccione una opción: ");
        String subopcion = lectura.nextLine();

        switch (subopcion) {
            case "2.1":
                avanzarEstado(index);
                break;
            case "2.2":
                retrocederEstado(index);
                break;
            case "2.3":
                System.out.println("Regresando al menú principal.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void avanzarEstado(int index) {
        int estadoActualIndex = -1;
        for (int i = 0; i < ESTADOS.length; i++) {
            if (estados[index].equals(ESTADOS[i])) {
                estadoActualIndex = i;
                break;
            }
        }

        if (estadoActualIndex == -1 || estadoActualIndex == ESTADOS.length - 1) {
            System.out.println("No se puede avanzar, el requerimiento ya está en el estado 'Terminado'.");
            return;
        }

        String estadoAnterior = estados[index];
        String estadoSiguiente = ESTADOS[estadoActualIndex + 1];
        System.out.println(estadoAnterior + " -> " + estadoSiguiente);

        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Confirma que desea pasar al estado '" + estadoSiguiente + "'? (S/N): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            estados[index] = estadoSiguiente;
            System.out.println("Estado actualizado correctamente.");
        } else {
            System.out.println("Actualización cancelada.");
        }
    }

    public static void retrocederEstado(int index) {
        int estadoActualIndex = -1;
        for (int i = 0; i < ESTADOS.length; i++) {
            if (estados[index].equals(ESTADOS[i])) {
                estadoActualIndex = i;
                break;
            }
        }

        if (estadoActualIndex == -1 || estadoActualIndex == 0) {
            System.out.println("No se puede retroceder, el requerimiento ya está en el estado 'Pendiente'.");
            return;
        }

        String estadoAnterior = ESTADOS[estadoActualIndex - 1];
        String estadoActual = estados[index];
        System.out.println(estadoAnterior + " <- " + estadoActual);

        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Confirma que desea regresar al estado '" + estadoAnterior + "'? (S/N): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            estados[index] = estadoAnterior;
            System.out.println("Estado actualizado correctamente.");
        } else {
            System.out.println("Actualización cancelada.");
        }
    }

    public static void reporteRequerimientos() {
        if (contador == 0) {
            System.out.println("No se tienen datos registrados.");
            return;
        }
        ordenarReportes();
        int[] indices = new int[contador];
        for (int i = 0; i < contador; i++) {
            indices[i] = i;
        }


        Date fechaActual = new Date();


        System.out.println("******************************************************");
        System.out.println("Future Development S.A.C.");
        System.out.println("www.futuredev123456.com.pe");
        System.out.println("Lima – Perú");
        System.out.println("******************************************************");
        System.out.printf("%nESTADO DE LOS REQUERIMIENTOS AL %1$tm/%1$td/%1$tY%n", fechaActual);
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-6s %-40s %-40s %-15s %s\n", "#Req.", "Título", "Responsable", "Estado", "Estimado");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (int i : indices) {
            System.out.printf("%-6d %-40s %-40s %-15s %d h\n", numeros[i], titulos[i], responsables[i], estados[i], estimados[i]);
        }
        System.out.println("******************************************************");
        System.out.println("\nRESUMEN:");
        System.out.println("Estado                                           Cantidad de Horas");
        System.out.println("------------------------------------------------------------------------");

        // Calcular el total de horas por estado
        int[] totalHorasPorEstado = new int[ESTADOS.length];
        for (int i = 0; i < contador; i++) {
            int estadoIndex = -1;
            for (int j = 0; j < ESTADOS.length; j++) {
                if (estados[i].equals(ESTADOS[j])) {
                    estadoIndex = j;
                    break;
                }
            }
            totalHorasPorEstado[estadoIndex] += estimados[i];
        }

        for (int i = 0; i < ESTADOS.length; i++) {
            System.out.printf("%-45s %d h\n", ESTADOS[i], totalHorasPorEstado[i]);
        }
        System.out.println("******************************************************");
    }

    public static void ordenarReportes() {
        boolean ordenado;
        do {
            ordenado = false;
            for (int i = 0; i < contador - 1; i++) {
                if (estimados[i] < estimados[i + 1]) {

                    int tempNum = numeros[i];
                    numeros[i] = numeros[i + 1];
                    numeros[i + 1] = tempNum;

                    String tempTitulo = titulos[i];
                    titulos[i] = titulos[i + 1];
                    titulos[i + 1] = tempTitulo;

                    String tempResponsable = responsables[i];
                    responsables[i] = responsables[i + 1];
                    responsables[i + 1] = tempResponsable;

                    String tempEstado = estados[i];
                    estados[i] = estados[i + 1];
                    estados[i + 1] = tempEstado;

                    int tempEstimado = estimados[i];
                    estimados[i] = estimados[i + 1];
                    estimados[i + 1] = tempEstimado;

                    ordenado = true;
                }
            }
        } while (ordenado);
    }
}
