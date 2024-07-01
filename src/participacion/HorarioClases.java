package participacion;

public class HorarioClases {

    public static void main(String[] args) {
        String[][] horario = {{"Matemáticas", "Ciencias", "Historia"}, {"Inglés", "Educación Física", "Arte"}, {"Geografía", "Música", "Biología"}};

        // Generar reporte ASCII
        System.out.println("Horario de clases:");
        for (int i = 0; i < horario.length; i++) {
            for (int j = 0; j < horario[i].length; j++) {
                System.out.print(horario[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
