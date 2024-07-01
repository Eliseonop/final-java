package participacion;

import java.util.Arrays;

public class EjercicioComparacion {
    public static void main(String[] args) {
        int[][] inventario1 = {
                {10, 20, 30},
                {15, 25, 35},
                {20, 30, 40}
        };
        int[][] inventario2 = new int[inventario1.length][inventario1[0].length];

        // Copiar el inventario1 a inventario2
        for (int i = 0; i < inventario1.length; i++) {
            for (int j = 0; j < inventario1[i].length; j++) {
                inventario2[i][j] = inventario1[i][j];
            }
        }

        boolean sonIguales = true;
        for (int i = 0; i < inventario1.length; i++) {
            if (!Arrays.equals(inventario1[i], inventario2[i])) {
                sonIguales = false;
                break;
            }
        }

        System.out.println("Inventario 1:");
        for (int[] fila : inventario1) {
            System.out.println(Arrays.toString(fila));
        }

        System.out.println("Inventario 2:");
        for (int[] fila : inventario2) {
            System.out.println(Arrays.toString(fila));
        }

        System.out.println("¿Son iguales los inventarios? " + sonIguales);
    }
}
