package AEA4.ContadorParaules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ContadorParaules {

    public static void main(String[] args) {

        File fitxerEntrada = new File("/Users/alejandro/Dev/Clase/Programacion/src/AEA4/ContadorParaules/entrada.txt");
        File fitxerSortida = new File("/Users/alejandro/Dev/Clase/Programacion/src/AEA4/ContadorParaules/sortida.txt");

        // --- LECTURA ---
        int paraules = 0;
        boolean llegitCorrectament = false;

        try {
            Scanner lector = new Scanner(fitxerEntrada);
            while (lector.hasNext()) {
                lector.next();
                paraules++;
            }
            lector.close();
            llegitCorrectament = true;
        } catch (FileNotFoundException e) {
            System.out.println("Error: l'arxiu entrada.txt no s'ha trobat.");
        } catch (Exception e) {
            System.out.println("Error en llegir l'arxiu: " + e.getMessage());
        }

        // --- ESCRIPTURA ---
        if (llegitCorrectament) {
            try {
                PrintWriter escriptor = new PrintWriter(fitxerSortida);
                escriptor.println("El archivo tiene " + paraules + " palabras.");
                escriptor.close();
            } catch (Exception e) {
                System.out.println("Error en escriure l'arxiu sortida.txt: " + e.getMessage());
            }
        }
    }
}
