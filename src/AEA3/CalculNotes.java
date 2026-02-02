import java.util.Scanner;

public class CalculNotes {
    public static void main(String[] args) {
        CalculNotes programa = new CalculNotes();
        programa.inici();
    }

    public void inici() {
        double[] notes = new double[5];
        llegirNotes(notes);

        double maxim = calcularMaxim(notes);
        double minim = calcularMinim(notes);
        double mitjana = calcularMitjana(notes);

        System.out.println("La nota màxima és: " + maxim);
        System.out.println("La nota mínima és: " + minim);
        System.out.println("La nota mitjana és: " + mitjana);
    }

    public void llegirNotes(double[] notes) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < notes.length; i++) {
            System.out.print("Introdueix la nota " + (i + 1) + ": ");
            notes[i] = llegirRealTeclat(s);
        }
    }

    public double llegirRealTeclat(Scanner s) {
        double realLlegit = 0;
        boolean llegit = false;
        while (!llegit) {
            if (s.hasNextDouble()) {
                realLlegit = s.nextDouble();
                llegit = true;
            } else {
                System.out.println("Això no és un real. Torna-ho a intentar:");
                s.next();
            }
        }
        return realLlegit;
    }

    public double calcularMaxim(double[] notes) {
        double max = notes[0];
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] > max) {
                max = notes[i];
            }
        }
        return max;
    }

    public double calcularMinim(double[] notes) {
        double min = notes[0];
        for (int i = 1; i < notes.length; i++) {
            if (notes[i] < min) {
                min = notes[i];
            }
        }
        return min;
    }

    public double calcularMitjana(double[] notes) {
        double suma = 0;
        for (double nota : notes) {
            suma += nota;
        }
        return suma / notes.length;
    }
}
