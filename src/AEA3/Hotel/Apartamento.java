package AEA3.Hotel;

public class Apartamento extends Alojamiento {
    private int habitaciones;
    private boolean tieneCocina;

    public Apartamento() {
        super();
        habitaciones = 0;
        tieneCocina = false;
    }

    public Apartamento(String nombre, int capacidad, boolean disponible, int habitaciones, boolean tieneCocina) {
        super(nombre, capacidad, disponible);
        this.habitaciones = habitaciones;
        this.tieneCocina = tieneCocina;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public boolean isTieneCocina() {
        return tieneCocina;
    }

    public void setTieneCocina(boolean tieneCocina) {
        this.tieneCocina = tieneCocina;
    }

    @Override
    public double calcularPrecioPorNoche() {
        return 100 + (habitaciones * 10);
    }

    @Override
    public String mostrarInformacion() {
        String cocina = tieneCocina ? "Si" : "No";
        String estado = isDisponible() ? "Disponible" : "Reservado";
        return "Apartamento: " + getNombre() + " (Habitaciones: " + habitaciones + ", Cocina: "
                + cocina + ") - Capacidad: " + getCapacidad() + " - Precio por noche: "
                + calcularPrecioPorNoche() + " - " + estado;
    }
}
