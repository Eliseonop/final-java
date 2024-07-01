package ProyectoFinal.servicios;

import ProyectoFinal.modelos.Usuario;

import java.io.*;
import java.util.Scanner;

public class AuthService {
    private static final String FILE_NAME = "usuarios.txt";


    public void registrar(String username, String password, String role) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        writer.write(username + "," + password + "," + role);
        writer.newLine();
        writer.close();
    }

    public Usuario login(String username, String password) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_NAME));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts[0].equals(username) && parts[1].equals(password)) {
                return new Usuario(parts[0], parts[1], parts[2]);
            }
        }
        return null;
    }


}
