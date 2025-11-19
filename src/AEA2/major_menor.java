package AEA2;

import java.util.Scanner;
public class major_menor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introdueix el nombre de files: ");
        int files = s.nextInt();

        System.out.print("Introdueix el nombre de columnes: ");
        int columnes = s.nextInt();

        int[][] matriu = new int[files][columnes];

        // Llegir matriu
        System.out.println("Introdueix els valors de la matriu:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print("Valor [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriu[i][j] = s.nextInt();
            }
        }

        // Mostrar matriu
        System.out.println("La matriu és:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print(matriu[i][j]);
                if (j < columnes - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Buscar min i max
        int min = matriu[0][0];
        int max = matriu[0][0];

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                if (matriu[i][j] < min) min = matriu[i][j];
                if (matriu[i][j] > max) max = matriu[i][j];
            }
        }

        System.out.println("El nombre més petit de la matriu és: " + min);
        System.out.println("El nombre més gran de la matriu és: " + max);

        s.close();
    }
}
