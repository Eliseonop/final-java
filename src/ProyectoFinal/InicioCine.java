package ProyectoFinal;

import ProyectoFinal.modelos.Sala;
import ProyectoFinal.modelos.Usuario;
import ProyectoFinal.servicios.*;
import ProyectoFinal.vistas.admin.PrincipalAdmin;
import ProyectoFinal.vistas.cliente.PrincipalCliente;

import java.io.IOException;
import java.util.Scanner;


public class InicioCine {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);
        SalaService salaService = new SalaService();
        PeliculaService peliculaService = new PeliculaService(salaService.listarSalas());
        FuncionService funcionService = new FuncionService(
                peliculaService,
                salaService
        );
        TicketService ticketService = new TicketService();


        while (true) {
            System.out.println("1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea

            if (opcion == 1) {
                System.out.print("Ingrese username: ");
                String username = scanner.nextLine();
                System.out.print("Ingrese password: ");
                String password = scanner.nextLine();
                System.out.print("Ingrese role (cliente/admin): ");
                String role = scanner.nextLine();

                try {
                    authService.registrar(username, password, role);
                    System.out.println("Usuario registrado exitosamente!");
                } catch (IOException e) {
                    System.out.println("Error al registrar usuario: " + e.getMessage());
                }

            } else if (opcion == 2) {
                System.out.print("Ingrese username: ");
                String username = scanner.nextLine();
                System.out.print("Ingrese password: ");
                String password = scanner.nextLine();

                try {
                    Usuario usuario = authService.login(username, password);
                    if (usuario != null) {
                        if (usuario.getRole().equals("admin")) {
                            System.out.println("Login exitoso! Usuario: " + usuario.getUsername() + " Rol: " + usuario.getRole());
//                            System.out.println("Funcionalidad de administrador no implementada.");
//                            continue;
                            PrincipalAdmin principalAdmin = new PrincipalAdmin(
                                    peliculaService,
                                    funcionService,
                                    salaService
                            );
                            principalAdmin.iniciar();


                        } else if (usuario.getRole().equals("cliente")) {
                            System.out.println("este es un cliente");
                            PrincipalCliente principalCliente = new PrincipalCliente(
                                    peliculaService,
                                    ticketService,
                                    funcionService,
                                    salaService
                            );
                            principalCliente.iniciar();
//                            System.out.println("Login exitoso! Usuario: " + usuario.getUsername() + " Rol: " + usuario.getRole());
                        } else {
                            System.out.println("Rol no válido.");
                            continue;
                        }
//                        System.out.println("Login exitoso! Usuario: " + usuario.getUsername() + " Rol: " + usuario.getRole());
//                        CineTicket cineTicket = new CineTicket();
//                        cineTicket.setUsuario(usuario);
//
//                        cineTicket.iniciar();

                    } else {
                        System.out.println("Login fallido. Usuario o contraseña incorrectos.");
                    }
                } catch (IOException e) {
                    System.out.println("Error al intentar iniciar sesión: " + e.getMessage());
                }

            } else if (opcion == 3) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
