package AEA2;

import java.util.Scanner;

public class media_aritmetica {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 1. Demanar quants valors vol introduir l'usuari
        System.out.print("Quants valors vols introduir? ");
        int numValors = s.nextInt();

        double[] valors = new double[numValors];

        for (int i = 0; i < valors.length; i++) {
            System.out.print("Introdueix el valor " + (i + 1) + ": ");
            valors[i] = s.nextDouble();
        }

        double suma = 0;
        for (int i = 0; i < valors.length; i++) {
            suma += valors[i];
        }
        double mitjana = suma / valors.length;

        System.out.println("La mitjana dels valors és: " + mitjana);

        s.close();
    }
}
