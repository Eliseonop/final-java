package semana03;

public class Ejercicio02 {
    public static void main(String[] args) {
        int varUno = 15;
        int varDos = 20;
        int varTres = 25;
        int max = Maximo(varUno, varDos, varTres);

        System.out.println("El número máximo es: " + max);

    }

    public static int Maximo(int numA, int numB, int numC) {
        if (numA >= numB && numA >= numC) {
            return numA;
        } else if (numB >= numA && numB >= numC) {
            return numB;
        } else {
            return numC;
        }
    }
}
