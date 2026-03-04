package UF4.ProjecteFigura;

public class Rectangle extends Figura {
    private int costat1;
    private int costat2;

    public Rectangle() {
        super("rectangle");
        costat1 = 0;
        costat2 = 0;
    }

    public Rectangle(int costat1, int costat2) {
        super("rectangle");
        this.costat1 = costat1;
        this.costat2 = costat2;
    }

    public int getCostat1() {
        return costat1;
    }

    public void setCostat1(int costat1) {
        this.costat1 = costat1;
    }

    public int getCostat2() {
        return costat2;
    }

    public void setCostat2(int costat2) {
        this.costat2 = costat2;
    }

    @Override
    public double calcularArea() {
        return costat1 * costat2;
    }

    @Override
    public void llegirDades() {
        costat1 = llegirEnter("Introdueix el costat 1 del rectangle: ");
        costat2 = llegirEnter("Introdueix el costat 2 del rectangle: ");
    }
}
