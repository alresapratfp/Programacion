package AEA3.Hotel;

public class CasaRural extends Alojamiento {
    private boolean tieneJardin;
    private boolean tienePiscina;

    public CasaRural() {
        super();
        tieneJardin = false;
        tienePiscina = false;
    }

    public CasaRural(String nombre, int capacidad, boolean disponible, boolean tieneJardin, boolean tienePiscina) {
        super(nombre, capacidad, disponible);
        this.tieneJardin = tieneJardin;
        this.tienePiscina = tienePiscina;
    }

    public boolean isTieneJardin() {
        return tieneJardin;
    }

    public void setTieneJardin(boolean tieneJardin) {
        this.tieneJardin = tieneJardin;
    }

    public boolean isTienePiscina() {
        return tienePiscina;
    }

    public void setTienePiscina(boolean tienePiscina) {
        this.tienePiscina = tienePiscina;
    }

    @Override
    public double calcularPrecioPorNoche() {
        double precio = 150;
        if (tienePiscina) {
            precio += 50;
        }
        return precio;
    }

    @Override
    public String mostrarInformacion() {
        String jardin = tieneJardin ? "Si" : "No";
        String piscina = tienePiscina ? "Si" : "No";
        String estado = isDisponible() ? "Disponible" : "Reservado";
        return "Casa rural: " + getNombre() + " (Jardin: " + jardin + ", Piscina: " + piscina
                + ") - Capacidad: " + getCapacidad() + " - Precio por noche: "
                + calcularPrecioPorNoche() + " - " + estado;
    }
}
