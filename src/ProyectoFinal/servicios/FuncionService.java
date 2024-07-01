package ProyectoFinal.servicios;

import ProyectoFinal.modelos.Funcion;
import ProyectoFinal.modelos.Pelicula;
import ProyectoFinal.modelos.Sala;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionService {
    private List<Funcion> funciones;
    private PeliculaService peliculaService;
    private SalaService salaService;
    private FileService<Funcion> fileService;

    // Constructor
    public FuncionService(PeliculaService peliculaService, SalaService salaService) {
        this.peliculaService = peliculaService;
        this.salaService = salaService;
        this.fileService = new FileService<>("funciones.txt", this::fromString, this::toString);
        try {
            this.funciones = fileService.cargar();
        } catch (IOException e) {
            this.funciones = new ArrayList<>();
        }
    }

    // Método para convertir de cadena a Funcion
    private Funcion fromString(String line) {
        String[] parts = line.split(",");
        String id = parts[0];
        String peliculaId = parts[1];
        String salaId = parts[2];
        LocalDateTime fechaHora = LocalDateTime.parse(parts[3]);

        return new Funcion(id, peliculaId, salaId, fechaHora);
    }

    // Método para convertir de Funcion a cadena
    private String toString(Funcion funcion) {
        return String.join(",",
                funcion.getId(),
                funcion.getPeliculaId(),
                funcion.getSalaId(),
                funcion.getFechaHora().toString());
    }


    public void agregarFuncion(String peliculaId, String salaId, LocalDateTime fechaHora) {
        Pelicula pelicula = peliculaService.obtenerPeliculaPorId(peliculaId);
        Sala sala = salaService.obtenerSalaPorId(salaId);
        String id = generarId();

        if (pelicula != null && sala != null) {
            Funcion nuevaFuncion = new Funcion(
                    id,
                    peliculaId, salaId, fechaHora);
            funciones.add(nuevaFuncion);
            guardarFunciones();
        } else {
            System.out.println("Error: Película o sala no encontrada.");
        }
    }

    public Funcion obtenerFuncionPorId(String id) {
        for (Funcion funcion : funciones) {
            if (funcion.getId().equals(id)) {
                return funcion;
            }
        }
        return null;
    }

    public String generarId() {
        return this.funciones.size() + 1 + "F";
    }

    public List<Funcion> listarFunciones() {
        return new ArrayList<>(funciones);
    }

    public List<Funcion> obtenerFuncionesPorPelicula(String peliculaId) {
        return funciones.stream()
                .filter(funcion -> funcion.getPeliculaId().equals(peliculaId))
                .collect(Collectors.toList());
    }

    public boolean actualizarFuncion(String id, String peliculaId, String salaId, LocalDateTime fechaHora) {
        Pelicula pelicula = peliculaService.obtenerPeliculaPorId(peliculaId);
        Sala sala = salaService.obtenerSalaPorId(salaId);
        Funcion funcion = obtenerFuncionPorId(id);

        if (pelicula != null && sala != null && funcion != null) {
            funcion.setPeliculaId(peliculaId);
            funcion.setSalaId(salaId);
            funcion.setFechaHora(fechaHora);
            guardarFunciones();
            return true;
        }
        return false;
    }

    public boolean eliminarFuncion(String id) {
        Funcion funcion = obtenerFuncionPorId(id);
        if (funcion != null) {
            funciones.remove(funcion);
            guardarFunciones();
            return true;
        }
        return false;
    }

    private void guardarFunciones() {
        try {
            fileService.guardar(funciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarFuncionesTable() {
        List<Funcion> funciones = listarFunciones();
        String format = "|%1$-5s|%2$-15s|%3$-15s|%4$-20s|\n";
        String separador = "+-----+---------------+---------------+----------------------+\n";
        System.out.println(separador);
        System.out.printf(format, "ID", "Pelicula", "Sala", "Fecha y Hora");
        System.out.println(separador);
        for (Funcion funcion : funciones) {
            Pelicula pelicula = peliculaService.obtenerPeliculaPorId(funcion.getPeliculaId());
            Sala sala = salaService.obtenerSalaPorId(funcion.getSalaId());
            System.out.printf(format, funcion.getId(), pelicula.getTitulo(), sala.getNombre(), funcion.getFechaHora());
        }

        System.out.println(separador);

    }
}
