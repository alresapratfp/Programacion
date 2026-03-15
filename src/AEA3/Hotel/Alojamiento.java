package AEA3.Hotel;

public class Alojamiento {
    private String nombre;
    private int capacidad;
    private boolean disponible;

    public Alojamiento() {
        nombre = "";
        capacidad = 0;
        disponible = true;
    }

    public Alojamiento(String nombre, int capacidad, boolean disponible) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double calcularPrecioPorNoche() {
        return 0;
    }

    public String mostrarInformacion() {
        String estado = disponible ? "Disponible" : "Reservado";
        return "Tipo: Alojamiento - Nombre: " + nombre + " - Capacidad: " + capacidad
                + " - Precio por noche: " + calcularPrecioPorNoche() + " - " + estado;
    }

    public boolean reservar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }

    public void liberar() {
        disponible = true;
    }
}
