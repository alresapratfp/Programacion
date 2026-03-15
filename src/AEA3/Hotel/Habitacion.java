package AEA3.Hotel;

public class Habitacion extends Alojamiento {
    private int numeroCamas;

    public Habitacion() {
        super();
        numeroCamas = 0;
    }

    public Habitacion(String nombre, int capacidad, boolean disponible, int numeroCamas) {
        super(nombre, capacidad, disponible);
        this.numeroCamas = numeroCamas;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    @Override
    public double calcularPrecioPorNoche() {
        double precio = 50;
        if (numeroCamas >= 3) {
            precio += (numeroCamas - 2) * 20;
        }
        return precio;
    }

    @Override
    public String mostrarInformacion() {
        String estado = isDisponible() ? "Disponible" : "Reservado";
        return "Habitacion: " + getNombre() + " (Camas: " + numeroCamas + ") - Capacidad: "
                + getCapacidad() + " - Precio por noche: " + calcularPrecioPorNoche() + " - " + estado;
    }
}
