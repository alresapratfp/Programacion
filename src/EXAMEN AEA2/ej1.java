import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese la longitud de los vectores: ");
        int longitud_vector = s.nextInt();
        
        int[] vector1 = new int[longitud_vector];
        int[] vector2 = new int[longitud_vector];
        int[] suma = new int[longitud_vector];

        System.out.println("Ingrese los elementos del primer vector: ");
        for (int i = 0; i < longitud_vector; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector1[i] = s.nextInt();
        }

        System.out.println("Ingrese los elementos del segundo vector: ");
        for (int i = 0; i < longitud_vector; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector2[i] = s.nextInt();
        }

        for (int i = 0; i < longitud_vector; i++) {
            suma[i] = vector1[i] + vector2[i];
        }

        System.out.println("La suma de los vectores es: ");
        for (int i = 0; i < longitud_vector; i++) {
            System.out.print(suma[i] + " ");
        }
    }
}