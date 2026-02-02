import java.util.Scanner;

public class Calcul_AreeasFuncions {
    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Calcul_AreeasFuncions programa = new Calcul_AreeasFuncions();
        programa.inici();
    }

    public void inici() {
        boolean fi = false;
        while (!fi) {
            System.out.println("De quina figura vols calcular l'area?");
            System.out.println(
                    "Tens les següents opcions: triangle, quadrat, rectangle, trapezi, rombe, paralelogram o cercle.");
            System.out.println("Per acabar el programa: FI");
            String opcio = s.next();

            if (opcio.equalsIgnoreCase("FI")) {
                fi = true;
            } else if (opcio.equalsIgnoreCase("triangle")) {
                calcularAreaTriangle();
            } else if (opcio.equalsIgnoreCase("quadrat")) {
                calcularAreaQuadrat();
            } else if (opcio.equalsIgnoreCase("rectangle")) {
                calcularAreaRectangle();
            } else if (opcio.equalsIgnoreCase("trapezi")) {
                calcularAreaTrapezi();
            } else if (opcio.equalsIgnoreCase("rombe")) {
                calcularAreaRombe();
            } else if (opcio.equalsIgnoreCase("paralelogram")) {
                calcularAreaParalelogram();
            } else if (opcio.equalsIgnoreCase("cercle")) {
                calcularAreaCercle();
            }
        }
    }

    private void calcularAreaTriangle() {
        System.out.println("Quina es la base del triangle?");
        double base = llegirRealTeclat();
        System.out.println("Quina es l'altura del triangle?");
        double altura = llegirRealTeclat();
        double area = (base * altura) / 2;
        imprimirArea(area);
    }

    private void calcularAreaQuadrat() {
        System.out.println("Quin es el costat del quadrat?");
        double costat = llegirRealTeclat();
        double area = costat * costat;
        imprimirArea(area);
    }

    private void calcularAreaRectangle() {
        System.out.println("Quina es la base del rectangle?");
        double base = llegirRealTeclat();
        System.out.println("Quina es l'altura del rectangle?");
        double altura = llegirRealTeclat();
        double area = base * altura;
        imprimirArea(area);
    }

    private void calcularAreaTrapezi() {
        System.out.println("Quina es la base gran del trapezi?");
        double baseGran = llegirRealTeclat();
        System.out.println("Quina es la base petita del trapezi?");
        double basePetita = llegirRealTeclat();
        System.out.println("Quina es l'altura del trapezi?");
        double altura = llegirRealTeclat();
        double area = ((baseGran + basePetita) * altura) / 2;
        imprimirArea(area);
    }

    private void calcularAreaRombe() {
        System.out.println("Quina es la diagonal gran del rombe?");
        double dGran = llegirRealTeclat();
        System.out.println("Quina es la diagonal petita del rombe?");
        double dPetita = llegirRealTeclat();
        double area = (dGran * dPetita) / 2;
        imprimirArea(area);
    }

    private void calcularAreaParalelogram() {
        System.out.println("Quina es la base del paralelogram?");
        double base = llegirRealTeclat();
        System.out.println("Quina es l'altura del paralelogram?");
        double altura = llegirRealTeclat();
        double area = base * altura;
        imprimirArea(area);
    }

    private void calcularAreaCercle() {
        System.out.println("Quin es el radi del cercle?");
        double radi = llegirRealTeclat();
        double area = Math.PI * Math.pow(radi, 2);
        imprimirArea(area);
    }

    private void imprimirArea(double area) {
        System.out.println("L area de tu figura  es " + area);
    }

    private double llegirRealTeclat() {
        double realLlegit = 0;
        boolean llegit = false;
        while (!llegit) {
            if (s.hasNextDouble()) {
                realLlegit = s.nextDouble();
                llegit = true;
            } else {
                System.out.println("Això no és un real.");
                s.next();
            }
        }
        return realLlegit;
    }
}
