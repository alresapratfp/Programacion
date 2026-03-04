package AEA3.Persona;

public class Gerente extends Empleado {
    private int numeroTrabajadores;

    public Gerente() {
        super();
        numeroTrabajadores = 0;
    }

    public Gerente(String nombre, String direccion, double salario, String puestoTrabajo, int numeroTrabajadores) {
        super(nombre, direccion, salario, puestoTrabajo);
        this.numeroTrabajadores = numeroTrabajadores;
    }

    @Override
    public double calcularBonus() {
        return salario * 0.15;
    }

    @Override
    public String generarInforme() {
        return super.generarInforme() + "\nNúmero de trabajadores: " + numeroTrabajadores;
    }

    public String gestionarProyecto() {
        return nombre + " está gestionando un proyecto con " + numeroTrabajadores + " trabajadores.";
    }
}
