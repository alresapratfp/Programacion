package UF4.ProjecteFigura;

public class ProjecteFigura {

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            Figura figura = crearFigura();
            System.out.println();
            figura.imprimirDades();
            System.out.println("---------------");
            continuar = Figura.seguentFigura();
        }

        Figura.tancarScanner();
    }

    public static Figura crearFigura() {
        int opcio = Figura.llegirOpcioFigura();

        switch (opcio) {
            case 1:
                return crearTriangle();
            case 2:
                return crearQuadrat();
            case 3:
                return crearRectangle();
            case 4:
                return crearTrapezi();
            case 5:
                return crearRombe();
            case 6:
                return crearParalelogram();
            default:
                return crearCercle();
        }
    }

    public static Triangle crearTriangle() {
        if (Figura.usarConstructorBuit()) {
            Triangle triangle = new Triangle();
            triangle.llegirDades();
            return triangle;
        }

        int base = Figura.llegirEnter("Introdueix la base del triangle: ");
        int altura = Figura.llegirEnter("Introdueix l'altura del triangle: ");
        return new Triangle(base, altura);
    }

    public static Quadrat crearQuadrat() {
        if (Figura.usarConstructorBuit()) {
            Quadrat quadrat = new Quadrat();
            quadrat.llegirDades();
            return quadrat;
        }

        int costat = Figura.llegirEnter("Introdueix el costat del quadrat: ");
        return new Quadrat(costat);
    }

    public static Rectangle crearRectangle() {
        if (Figura.usarConstructorBuit()) {
            Rectangle rectangle = new Rectangle();
            rectangle.llegirDades();
            return rectangle;
        }

        int costat1 = Figura.llegirEnter("Introdueix el costat 1 del rectangle: ");
        int costat2 = Figura.llegirEnter("Introdueix el costat 2 del rectangle: ");
        return new Rectangle(costat1, costat2);
    }

    public static Trapezi crearTrapezi() {
        if (Figura.usarConstructorBuit()) {
            Trapezi trapezi = new Trapezi();
            trapezi.llegirDades();
            return trapezi;
        }

        int a = Figura.llegirEnter("Introdueix la base petita del trapezi: ");
        int b = Figura.llegirEnter("Introdueix la base gran del trapezi: ");
        int altura = Figura.llegirEnter("Introdueix l'altura del trapezi: ");
        return new Trapezi(a, b, altura);
    }

    public static Rombe crearRombe() {
        if (Figura.usarConstructorBuit()) {
            Rombe rombe = new Rombe();
            rombe.llegirDades();
            return rombe;
        }

        int diagonalMajor = Figura.llegirEnter("Introdueix la diagonal major del rombe: ");
        int diagonalMenor = Figura.llegirEnter("Introdueix la diagonal menor del rombe: ");
        return new Rombe(diagonalMajor, diagonalMenor);
    }

    public static Paralelogram crearParalelogram() {
        if (Figura.usarConstructorBuit()) {
            Paralelogram paralelogram = new Paralelogram();
            paralelogram.llegirDades();
            return paralelogram;
        }

        int base = Figura.llegirEnter("Introdueix la base del paralelogram: ");
        int altura = Figura.llegirEnter("Introdueix l'altura del paralelogram: ");
        return new Paralelogram(base, altura);
    }

    public static Cercle crearCercle() {
        if (Figura.usarConstructorBuit()) {
            Cercle cercle = new Cercle();
            cercle.llegirDades();
            return cercle;
        }

        int radi = Figura.llegirEnter("Introdueix el radi del cercle: ");
        return new Cercle(radi);
    }
}
