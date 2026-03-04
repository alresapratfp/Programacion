package UF4.ProjecteFigura;

public class Paralelogram extends Figura {
    private int b;
    private int h;

    public Paralelogram() {
        super("paralelogram");
        b = 0;
        h = 0;
    }

    public Paralelogram(int b, int h) {
        super("paralelogram");
        this.b = b;
        this.h = h;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public double calcularArea() {
        return b * h;
    }

    @Override
    public void llegirDades() {
        b = llegirEnter("Introdueix la base del paralelogram: ");
        h = llegirEnter("Introdueix l'altura del paralelogram: ");
    }
}
