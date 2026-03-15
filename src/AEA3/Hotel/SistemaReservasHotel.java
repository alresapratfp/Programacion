package AEA3.Hotel;

import java.util.Scanner;

public class SistemaReservasHotel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Alojamiento[] alojamientos = new Alojamiento[5];
        alojamientos[0] = new Habitacion("Habitacion 101", 3, true, 3);
        alojamientos[1] = new Apartamento("Apartamento Blue", 4, true, 2, true);
        alojamientos[2] = new CasaRural("Masia Verde", 6, true, true, false);
        alojamientos[3] = new Habitacion("Habitacion 202", 1, true, 1);
        alojamientos[4] = new CasaRural("Can Soler", 8, true, true, true);

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(s, "Elige una opcion: ");

            switch (opcion) {
                case 1:
                    mostrarAlojamientosDisponibles(alojamientos);
                    break;
                case 2:
                    reservarAlojamiento(alojamientos, s);
                    break;
                case 3:
                    liberarAlojamiento(alojamientos, s);
                    break;
                case 4:
                    busquedaPersonalizada(alojamientos, s);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

            System.out.println();
        } while (opcion != 5);

        s.close();
    }

    public static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Mostrar alojamientos disponibles");
        System.out.println("2. Reservar alojamiento");
        System.out.println("3. Liberar alojamiento");
        System.out.println("4. Busqueda personalizada");
        System.out.println("5. Salir");
    }

    public static int leerEntero(Scanner s, String mensaje) {
        System.out.print(mensaje);
        while (!s.hasNextInt()) {
            System.out.print("Valor no valido. Introduce un numero: ");
            s.next();
        }
        int valor = s.nextInt();
        s.nextLine();
        return valor;
    }

    public static String leerTexto(Scanner s, String mensaje) {
        System.out.print(mensaje);
        return s.nextLine();
    }

    public static void mostrarAlojamientosDisponibles(Alojamiento[] alojamientos) {
        boolean hayDisponibles = false;

        for (int i = 0; i < alojamientos.length; i++) {
            if (alojamientos[i].isDisponible()) {
                System.out.println(alojamientos[i].mostrarInformacion());
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay alojamientos disponibles.");
        }
    }

    public static void reservarAlojamiento(Alojamiento[] alojamientos, Scanner s) {
        String nombre = leerTexto(s, "Introduce el nombre del alojamiento a reservar: ");
        Alojamiento alojamiento = buscarPorNombre(alojamientos, nombre);

        if (alojamiento == null) {
            System.out.println("No existe ningun alojamiento con ese nombre.");
        } else if (alojamiento.reservar()) {
            System.out.println("Reservado correctamente.");
        } else {
            System.out.println("Ese alojamiento no esta disponible.");
        }
    }

    public static void liberarAlojamiento(Alojamiento[] alojamientos, Scanner s) {
        String nombre = leerTexto(s, "Introduce el nombre del alojamiento a liberar: ");
        Alojamiento alojamiento = buscarPorNombre(alojamientos, nombre);

        if (alojamiento == null) {
            System.out.println("No existe ningun alojamiento con ese nombre.");
        } else {
            alojamiento.liberar();
            System.out.println("Alojamiento liberado correctamente.");
        }
    }

    public static void busquedaPersonalizada(Alojamiento[] alojamientos, Scanner s) {
        System.out.println("Busqueda personalizada:");
        System.out.println("1. Precio maximo por noche");
        System.out.println("2. Apartamentos con cocina");
        System.out.println("3. Casas rurales con jardin");
        System.out.println("4. Casas rurales con piscina");

        int opcion = leerEntero(s, "Elige una opcion: ");
        boolean encontrado = false;

        switch (opcion) {
            case 1:
                double precioMaximo = leerEntero(s, "Introduce el precio maximo: ");
                for (int i = 0; i < alojamientos.length; i++) {
                    if (alojamientos[i].isDisponible() && alojamientos[i].calcularPrecioPorNoche() <= precioMaximo) {
                        System.out.println(alojamientos[i].mostrarInformacion());
                        encontrado = true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < alojamientos.length; i++) {
                    if (alojamientos[i] instanceof Apartamento) {
                        Apartamento apartamento = (Apartamento) alojamientos[i];
                        if (apartamento.isDisponible() && apartamento.isTieneCocina()) {
                            System.out.println(apartamento.mostrarInformacion());
                            encontrado = true;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < alojamientos.length; i++) {
                    if (alojamientos[i] instanceof CasaRural) {
                        CasaRural casaRural = (CasaRural) alojamientos[i];
                        if (casaRural.isDisponible() && casaRural.isTieneJardin()) {
                            System.out.println(casaRural.mostrarInformacion());
                            encontrado = true;
                        }
                    }
                }
                break;
            case 4:
                for (int i = 0; i < alojamientos.length; i++) {
                    if (alojamientos[i] instanceof CasaRural) {
                        CasaRural casaRural = (CasaRural) alojamientos[i];
                        if (casaRural.isDisponible() && casaRural.isTienePiscina()) {
                            System.out.println(casaRural.mostrarInformacion());
                            encontrado = true;
                        }
                    }
                }
                break;
            default:
                System.out.println("Opcion no valida.");
                return;
        }

        if (!encontrado) {
            System.out.println("No se han encontrado alojamientos con esos criterios.");
        }
    }

    public static Alojamiento buscarPorNombre(Alojamiento[] alojamientos, String nombre) {
        for (int i = 0; i < alojamientos.length; i++) {
            if (alojamientos[i].getNombre().equalsIgnoreCase(nombre)) {
                return alojamientos[i];
            }
        }
        return null;
    }
}
