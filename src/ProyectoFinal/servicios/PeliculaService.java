package ProyectoFinal.servicios;

import ProyectoFinal.modelos.Pelicula;
import ProyectoFinal.modelos.Sala;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PeliculaService {
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private FileService<Pelicula> fileService;

    // Constructor
    public PeliculaService(List<Sala> salas) {
        this.salas = salas;
        this.fileService = new FileService<>("peliculas.txt", this::fromString, this::toString);
        try {
            this.peliculas = fileService.cargar();
        } catch (IOException e) {
            this.peliculas = new ArrayList<>();
        }
    }

    // Método para convertir de cadena a Pelicula
    private Pelicula fromString(String line) {
        String[] parts = line.split(",");
        String id = parts[0];
        String titulo = parts[1];
        String descripcion = parts[2];
        int duracion = Integer.parseInt(parts[3]);
        String genero = parts[4];
        String fechaLanzamiento = parts[5];
//        String salaId = parts[6];

        return new Pelicula(id, titulo, descripcion, duracion, genero, fechaLanzamiento);
    }

    public Pelicula obtenerPeliculaPorId(String id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId().equals(id)) {
                return pelicula;
            }
        }
        return null; // Pelicula no encontrada
    }

    public String generarId() {
        return this.peliculas.size() + 1 + "P";
    }

    // Método para convertir de Pelicula a cadena
    private String toString(Pelicula pelicula) {
        return String.join(",",
                pelicula.getId(),
                pelicula.getTitulo(),
                pelicula.getDescripcion(),
                String.valueOf(pelicula.getDuracion()),
                pelicula.getGenero(),
                pelicula.getFechaLanzamiento().toString());

    }

    public void agregarPelicula(String titulo, String descripcion, int duracion, String genero, String fechaLanzamiento) {
        String id = generarId();
        Pelicula nuevaPelicula = new Pelicula(id, titulo, descripcion, duracion, genero, fechaLanzamiento);
        peliculas.add(nuevaPelicula);
        guardarPeliculas();
    }

    public Pelicula obtenerPelicula(String titulo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }

    public List<Pelicula> listarPeliculas() {
        return new ArrayList<>(peliculas);
    }

    public List<Pelicula> obtenerPeliculasPorSala(String salaId) {
        return peliculas.stream()
                .filter(pelicula -> pelicula.getSala().getId().equalsIgnoreCase(salaId))
                .collect(Collectors.toList());
    }

    public boolean actualizarPelicula(String id, String nuevoTitulo, String descripcion, int duracion, String genero, String fechaLanzamiento) {
        Pelicula pelicula = obtenerPeliculaPorId(id);

        if (pelicula != null) {
            pelicula.actualizarPelicula(nuevoTitulo, descripcion, duracion, genero, fechaLanzamiento);
            guardarPeliculas();
            return true;
        }
        return false;
    }

    public boolean eliminarPelicula(String id) {
        Pelicula pelicula = obtenerPeliculaPorId(id);
        if (pelicula != null) {
            peliculas.remove(pelicula);
            guardarPeliculas();
            return true;
        }
        return false;
    }

    private void guardarPeliculas() {
        try {
            fileService.guardar(peliculas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarPeliculasTable() {
        List<Pelicula> peliculas = listarPeliculas();

        // Encabezado de la tabla
        String formato = "| %-5s | %-30s | %-50s | %-10s | %-10s | %-15s |%n";
        String separador = "+-------+--------------------------------+----------------------------------------------------+------------+------------+-----------------+%n";

        System.out.format(separador);
        System.out.format(formato, "ID", "Título", "Descripción", "Duración", "Género", "Fecha de lanzamiento");
        System.out.format(separador);

        for (Pelicula pelicula : peliculas) {
            System.out.format(formato,
                    pelicula.getId(),
                    pelicula.getTitulo(),
                    pelicula.getDescripcion(),
                    pelicula.getDuracion(),
                    pelicula.getGenero(),
                    pelicula.getFechaLanzamiento());
        }

    }
}
