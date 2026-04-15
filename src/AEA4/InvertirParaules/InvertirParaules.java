package AEA4.InvertirParaules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InvertirParaules {

    public static void main(String[] args) {

        File fitxerArxiu = new File("/Users/alejandro/Dev/Clase/Programacion/src/AEA4/InvertirParaules/arxiu.txt");
        File fitxerInvertit = new File("/Users/alejandro/Dev/Clase/Programacion/src/AEA4/InvertirParaules/arxiu_invertit.txt");

        // --- LECTURA I ESCRIPTURA ---
        boolean llegitCorrectament = false;
        Scanner lector = null;

        try {
            lector = new Scanner(fitxerArxiu);
            llegitCorrectament = true;
        } catch (FileNotFoundException e) {
            System.out.println("Error: l'arxiu arxiu.txt no s'ha trobat.");
        } catch (Exception e) {
            System.out.println("Error en llegir l'arxiu: " + e.getMessage());
        }

        if (llegitCorrectament) {
            try {
                PrintWriter escriptor = new PrintWriter(fitxerInvertit);

                while (lector.hasNextLine()) {
                    String linia = lector.nextLine();

                    // Invertim la línia caracter per caracter
                    String invertida = "";
                    for (int i = linia.length() - 1; i >= 0; i--) {
                        invertida += linia.charAt(i);
                    }

                    escriptor.println(invertida);
                }

                lector.close();
                escriptor.close();

            } catch (Exception e) {
                System.out.println("Error en escriure l'arxiu arxiu_invertit.txt: " + e.getMessage());
            }
        }
    }
}
