package AEA3.Persona;

public class Desarrollador extends Empleado {
    private String lenguajeProgramacion;

    public Desarrollador() {
        super();
        lenguajeProgramacion = "";
    }

    public Desarrollador(String nombre, String direccion, double salario, String puestoTrabajo, String lenguajeProgramacion) {
        super(nombre, direccion, salario, puestoTrabajo);
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    @Override
    public double calcularBonus() {
        return salario * 0.10;
    }

    @Override
    public String generarInforme() {
        return super.generarInforme() + "\nLenguaje de programación: " + lenguajeProgramacion;
    }

    public String escribirCodigo() {
        return nombre + " está escribiendo código en " + lenguajeProgramacion + ".";
    }
}
