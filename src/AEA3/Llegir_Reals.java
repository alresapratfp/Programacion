import java.util.Scanner;

public class Llegir_Reals {
    public static void main(String[] args) {
        Llegir_Reals programa = new Llegir_Reals();
        programa.inici();
    }

    public void inici() {
        System.out.println("Llegiu un real pel teclat:");
        double a = llegirRealTeclat();
        System.out.println("El real ha estat " + a + ".");
        System.out.println("Llegiu un altre real pel teclat:");
        a = llegirRealTeclat();
        System.out.println("L'altre real ha estat " + a + ".");
    }

    public double llegirRealTeclat() {
        Scanner s = new Scanner(System.in);
        double realLlegit = 0;
        boolean llegit = false;
        while (!llegit) {
            llegit = s.hasNextDouble();
            if (llegit) {
                realLlegit = s.nextDouble();
            } else {
                System.out.println("Això no és un real.");
                s.next();
            }
        }
        s.nextLine();
        return realLlegit;
    }
}