package participacion;

public class MatricesVentas {
    public static void main(String[] args) {
        int[][] ventasMensuales = {
                {200, 300, 250, 400}, // Semana 1
                {150, 350, 300, 500}, // Semana 2
                {100, 200, 150, 300}, // Semana 3
                {400, 500, 450, 600}  // Semana 4
        };
        int[] sumaVentasDiarias = new int[ventasMensuales[0].length];
        int[] sumaVentasSemanales = new int[ventasMensuales.length];

        // Calcular la suma de ventas diarias y semanales
        for (int i = 0; i < ventasMensuales.length; i++) {
            for (int j = 0; j < ventasMensuales[i].length; j++) {
                sumaVentasSemanales[i] += ventasMensuales[i][j];
                sumaVentasDiarias[j] += ventasMensuales[i][j];
            }
        }

        // Mostrar los resultados
        System.out.println("Suma de ventas semanales:");
        for (int i = 0; i < sumaVentasSemanales.length; i++) {
            System.out.println("Semana " + (i + 1) + ": " + sumaVentasSemanales[i]);
        }

        System.out.println("Suma de ventas diarias:");
        for (int j = 0; j < sumaVentasDiarias.length; j++) {
            System.out.println("Día " + (j + 1) + ": " + sumaVentasDiarias[j]);
        }
    }
}
