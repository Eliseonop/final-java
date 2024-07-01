package participacion;

public class ReporteASCII {

    public static void main(String[] args) {
        String[][] asistencia = {
                {"P", "A", "P", "P"}, // Semana 1
                {"P", "P", "A", "P"}, // Semana 2
                {"A", "P", "P", "P"}, // Semana 3
                {"P", "A", "A", "P"}  // Semana 4
        };
        String[] semanas = {"Semana 1", "Semana 2", "Semana 3", "Semana 4"};
        String[] estudiantes = {"Estudiante 1", "Estudiante 2", "Estudiante 3", "Estudiante 4"};

        // Generar reporte ASCII
        System.out.println("Reporte de asistencia:");
        System.out.print("\t");
        for (String estudiante : estudiantes) {
            System.out.print(estudiante + "\t");
        }
        System.out.println();

        for (int i = 0; i < asistencia.length; i++) {
            System.out.print(semanas[i] + "\t");
            for (int j = 0; j < asistencia[i].length; j++) {
                System.out.print(asistencia[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
