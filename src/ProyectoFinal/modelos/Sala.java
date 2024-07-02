package ProyectoFinal.modelos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sala {
    private String id;
    private String nombre;
    private int capacidad;
    private String tipo;

    // Constructor
    public Sala(String id, String nombre, int capacidad, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para actualizar los atributos de la sala
    public void actualizarSala(String nombre, int capacidad, String tipo) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    // Método para generar la representación ASCII de la sala
    public void imprimirMapaAsientos(List<Ticket> tickets) {
        Set<Integer> asientosOcupados = tickets.stream()
                .map(Ticket::getAsiento)
                .collect(Collectors.toSet());

        String formatoPantallaSoutheast = "%1$-10s";
        int columnas = (int) Math.sqrt(capacidad);
        int filas = (int) Math.ceil((double) capacidad / columnas);

        String colRepeatGuion = new String(new char[columnas * 6]).replace("\0", "-");

        System.out.printf(formatoPantallaSoutheast, colRepeatGuion + "[PANTALLA]" + colRepeatGuion + "\n");


        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numeroAsiento = i * columnas + j + 1;
                if (numeroAsiento > capacidad) break;
                if (asientosOcupados.contains(numeroAsiento)) {
                    System.out.printf("   [%2d:❌]   ", numeroAsiento);
                } else {
                    System.out.printf("   [%2d:✔️]   ", numeroAsiento);
                }
                if (j < columnas - 1) {
                    System.out.print("|");
                }
            }
            if (i < filas - 1 && i * columnas + columnas < capacidad) {
                System.out.print("\n");
                for (int k = 0; k < columnas; k++) {
                    System.out.print("-------------+");
//                    if (k < columnas - 1) {
//                        System.out.print("+");
//                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
