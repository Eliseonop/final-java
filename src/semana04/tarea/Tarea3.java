package semana04.tarea;

import java.util.Scanner;

public class Tarea3 {
    public static final int ALIMENTOS_Y_BEBIDAS = 1;
    public static final int TEXTILES = 2;
    public static final int ELECTROHOGAR = 3;
    public static final int TECNOLOGIA = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese la categoría del producto:");
        System.out.println("1. Alimentos y bebidas");
        System.out.println("2. Textiles");
        System.out.println("3. Electrohogar");
        System.out.println("4. Tecnología");
        int categoria = scanner.nextInt();

        System.out.println("Por favor, elija un método de pago:");

        switch (categoria) {
            case ALIMENTOS_Y_BEBIDAS:
                System.out.println("1. Efectivo");
                System.out.println("2. Aplicativo Pago Móvil");
                System.out.println("3. Tarjeta de Crédito");
                System.out.println("4. Cancelar el pedido");
                break;
            case TEXTILES:
                System.out.println("1. Efectivo");
                System.out.println("2. Tarjeta de Crédito");
                System.out.println("3. Cancelar el pedido");
                break;
            case ELECTROHOGAR:
            case TECNOLOGIA:
                System.out.println("1. Tarjeta de crédito");
                System.out.println("2. Transferencia Bancaria");
                System.out.println("3. Cancelar el pedido");
                break;
            default:
                System.out.println("Categoría de producto no reconocida");
                break;
        }

        scanner.close();


    }
}
