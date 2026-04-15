package AEA4.Exemples_AEA4.Fitxers;

import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;


public class LlegirNotes {
    //la paraula fi serveix com a marca de final de fitxer
    public static final String MARCA_FI = "fi";
    //el valor -1 marca el final de les notes de cada estudiant
    public static final double MARCA_NOTES = -1;

    public static void main (String[] args) {
        //Forcem el format anglès perquè el punt sigui el separador decimal
        Locale.setDefault(Locale.US);

        try {
            File f = new File("/Users/alejandro/Dev/Clase/Programacion/src/AEA4/Exemples_AEA4/Fitxers/Notes.txt");
            Scanner lector = new Scanner(f);

            //Obrim el fitxer de sortida on escriurem les mitjanes
            File sortida = new File("/Users/alejandro/Dev/Clase/Programacion/src/AEA4/Exemples_AEA4/Fitxers/NotaMitja.txt");
            PrintWriter escriptor = new PrintWriter(sortida);

            boolean llegir = true;
            while (llegir) {
                String nom = lector.next();
                if (MARCA_FI.equals(nom)) {
                    llegir = false;
                }
                else {
                    String cognom = lector.next();
                    //Noteu com un scanner es pot passar com paràmetre
                    double mitjana = llegirNotes(lector);
                    //En lloc de mostrar per pantalla, escrivim al fitxer
                    escriptor.println("Estudiant: " + nom + " " + cognom + " − Mitjana: " + mitjana);
                }
            }
            //Cal tancar el fitxer de lectura i el d'escriptura
            lector.close();
            escriptor.close();
        }
        catch(Exception e) {
            //Excepció!
            System.out.println("1 Error llegint estudiants: " + e);
        }
    }

    /** Donat un Scanner en un fitxer quan l’apuntador es troba sobre l’inici
     * de les notes, s’extreuen fins a trobar la marca -1 i es calcula la mitjana.
     *
     * @param lector Scanner a processar
     * @return Mitjana de notes
     */
    public static double llegirNotes(Scanner lector) {
        double res = 0;
        int numNotes = 0;
        try {
            //Es llegeixen notes fins trobar la marca -1
            double nota = lector.nextDouble();
            while (nota != MARCA_NOTES) {
                res = res + nota;
                numNotes++;
                nota = lector.nextDouble();
            }
            //Es calcula nota mitjana
            if (numNotes > 0) {
                res = res/numNotes;
            }
        }
        catch (Exception e) {
            //Excepció!
            System.out.println("2 Error llegint notes: " + e);
        }
        return res;
    }
}
