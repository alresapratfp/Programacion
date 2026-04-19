package AEA4.RegistreTemperatures;

public class RegistreTemperatures {
    public static void main(String[] args) {

        double[] temperatures = new double[100];

        try {
            // Per provocar l'excepció, canvia i < temperatures.length per i <= temperatures.length
            for (int i = 0; i < temperatures.length; i++) {
                temperatures[i] = 15.0 + i * 0.5;
            }

            System.out.println("Registre de les 100 temperatures:");
            for (int i = 0; i < temperatures.length; i++) {
                System.out.print(temperatures[i]);
                if ((i + 1) % 10 == 0) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: s'ha intentat accedir a una posició fora dels límits de l'array de temperatures.");
        } catch (Exception e) {
            System.out.println("Error inesperat: " + e.getMessage());
        } finally {
            System.out.println("\nEl programa ha finalitzat.");
        }
    }
}
