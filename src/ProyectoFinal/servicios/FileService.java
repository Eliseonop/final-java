package ProyectoFinal.servicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileService<T> {
    private final String fileName;
    private final Function<String, T> fromStringFunction;
    private final Function<T, String> toStringFunction;

    public FileService(String fileName, Function<String, T> fromStringFunction, Function<T, String> toStringFunction) {
        this.fileName = fileName;
        this.fromStringFunction = fromStringFunction;
        this.toStringFunction = toStringFunction;

        // Create the file if it does not exist
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Archivo creado: " + fileName);
            } else {
//                System.out.println("El archivo ya existe: " + fileName);
                System.out.println("leer archivo: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void guardar(List<T> items) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : items) {
                writer.write(toStringFunction.apply(item));
                writer.newLine();
            }
        }
    }

    public List<T> cargar() throws IOException {
        List<T> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(fromStringFunction.apply(line));
            }
        }
        return items;
    }
}
