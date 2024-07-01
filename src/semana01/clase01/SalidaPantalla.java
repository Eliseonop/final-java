package semana01.clase01;

import java.util.Scanner;

public class SalidaPantalla {
    public static void main(String[] args) {
        int edad = 23;
        double numeroFavorito = 22;
        double talla = 1.70;
        String nombre = "Eliseo Edu Falcon Mestanza";
        String nacionalidad = "Peru";
        String mascota = "Scoot";

        int numeroFavoritoEntero = (int) numeroFavorito;

        System.out.println("\n\n Mi nombre es : " + nombre);
        System.out.println("Tengo de edad " + edad + "años");
        System.out.println("Hola de nuevo");
        System.out.println("\t Hola por tercera vez\n");
        System.out.println("Mi talla es :" + talla);
        System.out.printf("Mitall es en metros %.2f metros \n", talla);
        System.out.println("");



    }
}
