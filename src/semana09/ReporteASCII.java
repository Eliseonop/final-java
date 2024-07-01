package semana09;

public class ReporteASCII {
    public static void main(String[] args) {
        String[] nombres = {"JUAN CARLOS GARCIA RODRIGUEZ",
                "ANA MARIELA TORRES MONTEZ",
                "ROSA IÑONAN FARRO",
                "CARLOS ALBERTO ROJAS CHAN",
                "GABRIELA LUCIA ALVITES CH"};
        int[] edades = {19, 25, 22, 24, 25};
        char[] grado = {'5','5','4','5','5'};
        int[] PC1 = {20, 20, 20, 16, 20};
        int[] PC2 = {19, 17, 18, 18, 20};
        int[] PC3 = {15, 18, 12, 15, 14};
        int[] EF = {17, 16, 13, 12, 15};
        double PF=0.0f;
        double PF_Total = 0.0f;

        String separador = String.format("%65s", "").replace(" ", "#");
        System.out.println(separador);
        System.out.printf("%-30s%3s%3s%5s%5s%5s%5s%5s\n", "NOMBRE","ED", "GR", "PC1", "PC2", "PC3", "EF", "PF");
        System.out.println(separador);
        for(int i=0;i< nombres.length;i++){
            PF = (double) (PC1[i] +  PC2[i] +  PC3[i] + EF[i]) / 4;
            System.out.printf("%-30s%3d%3s%5d%5d%5d%5d%8.2f\n",nombres[i], edades[i], grado[i], PC1[i], PC2[i], PC3[i], EF[i], PF);
        }
        System.out.println(separador);
        System.out.println("PROMEDIO TOTAL:");
        System.out.println(separador);

    }
}
