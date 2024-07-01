package ProyectoFinal;

import ProyectoFinal.modelos.Usuario;

import java.util.Scanner;

public class CineTicket {

    private Usuario usuario;
    private String[] peliculas = {"Pelicula 1", "Pelicula 2", "Pelicula 3"};

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private void listarPeliculas() {
        System.out.println("=== Listado de Películas ===");
        for (int i = 0; i < peliculas.length; i++) {
            System.out.println((i + 1) + ". " + peliculas[i]);
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Sistema de Venta de Tickets para Cines ===");
            System.out.println("1. Listar películas");
            System.out.println("2. Gestión de Butacas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    listarPeliculas();
                    break;
                case 2:
                    gestionDeButacas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void gestionDeButacas() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Gestión de Butacas ===");
            System.out.println("1. Mostrar Butacas");
            System.out.println("2. Reservar Butaca");
            System.out.println("3. Liberar Butaca");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    mostrarButacas();
                    break;
                case 2:
                    // Implementar la funcionalidad de reservar butaca
                    break;
                case 3:
                    // Implementar la funcionalidad de liberar butaca
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (option != 0);
    }

    private static void mostrarButacas() {
        char[][] butacas = new char[20][20];

        // Inicializar todas las butacas como libres
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                butacas[i][j] = 'L'; // L representa una butaca libre
            }
        }

        // Imprimir las butacas
        System.out.println("Pantalla del cine");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(butacas[i][j] + " ");
            }
            System.out.println();
        }
    }


}
