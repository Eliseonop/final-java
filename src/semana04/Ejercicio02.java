package semana04;

import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tasaDolar = 3.82;
        double tasaEuro = 4.17;

        System.out.println("Por favor, elija la moneda de origen:");
        System.out.println("1. Dólares");
        System.out.println("2. Euros");
        System.out.println("3. Soles");
        int monedaOrigen = scanner.nextInt();

        System.out.println("Por favor, elija la moneda de destino:");
        System.out.println("1. Dólares");
        System.out.println("2. Euros");
        System.out.println("3. Soles");
        int monedaDestino = scanner.nextInt();

        System.out.println("Por favor, ingrese el monto a convertir:");
        double monto = scanner.nextDouble();

        double montoConvertido = 0;

        if (monedaDestino == monedaOrigen) {
            System.out.println("La moneda destino es igal a la moneda origen" + monto);

        } else {


            switch (monedaOrigen) {
                case 1: // Dólares
                    switch (monedaDestino) {
                        case 2: // a Euros
                            montoConvertido = (monto * tasaDolar) / tasaEuro;
                            break;
                        case 3: // a Soles
                            montoConvertido = monto * tasaDolar;
                            break;
                    }
                    break;
                case 2: // Euros
                    switch (monedaDestino) {
                        case 1: // a Dólares
                            montoConvertido = (monto * tasaEuro) / tasaDolar;
                            break;
                        case 3: // a Soles
                            montoConvertido = monto * tasaEuro;
                            break;
                    }
                    break;
                case 3: // Soles
                    switch (monedaDestino) {
                        case 1: // a Dólares
                            montoConvertido = monto / tasaDolar;
                            break;
                        case 2: // a Euros
                            montoConvertido = monto / tasaEuro;
                            break;

                    }
                    break;
            }


            System.out.println("El monto convertido es: " + montoConvertido);
        }
        scanner.close();
    }
}
