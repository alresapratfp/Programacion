package AEA2;

import java.util.Scanner;

public class Canviar_Valors_Matriu {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introdueix el nombre de files: ");
        int files = s.nextInt();

        System.out.print("Introdueix el nombre de columnes: ");
        int columnes = s.nextInt();

        int[][] matriu = new int[files][columnes];

        System.out.println("Introdueix els valors de la matriu:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print("Valor [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriu[i][j] = s.nextInt();
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
                boolean filaPar = (i + 1) % 2 == 0;
                boolean columnaPar = (j + 1) % 2 == 0;

                if (!filaPar && !columnaPar) {
                    System.out.print("1");
                } else if (!filaPar && columnaPar) {
                    System.out.print("2");
                } else if (filaPar && !columnaPar) {
                    System.out.print("3");
                } else {
                    System.out.print("4");
                }
            }
            System.out.println();
        }

        s.close();
    }
}
