package AEA3.Persona;

public class Programador extends Empleado {

    public Programador() {
        super();
    }

    public Programador(String nombre, String direccion, double salario, String puestoTrabajo) {
        super(nombre, direccion, salario, puestoTrabajo);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.12;
    }

    public String depurar() {
        return nombre + " está depurando el programa.";
    }
}
