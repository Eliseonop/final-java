package ProyectoFinal.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Funcion {
    private String id;
    private String peliculaId;
    private String salaId;
    private LocalDateTime fechaHora;
    private List<Ticket> tickets;

    // Constructor
    public Funcion(
            String id,
            String peliculaId, String salaId, LocalDateTime fechaHora) {
        this.id = id;
        this.peliculaId = peliculaId;
        this.salaId = salaId;
        this.fechaHora = fechaHora;
        this.tickets = new ArrayList<>();
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(String peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    // Método para agregar un ticket a la función
    public void agregarTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    // Método para actualizar los atributos de la función
    public void actualizarFuncion(String peliculaId, String salaId, LocalDateTime fechaHora) {
        this.peliculaId = peliculaId;
        this.salaId = salaId;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "id='" + id + '\'' +
                ", peliculaId='" + peliculaId + '\'' +
                ", salaId='" + salaId + '\'' +
                ", fechaHora=" + fechaHora +
                ", tickets=" + tickets +
                '}';
    }
}
