package AEA2;

import java.util.Scanner;

public class excelente {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Quantes notes vols introduir? ");
        int numNotes = s.nextInt();

        double[] notes = new double[numNotes];

        for (int i = 0; i < notes.length; i++) {
            System.out.print("Introdueix la nota " + (i + 1) + ": ");
            notes[i] = s.nextDouble();
        }

        boolean hiHaDeu = false;
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == 10) {
                hiHaDeu = true;
                break;
            }
        }

        if (hiHaDeu) {
            System.out.println("Sí, hi ha almenys un alumne amb un 10.");
        } else {
            System.out.println("No hi ha cap alumne amb un 10.");
        }

        s.close();
    }
}
