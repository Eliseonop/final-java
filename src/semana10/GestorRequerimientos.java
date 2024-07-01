package semana10;


import java.util.Date;
import java.util.Scanner;

public class GestorRequerimientos {
    static final int MAX_REQUERIMIENTOS = 20;
    static final String[] ESTADOS_REQUERIMIENTO = {"Pendiente", "Desarrollo", "Pruebas", "Terminado"};

    static int[] idRequerimientos = new int[MAX_REQUERIMIENTOS];
    static String[] titulosRequerimientos = new String[MAX_REQUERIMIENTOS];
    static String[] responsablesRequerimientos = new String[MAX_REQUERIMIENTOS];
    static String[] estadosRequerimientos = new String[MAX_REQUERIMIENTOS];
    static int[] horasEstimadas = new int[MAX_REQUERIMIENTOS];
    static int totalRequerimientos = 0;

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = lectura.nextInt();
            lectura.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarRequerimiento(lectura);
                    break;
                case 2:
                    actualizarEstadoRequerimiento(lectura);
                    break;
                case 3:
                    generarReporteRequerimientos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        lectura.close();
    }

    public static void mostrarMenu() {
        System.out.println("*Menú PrincipalCliente*");
        System.out.println("1. Registrar Requerimiento");
        System.out.println("2. Actualizar Estado");
        System.out.println("3. Reporte de Requerimientos");
        System.out.println("4. Salir");
    }

    public static void registrarRequerimiento(Scanner lectura) {
        if (totalRequerimientos >= MAX_REQUERIMIENTOS) {
            System.out.println("No se pueden registrar más requerimientos.");
            return;
        }

        System.out.print("Número de Requerimiento (tres dígitos): ");
        int numero = lectura.nextInt();
        lectura.nextLine(); // Limpiar el buffer

        if (existeRequerimiento(numero)) {
            System.out.println("El número de requerimiento debe ser único.");
            return;
        }

        System.out.print("Título: ");
        String titulo = lectura.nextLine();
        System.out.print("Responsable: ");
        String responsable = lectura.nextLine();
        System.out.print("Horas estimadas: ");
        int estimado = lectura.nextInt();
        lectura.nextLine(); // Limpiar el buffer

        if (estimado <= 0) {
            System.out.println("Las horas estimadas deben ser mayores a cero.");
            return;
        }

        idRequerimientos[totalRequerimientos] = numero;
        titulosRequerimientos[totalRequerimientos] = titulo;
        responsablesRequerimientos[totalRequerimientos] = responsable;
        estadosRequerimientos[totalRequerimientos] = ESTADOS_REQUERIMIENTO[0]; // Estado inicial "Pendiente"
        horasEstimadas[totalRequerimientos] = estimado;
        totalRequerimientos++;
        System.out.println("Requerimiento registrado correctamente.");
    }

    public static boolean existeRequerimiento(int numero) {
        for (int i = 0; i < totalRequerimientos; i++) {
            if (idRequerimientos[i] == numero) {
                return true;
            }
        }
        return false;
    }

    public static void actualizarEstadoRequerimiento(Scanner scanner) {
        System.out.print("Número de Requerimiento a actualizar: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        int indice = buscarRequerimiento(numero);
        if (indice == -1) {
            System.out.println("Requerimiento no encontrado.");
            return;
        }

        mostrarSubMenu();
        String subopcion = scanner.nextLine();

        switch (subopcion) {
            case "1":
                avanzarEstado(indice, scanner);
                break;
            case "2":
                retrocederEstado(indice, scanner);
                break;
            case "3":
                System.out.println("Regresando al menú principal.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void mostrarSubMenu() {
        System.out.println("Submenú:");
        System.out.println("1. Avanzar Estado");
        System.out.println("2. Retroceder Estado");
        System.out.println("3. Regresar al Menú principal");
        System.out.print("Seleccione una opción: ");
    }

    public static int buscarRequerimiento(int numero) {
        for (int i = 0; i < totalRequerimientos; i++) {
            if (idRequerimientos[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public static void avanzarEstado(int indice, Scanner scanner) {
        int estadoActualIndice = obtenerIndiceEstado(estadosRequerimientos[indice]);
        if (estadoActualIndice == -1 || estadoActualIndice == ESTADOS_REQUERIMIENTO.length - 1) {
            System.out.println("No se puede avanzar, el requerimiento ya está en el estado 'Terminado'.");
            return;
        }

        String estadoSiguiente = ESTADOS_REQUERIMIENTO[estadoActualIndice + 1];
        confirmarCambioEstado(estadosRequerimientos[indice], estadoSiguiente, scanner, () -> {
            estadosRequerimientos[indice] = estadoSiguiente;
            System.out.println("Estado actualizado correctamente.");
        });
    }

    public static void retrocederEstado(int indice, Scanner scanner) {
        int estadoActualIndice = obtenerIndiceEstado(estadosRequerimientos[indice]);
        if (estadoActualIndice == -1 || estadoActualIndice == 0) {
            System.out.println("No se puede retroceder, el requerimiento ya está en el estado 'Pendiente'.");
            return;
        }

        String estadoAnterior = ESTADOS_REQUERIMIENTO[estadoActualIndice - 1];
        confirmarCambioEstado(estadosRequerimientos[indice], estadoAnterior, scanner, () -> {
            estadosRequerimientos[indice] = estadoAnterior;
            System.out.println("Estado actualizado correctamente.");
        });
    }

    public static int obtenerIndiceEstado(String estado) {
        for (int i = 0; i < ESTADOS_REQUERIMIENTO.length; i++) {
            if (ESTADOS_REQUERIMIENTO[i].equals(estado)) {
                return i;
            }
        }
        return -1;
    }

    public static void confirmarCambioEstado(String estadoActual, String nuevoEstado, Scanner scanner, Runnable actualizarEstado) {
        System.out.println(estadoActual + " -> " + nuevoEstado);
        System.out.print("¿Confirma que desea cambiar al estado '" + nuevoEstado + "'? (S/N): ");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("S")) {
            actualizarEstado.run();
        } else {
            System.out.println("Actualización cancelada.");
        }
    }

    public static void generarReporteRequerimientos() {
        if (totalRequerimientos == 0) {
            System.out.println("No se tienen datos registrados.");
            return;
        }

        ordenarRequerimientosPorEstimacion();
        Date fechaActual = new Date();

        imprimirEncabezadoReporte(fechaActual);
        imprimirRequerimientos();
        imprimirResumen();
    }

    public static void ordenarRequerimientosPorEstimacion() {
        boolean ordenado;
        do {
            ordenado = false;
            for (int i = 0; i < totalRequerimientos - 1; i++) {
                if (horasEstimadas[i] < horasEstimadas[i + 1]) {
                    intercambiarRequerimientos(i, i + 1);
                    ordenado = true;
                }
            }
        } while (ordenado);
    }

    public static void intercambiarRequerimientos(int i, int j) {
        int tempNum = idRequerimientos[i];
        idRequerimientos[i] = idRequerimientos[j];
        idRequerimientos[j] = tempNum;

        String tempTitulo = titulosRequerimientos[i];
        titulosRequerimientos[i] = titulosRequerimientos[j];
        titulosRequerimientos[j] = tempTitulo;

        String tempResponsable = responsablesRequerimientos[i];
        responsablesRequerimientos[i] = responsablesRequerimientos[j];
        responsablesRequerimientos[j] = tempResponsable;

        String tempEstado = estadosRequerimientos[i];
        estadosRequerimientos[i] = estadosRequerimientos[j];
        estadosRequerimientos[j] = tempEstado;

        int tempEstimado = horasEstimadas[i];
        horasEstimadas[i] = horasEstimadas[j];
        horasEstimadas[j] = tempEstimado;
    }

    public static void imprimirEncabezadoReporte(Date fechaActual) {
        System.out.println("******************************************************");
        System.out.println("Future Development S.A.C.");
        System.out.println("www.futuredev123456.com.pe");
        System.out.println("Lima – Perú");
        System.out.println("******************************************************");
        System.out.printf("%nESTADO DE LOS REQUERIMIENTOS AL %1$tm/%1$td/%1$tY%n", fechaActual);
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-6s %-40s %-40s %-15s %s\n", "#Req.", "Título", "Responsable", "Estado", "Estimado");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }

    public static void imprimirRequerimientos() {
        for (int i = 0; i < totalRequerimientos; i++) {
            System.out.printf("%-6d %-40s %-40s %-15s %d h\n", idRequerimientos[i], titulosRequerimientos[i], responsablesRequerimientos[i], estadosRequerimientos[i], horasEstimadas[i]);
        }
        System.out.println("******************************************************");
    }

    public static void imprimirResumen() {
        System.out.println("\nRESUMEN:");
        System.out.println("Estado                                           Cantidad de Horas");
        System.out.println("------------------------------------------------------------------------");

        int[] totalHorasPorEstado = new int[ESTADOS_REQUERIMIENTO.length];
        for (int i = 0; i < totalRequerimientos; i++) {
            int estadoIndex = obtenerIndiceEstado(estadosRequerimientos[i]);
            totalHorasPorEstado[estadoIndex] += horasEstimadas[i];
        }

        for (int i = 0; i < ESTADOS_REQUERIMIENTO.length; i++) {
            System.out.printf("%-45s %d h\n", ESTADOS_REQUERIMIENTO[i], totalHorasPorEstado[i]);
        }
        System.out.println("******************************************************");
    }
}
