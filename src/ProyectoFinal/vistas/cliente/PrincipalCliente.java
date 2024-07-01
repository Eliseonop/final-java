package ProyectoFinal.vistas.cliente;

import ProyectoFinal.modelos.Pelicula;
import ProyectoFinal.modelos.Funcion;
import ProyectoFinal.modelos.Ticket;
import ProyectoFinal.servicios.PeliculaService;
import ProyectoFinal.servicios.FuncionService;
import ProyectoFinal.servicios.TicketService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class PrincipalCliente {
    private PeliculaService peliculaService;
    private TicketService ticketService;
    private FuncionService funcionService;
    private Scanner scanner;

    public PrincipalCliente(PeliculaService peliculaService, TicketService ticketService, FuncionService funcionService) {
        this.peliculaService = peliculaService;
        this.ticketService = ticketService;
        this.funcionService = funcionService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("\nMenú Principal - Cliente");
            System.out.println("1. Ver Cartelera");
            System.out.println("2. Comprar Entradas");
            System.out.println("3. Ver Historial de Compras");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    verCartelera();
                    break;
                case 2:
                    comprarEntradas();
                    break;
                case 3:
                    verHistorialCompras();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void verCartelera() {
        List<Pelicula> peliculas = peliculaService.listarPeliculas();
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }


    private void comprarEntradas() {
        System.out.println("Comprar Entradas - Seleccionar Película");
        verCartelera();
        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();
        Pelicula pelicula = peliculaService.obtenerPelicula(titulo);
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        System.out.println("Seleccione la función:");
        List<Funcion> funciones = funcionService.obtenerFuncionesPorPelicula(titulo);
        for (int i = 0; i < funciones.size(); i++) {
            System.out.println((i + 1) + ". " + funciones.get(i));
        }
        int indiceFuncion = scanner.nextInt();
        scanner.nextLine();
        if (indiceFuncion < 1 || indiceFuncion > funciones.size()) {
            System.out.println("Función no válida.");
            return;
        }
        Funcion funcion = funciones.get(indiceFuncion - 1);

        System.out.print("Ingrese el asiento: ");
        String asiento = scanner.nextLine();
        String id = String.valueOf(System.currentTimeMillis());
//        ticketService.agregarTicket(id, titulo, funcion.getSala().getNombre(), funcion.getFechaHora(), asiento);
        System.out.println("Compra realizada con éxito.");
    }

    private void verHistorialCompras() {
        List<Ticket> tickets = ticketService.listarTickets();
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
