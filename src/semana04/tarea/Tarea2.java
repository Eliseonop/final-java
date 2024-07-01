package semana04.tarea;

import java.util.Scanner;

public class Tarea2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //No se puedo hacer que el tipo de cliente sea de tipo char ya ue tiene mas
        // de 1 caracter

        System.out.println("Por favor, ingrese el tipo de cliente:");
        String tipoCliente = scanner.next().toUpperCase();

        String descuento;

        switch (tipoCliente) {
            case "A++" -> descuento = "20%";
            case "A+", "A" -> descuento = "15%";
            case "B+", "B" -> descuento = "10%";
            case "C+", "C" -> descuento = "8%";
            default -> descuento = "Tipo de cliente no reconocido";
        }

        System.out.println("El descuento en la siguiente compra es: " + descuento);

        scanner.close();
    }
}
