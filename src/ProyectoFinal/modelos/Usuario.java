package ProyectoFinal.modelos;

import java.util.UUID;

public class Usuario {
    private String id;
    private String username;
    private String password;
    private String role;

    public Usuario(String username, String password, String role) {

        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

//    @Override
//    public String toString() {
//        return username + "," + password + "," + role;
//    }

}
