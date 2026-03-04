package UF4.ProjecteFigura;

public class Quadrat extends Figura {
    private int costat;

    public Quadrat() {
        super("quadrat");
        costat = 0;
    }

    public Quadrat(int costat) {
        super("quadrat");
        this.costat = costat;
    }

    public int getCostat() {
        return costat;
    }

    public void setCostat(int costat) {
        this.costat = costat;
    }

    @Override
    public double calcularArea() {
        return costat * costat;
    }

    @Override
    public void llegirDades() {
        costat = llegirEnter("Introdueix el costat del quadrat: ");
    }
}
