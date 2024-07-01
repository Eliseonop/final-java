package ProyectoFinal.modelos;

import java.time.LocalDateTime;


public class Ticket {
    private String id;
    private String tituloPelicula;

    private LocalDateTime fechaHoraFuncion;
    private String asiento;
    private String salaId;
    private Sala sala;

    // Constructor
    public Ticket(String id, String tituloPelicula, LocalDateTime fechaHoraFuncion, String asiento,
                  String salaId) {

        this.id = id;
        this.tituloPelicula = tituloPelicula;
        this.fechaHoraFuncion = fechaHoraFuncion;
        this.asiento = asiento;
        this.salaId = salaId;

    }

    // Getters y Setters
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }


    public void setFechaHoraFuncion(LocalDateTime fechaHoraFuncion) {
        this.fechaHoraFuncion = fechaHoraFuncion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    // Método para actualizar los atributos del ticket
    public void actualizarTicket(String tituloPelicula, LocalDateTime fechaHoraFuncion, String asiento, String salaId) {
        this.tituloPelicula = tituloPelicula;
        this.fechaHoraFuncion = fechaHoraFuncion;
        this.asiento = asiento;
        this.salaId = salaId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", tituloPelicula='" + tituloPelicula + '\'' +
                ", nombreSala='" + sala.getNombre() + '\'' +
                ", fechaHoraFuncion=" + fechaHoraFuncion +
                ", asiento='" + asiento + '\'' +
                '}';
    }
}
