package ProyectoFinal.servicios;

import ProyectoFinal.modelos.Sala;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalaService {
    private List<Sala> salas;
    private FileService<Sala> fileService;

    public SalaService() {
        this.fileService = new FileService<>(
                "salas.txt",
                this::fromString,
                this::toString
        );
        try {
            this.salas = fileService.cargar();
        } catch (IOException e) {
            this.salas = new ArrayList<>();
        }
    }

    // Método para convertir de cadena a Sala
    private Sala fromString(String line) {


        String[] parts = line.split(",");
        String id = parts[0];
        String nombre = parts[1];
        int capacidad = Integer.parseInt(parts[2]);
        String tipoProyeccion = parts[3];
        return new Sala(id, nombre, capacidad, tipoProyeccion);
    }


    public String generarId() {
        return this.salas.size() + 1 + "S";
    }

    // Método para convertir de Sala a cadena
    private String toString(Sala sala) {
        return String.join(",",
                sala.getId(),
                sala.getNombre(),
                String.valueOf(sala.getCapacidad()),
                sala.getTipo()
        );
    }

    public Sala obtenerSalaPorId(String id) {
        for (Sala sala : salas) {
            if (sala.getId().equals(id)) {
                return sala;
            }
        }
        return null; // Sala no encontrada
    }

    public void agregarSala(String nombre, int capacidad, String tipoProyeccion) {

        String id = generarId();

        Sala nuevaSala = new Sala(id, nombre, capacidad, tipoProyeccion);
        salas.add(nuevaSala);
        guardarSalas();
    }

    public Sala obtenerSala(String nombre) {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombre)) {
                return sala;
            }
        }
        return null; // Sala no encontrada
    }

    public List<Sala> listarSalas() {
        return new ArrayList<>(salas);
    }

    public boolean actualizarSala(String nombre, String nuevoNombre, int nuevaCapacidad) {
        Sala sala = obtenerSala(nombre);
        if (sala != null) {
            sala.setNombre(nuevoNombre);
            sala.setCapacidad(nuevaCapacidad);
            guardarSalas();
            return true;
        }
        return false; // Sala no encontrada
    }

    public boolean eliminarSala(String nombre) {
        Sala sala = obtenerSala(nombre);
        if (sala != null) {
            salas.remove(sala);
            guardarSalas();
            return true;
        }
        return false; // Sala no encontrada
    }

    private void guardarSalas() {
        try {
            fileService.guardar(salas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarSalasTable() {
        List<Sala> salas = listarSalas();
        String format = "%-5s%-20s%-10s%-20s%n";
        String separador = "-".repeat(55);
        System.out.println(separador);
        System.out.printf(format, "ID", "Nombre", "Capacidad", "Tipo de proyección");
        System.out.println(separador);
        for (Sala sala : salas) {
            System.out.printf(format, sala.getId(), sala.getNombre(), sala.getCapacidad(), sala.getTipo());
        }
        System.out.println(separador);


    }
}
