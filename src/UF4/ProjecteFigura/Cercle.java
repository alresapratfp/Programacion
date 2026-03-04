package UF4.ProjecteFigura;

public class Cercle extends Figura {
    private int radi;

    public Cercle() {
        super("cercle");
        radi = 0;
    }

    public Cercle(int radi) {
        super("cercle");
        this.radi = radi;
    }

    public int getRadi() {
        return radi;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radi * radi;
    }

    @Override
    public void llegirDades() {
        radi = llegirEnter("Introdueix el radi del cercle: ");
    }
}
