package ProyectoFinal.modelos;

import java.time.LocalDateTime;


public class Ticket {
    private String id;
//    private String peliculaId;

    //    private LocalDateTime fechaHoraFuncion;
    private int asiento;
    private String funcionId;
    private String igv;
    private Funcion funcion;

    // Constructor
    public Ticket(String id, String funcionId, int asiento
    ) {

        this.id = id;
        this.funcionId = funcionId;
        this.asiento = asiento;


    }

    // Getters y Setters
    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }


    public String getFuncionId() {
        return funcionId;
    }

    public void setFuncionId(String funcionId) {
        this.funcionId = funcionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    // Método para actualizar los atributos del ticket
    public void actualizarTicket(String peliculaId, int asiento) {
        this.funcionId = peliculaId;
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", tituloPelicula='" + funcion.getPelicula().getTitulo() + '\'' +
                ", nombreSala='" + funcion.getSala().getNombre() + '\'' +
                ", fechaHoraFuncion=" + funcion.getFechaHora() +
                ", asiento='" + asiento + '\'' +
                '}';
    }
}
