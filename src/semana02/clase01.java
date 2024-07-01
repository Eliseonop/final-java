package semana02;

public class clase01 {
    public static void main(String[] args) {
        int segundosPorMinuto = 60;
        int minutosPorHora = 60;
        int horasPorDia = 24;

        int segundosPorDia = segundosPorMinuto * minutosPorHora * horasPorDia;

        System.out.println("Un día tiene " + segundosPorDia + " segundos.");
    }
}
