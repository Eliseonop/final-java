package ProyectoFinal.vistas.cliente;

import ProyectoFinal.modelos.Pelicula;
import ProyectoFinal.modelos.Funcion;
import ProyectoFinal.modelos.Sala;
import ProyectoFinal.modelos.Ticket;
import ProyectoFinal.servicios.PeliculaService;
import ProyectoFinal.servicios.FuncionService;
import ProyectoFinal.servicios.SalaService;
import ProyectoFinal.servicios.TicketService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class PrincipalCliente {
    private PeliculaService peliculaService;
    private TicketService ticketService;
    private FuncionService funcionService;
    private SalaService salaService;
    private Scanner scanner;

    public PrincipalCliente(PeliculaService peliculaService, TicketService ticketService, FuncionService funcionService, SalaService salaService) {
        this.peliculaService = peliculaService;
        this.ticketService = ticketService;
        this.funcionService = funcionService;
        this.salaService = salaService;
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
        funcionService.listarFuncionesTable();
//        for (Pelicula pelicula : peliculas) {
//            System.out.println(pelicula);
//        }
    }


    private void comprarEntradas() {
        System.out.println("Comprar Entradas - Seleccionar Película");
        peliculaService.listarPeliculasTable();
        System.out.print("Ingrese el ID de la película: ");
        String id = scanner.nextLine();
        Pelicula pelicula = peliculaService.obtenerPeliculaPorId(id);
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        System.out.println("Seleccione la función:");
        funcionService.funcionesPorPeliculaIdTable(id);
//        for (int i = 0; i < funciones.size(); i++) {
//            System.out.println((i + 1) + ". " + funciones.get(i));
//        }

        System.out.print("Ingrese el ID de la función: ");

        String indiceFuncion = scanner.nextLine();
//        scanner.nextLine();
        Funcion funcion = funcionService.obtenerFuncionPorId(indiceFuncion);
        if (funcion == null) {
            System.out.println("Función no encontrada.");
            return;
        }

        Sala sala = salaService.obtenerSalaPorId(funcion.getSalaId());

        if (sala == null) {
            System.out.println("Sala no encontrada.");
            return;
        }
        funcion.setSala(sala);

        List<Ticket> listaTickets = ticketService.obtenerTicketsPorFuncion(funcion.getId());

        funcion.setTickets(listaTickets);

        funcion.getSala().imprimirMapaAsientos(funcion.getTickets());


        System.out.print("Ingrese el asiento: ");
        int asiento = scanner.nextInt();

        for (Ticket ticket : listaTickets) {
            if (ticket.getAsiento() == asiento) {
                System.out.println("Asiento ocupado.");
                return;
            }
        }

        ticketService.agregarTicket(funcion.getId(), asiento);

        System.out.println("¡Compra exitosa!");


    }

    private void verHistorialCompras() {
        List<Ticket> tickets = ticketService.listarTickets();
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
