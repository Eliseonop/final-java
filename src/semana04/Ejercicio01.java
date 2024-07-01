package semana04;


import java.util.Scanner;


public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese la puntuación del candidato:");
        int puntuacion = scanner.nextInt();

        String categoria;

        if (puntuacion >= 0 && puntuacion <= 4) {
            categoria = "descartado";
        } else if (puntuacion == 5) {
            categoria = "en suspenso";
        } else if (puntuacion == 6) {
            categoria = "aceptable";
        } else if (puntuacion == 7 || puntuacion == 8) {
            categoria = "notable";
        } else if (puntuacion == 9 || puntuacion == 10) {
            categoria = "sobresaliente";
        } else {
            categoria = "puntuación inválida";
        }

        switch (categoria) {
            case "descartado":
                System.out.println("El candidato ha sido descartado");
                break;
            case "en suspenso":
                System.out.println("El candidato está en suspenso");
                break;
            case "aceptable":
                System.out.println("El candidato es aceptable");
                break;
            case "notable":
                System.out.println("El candidato es notable");
                break;
            case "sobresaliente":
                System.out.println("El candidato es sobresaliente");
                break;
            default:
                System.out.println("La puntuación es inválida");
                break;
        }

        scanner.close();
    }
}

