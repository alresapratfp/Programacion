package Utilities;

import java.util.Scanner;

public class utils {
    Scanner a = new Scanner(System.in);
    public String string() {
        String dato = "";
        while (!a.hasNextLine()) {
            System.out.println("valor no vàlid, introdueix un String");
            a.next();
            
        }
        dato = a.nextLine();
        return dato;
    }

    public int numEnter() {
        int dato = 0;
        while (!a.hasNextInt()) {
            System.out.println("Valor no vàlid, introdueix un nombre Enter.");
            a.next();
        }

        dato = a.nextInt();
        a.nextLine();
        return dato;
    }

    public double numReal() {
        double dato = 0;
        while (!a.hasNextDouble()) {
            System.out.println("Valor no vàlid, introdueix un nombre Real");
            a.next();
        }
    
        dato = a.nextDouble();
        a.nextLine();
        return dato;
    }
}