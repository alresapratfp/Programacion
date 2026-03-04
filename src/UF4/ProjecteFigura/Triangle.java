package UF4.ProjecteFigura;

public class Triangle extends Figura {
    private int base;
    private int h;

    public Triangle() {
        super("triangle");
        base = 0;
        h = 0;
    }

    public Triangle(int base, int h) {
        super("triangle");
        this.base = base;
        this.h = h;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public double calcularArea() {
        return (base * h) / 2.0;
    }

    @Override
    public void llegirDades() {
        base = llegirEnter("Introdueix la base del triangle: ");
        h = llegirEnter("Introdueix l'altura del triangle: ");
    }
}
