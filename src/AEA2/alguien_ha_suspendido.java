package AEA2;

import java.util.Scanner;

public class alguien_ha_suspendido {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Quantes notes vols introduir? ");
        int numNotes = s.nextInt();

        double[] notes = new double[numNotes];

        boolean alguHaSuspes = false;
        for (int i = 0; i < notes.length; i++) {
            System.out.print("Introdueix la nota " + (i + 1) + ": ");
            notes[i] = s.nextDouble();

            if (notes[i] < 5) {
                alguHaSuspes = true;
                break;
            }
        }

        if (alguHaSuspes) {
            System.out.println("Almenys un alumne ha suspès.");
        } else {
            System.out.println("Cap alumne ha suspès.");
        }

        s.close();
    }
}
