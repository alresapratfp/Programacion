package AEA3.Persona;

public class Empleado {
    protected String nombre;
    protected String direccion;
    protected double salario;
    protected String puestoTrabajo;

    public Empleado() {
        nombre = "";
        direccion = "";
        salario = 0;
        puestoTrabajo = "";
    }

    public Empleado(String nombre, String direccion, double salario, String puestoTrabajo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        this.puestoTrabajo = puestoTrabajo;
    }

    public double calcularBonus() {
        return 0;
    }

    public String generarInforme() {
        return "Empleado: " + nombre
                + "\nDirección: " + direccion
                + "\nSalario: " + salario
                + "\nPuesto de trabajo: " + puestoTrabajo
                + "\nBonus: " + calcularBonus();
    }
}
