package UF4.ProjecteFigura;

import java.util.Random;
import java.util.Scanner;

public class Figura {
    private String figura;
    private int id;
    private static int ultimId = 0;
    private static final Scanner s = new Scanner(System.in);
    private static final Random random = new Random();

    public Figura() {
        ultimId++;
        id = ultimId;
        figura = "";
    }

    public Figura(String figura) {
        ultimId++;
        id = ultimId;
        this.figura = figura;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void imprimirDades() {
        System.out.println("La figura amb id " + id + " és un " + figura + ".");
        System.out.println("L'àrea del " + figura + " és: " + calcularArea());
    }

    public double calcularArea() {
        return 0;
    }

    public void llegirDades() {
    }

    protected static int llegirEnter(String missatge) {
        System.out.print(missatge);
        while (!s.hasNextInt()) {
            System.out.print("Valor no vàlid. Torna-ho a intentar: ");
            s.next();
        }
        int valor = s.nextInt();
        s.nextLine();
        return valor;
    }

    public static int llegirOpcioFigura() {
        System.out.println("Quina figura vols crear?");
        System.out.println("1. Triangle");
        System.out.println("2. Quadrat");
        System.out.println("3. Rectangle");
        System.out.println("4. Trapezi");
        System.out.println("5. Rombe");
        System.out.println("6. Paralelogram");
        System.out.println("7. Cercle");

        int opcio = llegirEnter("Opció: ");
        while (opcio < 1 || opcio > 7) {
            opcio = llegirEnter("Opció no vàlida. Torna-ho a intentar: ");
        }
        return opcio;
    }

    public static boolean usarConstructorBuit() {
        return random.nextBoolean();
    }

    public static boolean seguentFigura() {
        System.out.print("Vols crear una altra figura? (s/n): ");
        String resposta = s.nextLine().trim().toLowerCase();
        while (!resposta.equals("s") && !resposta.equals("n")) {
            System.out.print("Resposta no vàlida. Escriu s o n: ");
            resposta = s.nextLine().trim().toLowerCase();
        }
        return resposta.equals("s");
    }

    public static void tancarScanner() {
        s.close();
    }
}
