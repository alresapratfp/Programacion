package AEA2;

import java.util.Scanner;

public class Canviar_Valors_Matriu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix el nombre de files: ");
        int files = scanner.nextInt();

        System.out.print("Introdueix el nombre de columnes: ");
        int columnes = scanner.nextInt();

        int[][] matriu = new int[files][columnes];

        System.out.println("Introdueix els valors de la matriu:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print("Valor [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriu[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMatriu d'entrada:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriu transformada:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                boolean filaParell = (i + 1) % 2 == 0;
                boolean columnaParell = (j + 1) % 2 == 0;

                int valor;
                if (filaParell && columnaParell) {
                    valor = 1;
                } else if (filaParell) {
                    valor = 2;
                } else if (columnaParell) {
                    valor = 3;
                } else {
                    valor = 4;
                }

                System.out.print(valor + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
