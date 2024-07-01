package participacion;


import java.util.Arrays;

public class Ejercicio2Examen {
    public static void main(String[] args) {
        int[][] calificaciones = {
                {75, 85, 95}, // Estudiante 1
                {65, 70, 80}, // Estudiante 2
                {90, 60, 70}  // Estudiante 3
        };


        for (int i = 0; i < calificaciones.length; i++) {
            Arrays.sort(calificaciones[i]);
        }

        // Mostrar calificaciones ordenadas por estudiante
        System.out.println("Calificaciones ordenadas por estudiante:");
        for (int[] fila : calificaciones) {
            System.out.println(Arrays.toString(fila));
        }

        // Ordenar cada columna (por calificaciones en cada materia)
        for (int j = 0; j < calificaciones[0].length; j++) {
            int[] columna = new int[calificaciones.length];
            for (int i = 0; i < calificaciones.length; i++) {
                columna[i] = calificaciones[i][j];
            }
            Arrays.sort(columna);
            for (int i = 0; i < calificaciones.length; i++) {
                calificaciones[i][j] = columna[i];
            }
        }

        // Mostrar calificaciones ordenadas por materia
        System.out.println("Calificaciones ordenadas por materia:");
        for (int[] fila : calificaciones) {
            System.out.println(Arrays.toString(fila));
        }
    }
}
