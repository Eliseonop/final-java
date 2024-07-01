package ProyectoFinal.vistas.admin;

import ProyectoFinal.modelos.Pelicula;
import ProyectoFinal.modelos.Funcion;
import ProyectoFinal.modelos.Sala;
import ProyectoFinal.servicios.PeliculaService;
import ProyectoFinal.servicios.FuncionService;
import ProyectoFinal.servicios.SalaService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrincipalAdmin {
    private PeliculaService peliculaService;
    private FuncionService funcionService;
    private SalaService salaService;
    private Scanner scanner;

    public PrincipalAdmin(PeliculaService peliculaService, FuncionService funcionService, SalaService salaService) {
        this.peliculaService = peliculaService;
        this.funcionService = funcionService;
        this.salaService = salaService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("\nMenú Principal - Administrador");
            System.out.println("1. Gestionar Películas");
            System.out.println("2. Gestionar Funciones");
            System.out.println("3. Gestionar Salas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    gestionarPeliculas();
                    break;
                case 2:
                    gestionarFunciones();
                    break;
                case 3:
                    gestionarSalas();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }


    private void gestionarPeliculas() {
        while (true) {
            System.out.println("\nGestionar Películas");
            System.out.println("1. Agregar Película");
            System.out.println("2. Actualizar Película");
            System.out.println("3. Eliminar Película");
            System.out.println("4. Listar Películas");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    actualizarPelicula();
                    break;
                case 3:
                    eliminarPelicula();
                    break;
                case 4:
                    peliculaService.listarPeliculasTable();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }


    private void agregarPelicula() {
        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese la descripción de la película: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la duración de la película (en minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el género de la película: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese la fecha de lanzamiento de la película (YYYY-MM-DD): ");
        String fechaLanzamientoStr = scanner.nextLine();


        peliculaService.agregarPelicula(titulo, descripcion, duracion, genero, fechaLanzamientoStr);
        System.out.println("Película agregada con éxito.");
    }


    private void actualizarPelicula() {

        peliculaService.listarPeliculasTable();

        System.out.print("Ingrese el Id de la película a actualizar: ");
        String id = scanner.nextLine();

        Pelicula pelicula = peliculaService.obtenerPeliculaPorId(id);

        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        Map<String, Object> data = new HashMap<>();

        data.put("id", pelicula.getId());
        data.put("titulo", pelicula.getTitulo());
        data.put("descripcion", pelicula.getDescripcion());
        data.put("duracion", pelicula.getDuracion());
        data.put("genero", pelicula.getGenero());
        data.put("fechaLanzamiento", pelicula.getFechaLanzamiento());

        System.out.print("Ingrese el nuevo título de la película: ");
        String nuevoTitulo = scanner.nextLine();
        if (!nuevoTitulo.isEmpty()) {
            data.put("titulo", nuevoTitulo);
        }
        System.out.print("Ingrese la nueva descripción de la película: ");
        String descripcion = scanner.nextLine();
        if (!descripcion.isEmpty()) {
            data.put("descripcion", descripcion);
        }
        System.out.print("Ingrese la nueva duración de la película (en minutos): ");
        int duracion = scanner.nextInt();
        if (duracion != 0) {
            data.put("duracion", duracion);
        }
        scanner.nextLine();
        System.out.print("Ingrese el nuevo género de la película: ");
        String genero = scanner.nextLine();

        if (!genero.isEmpty()) {
            data.put("genero", genero);
        }
        System.out.print("Ingrese la nueva fecha de lanzamiento de la película (YYYY-MM-DD): ");
        String fechaLanzamientoStr = scanner.nextLine();

        if (!fechaLanzamientoStr.isEmpty()) {
            data.put("fechaLanzamiento", fechaLanzamientoStr);
        }

        // Listar salas disponibles
        listarSalas();
        do {
            System.out.print("Ingrese el nuevo ID de la sala: ");
            String salaId = scanner.nextLine();
            Sala sala = salaService.obtenerSalaPorId(salaId);
            if (sala != null) {
                data.put("salaId", salaId);
                break;
            } else {
                System.out.println("Sala no encontrada.");
            }
        } while (true);


        boolean actualizado = peliculaService.actualizarPelicula(
                id,
                (String) data.get("titulo"),
                (String) data.get("descripcion"),
                (int) data.get("duracion"),
                (String) data.get("genero"),
                (String) data.get("fechaLanzamiento")
        );
        if (actualizado) {
            System.out.println("Película actualizada con éxito.");
        } else {
            System.out.println("Película no encontrada.");
        }
    }


    private void eliminarPelicula() {
        System.out.print("Ingrese el título de la película a eliminar: ");
        String titulo = scanner.nextLine();
        boolean eliminado = peliculaService.eliminarPelicula(titulo);
        if (eliminado) {
            System.out.println("Película eliminada con éxito.");
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    private void gestionarFunciones() {
        while (true) {
            System.out.println("\nGestionar Funciones");
            System.out.println("1. Agregar Función");
            System.out.println("2. Actualizar Función");
            System.out.println("3. Eliminar Función");
            System.out.println("4. Listar Funciones");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarFuncion();
                    break;
                case 2:
                    actualizarFuncion();
                    break;
                case 3:
                    eliminarFuncion();
                    break;
                case 4:
                    listarFunciones();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void actualizarFuncion() {
        listarFunciones();
        System.out.println("Ingrese el ID de la función a actualizar:");
        String id = scanner.nextLine();
        Funcion funcion = funcionService.obtenerFuncionPorId(id);
        if (funcion == null) {
            System.out.println("Función no encontrada.");
            return;
        }
        Map<String, Object> data = new HashMap<>();


    }


    private void agregarFuncion() {
        // Listar películas disponibles
        peliculaService.listarPeliculasTable();
        System.out.print("Ingrese el ID de la película para la función: ");
        String peliculaId = scanner.nextLine();
        Pelicula pelicula = peliculaService.obtenerPeliculaPorId(peliculaId);
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        // Listar salas disponibles
        listarSalas();
        System.out.print("Ingrese el ID de la sala: ");
        String salaId = scanner.nextLine();
        Sala sala = salaService.obtenerSalaPorId(salaId);
        if (sala == null) {
            System.out.println("Sala no encontrada.");
            return;
        }

        System.out.print("Ingrese la fecha de la función (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        System.out.print("Ingrese la hora de la función (HH:mm): ");
        String horaStr = scanner.nextLine();
        LocalDateTime fechaHora = LocalDateTime.parse(fechaStr + "T" + horaStr);

        funcionService.agregarFuncion(pelicula.getId(), sala.getId(), fechaHora);
        System.out.println("Función agregada con éxito.");
    }


    private void eliminarFuncion() {
        listarFunciones();

        System.out.print("Ingrese el ID de la función a eliminar: ");

        String id = scanner.nextLine();
        boolean eliminado = funcionService.eliminarFuncion(id);
        if (eliminado) {
            System.out.println("Función eliminada con éxito.");
        } else {
            System.out.println("Función no encontrada.");
        }

    }

    private void listarFunciones() {
        List<Funcion> funciones = funcionService.listarFunciones();
        String formato = "| %-30s | %-30s | %-20s |%n";
        String separador = "+--------------------------------+--------------------------------+----------------------+";

        System.out.println(separador);
        System.out.printf(formato, "Película", "Sala", "Fecha y Hora");
        System.out.println(separador);

        for (Funcion funcion : funciones) {
            Pelicula pelicula = peliculaService.obtenerPeliculaPorId(funcion.getPeliculaId());
            Sala sala = salaService.obtenerSalaPorId(funcion.getSalaId());
            System.out.printf(formato, pelicula.getTitulo(), sala.getNombre(), funcion.getFechaHora());
        }

        System.out.println(separador);
    }

    private void gestionarSalas() {
        while (true) {
            System.out.println("\nGestionar Salas");
            System.out.println("1. Agregar Sala");
            System.out.println("2. Actualizar Sala");
            System.out.println("3. Eliminar Sala");
            System.out.println("4. Listar Salas");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarSala();
                    break;
                case 2:
                    actualizarSala();
                    break;
                case 3:
                    eliminarSala();
                    break;
                case 4:
                    listarSalas();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void agregarSala() {
        System.out.print("Ingrese el nombre de la sala: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la capacidad de la sala: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el tipo de proyección de la sala: ");
        String tipoProyeccion = scanner.nextLine();

        salaService.agregarSala(nombre, capacidad, tipoProyeccion);
        System.out.println("Sala agregada con éxito.");
    }

    private void actualizarSala() {
        System.out.print("Ingrese el nombre de la sala a actualizar: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre de la sala: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese la nueva capacidad de la sala: ");
        int nuevaCapacidad = scanner.nextInt();
        scanner.nextLine();

        boolean actualizado = salaService.actualizarSala(nombre, nuevoNombre, nuevaCapacidad);
        if (actualizado) {
            System.out.println("Sala actualizada con éxito.");
        } else {
            System.out.println("Sala no encontrada.");
        }
    }

    private void eliminarSala() {
        System.out.print("Ingrese el nombre de la sala a eliminar: ");
        String nombre = scanner.nextLine();
        boolean eliminado = salaService.eliminarSala(nombre);
        if (eliminado) {
            System.out.println("Sala eliminada con éxito.");
        } else {
            System.out.println("Sala no encontrada.");
        }
    }

    private void listarSalas() {
        List<Sala> salas = salaService.listarSalas();

        String formato = "| %-10s | %-30s | %-10s | %-15s |%n";
        String separador = "+------------+--------------------------------+------------+-----------------+";

        System.out.println(separador);
        System.out.printf(formato, "ID", "Nombre", "Capacidad", "Tipo Proyección");
        System.out.println(separador);

        for (Sala sala : salas) {
            System.out.printf(formato, sala.getId(), sala.getNombre(), sala.getCapacidad(), sala.getTipo());
        }
    }
}
