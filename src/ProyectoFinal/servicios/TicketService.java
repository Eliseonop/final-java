package ProyectoFinal.servicios;

import ProyectoFinal.modelos.Ticket;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets;
    private FileService<Ticket> fileService;

    // Constructor
    public TicketService() {
        this.fileService = new FileService<>(
                "tickets.txt",
                this::fromString,
                this::toString
        );
        try {
            this.tickets = fileService.cargar();
        } catch (IOException e) {
            this.tickets = new ArrayList<>();
        }
    }

    // Método para convertir de cadena a Ticket
    private Ticket fromString(String line) {
        String[] parts = line.split(",");
        String id = parts[0];
        String funcionId = parts[1];
        String asiento = parts[4];
//        String salaId = parts[5];
        return new Ticket(id, funcionId, Integer.parseInt(asiento));
    }

    // Método para convertir de Ticket a cadena
    private String toString(Ticket ticket) {
        return String.join(",",
                ticket.getId(),
                ticket.getFuncionId(),
                String.valueOf(ticket.getAsiento())
        );
    }

    // Métodos de TicketService
    public void agregarTicket(String funcionId, int asiento
    ) {

        String id = generarId();

        Ticket nuevoTicket = new Ticket(id, funcionId, asiento);
        tickets.add(nuevoTicket);
        guardarTickets();
    }

    public String generarId() {
        return String.valueOf(tickets.size() + 1 + "T");
    }

    public List<Ticket> listarTickets() {
        return new ArrayList<>(tickets);
    }

    public Ticket obtenerTicketPorId(String id) {
        return tickets.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Ticket> obtenerTicketsPorFuncion(String funcionId) {
        return tickets.stream().filter(t -> t.getFuncionId().equals(funcionId)).toList();
    }


    private void guardarTickets() {
        try {
            fileService.guardar(tickets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
