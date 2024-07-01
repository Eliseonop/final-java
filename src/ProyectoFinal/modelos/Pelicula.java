package ProyectoFinal.modelos;


public class Pelicula {
    private String id;
    private String titulo;
    private String descripcion;
    private int duracion; // Duración en minutos
    private String genero;
    private String fechaLanzamiento;
    private Sala sala;

    // Constructor
    public Pelicula(
            String id,
            String titulo, String descripcion, int duracion, String genero, String fechaLanzamiento) {

        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getId() {
        return id;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }


    // Método para actualizar los atributos de la película
    public void actualizarPelicula(String titulo, String descripcion, int duracion, String genero, String fechaLanzamiento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;

    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion +
                ", genero='" + genero + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", sala='" + sala.getNombre() + '\'' +
                '}';
    }


}
