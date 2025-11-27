import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese la longitud del vector: ");
        int longitud_vector = s.nextInt();

        int[] vector = new int[longitud_vector];

        System.out.println("Ingrese los elementos del vector:");
        for (int i = 0; i < longitud_vector; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector[i] = s.nextInt();
        }

        System.out.print("Ingrese el valor a buscar: ");
        int valor_a_buscar = s.nextInt();

        int posicion = -1;

        for (int i = 0; i < longitud_vector; i++) {
            if (vector[i] == valor_a_buscar) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("El valor " + valor_a_buscar + " no se encontró en el vector.");
        } else {
            System.out.println("El valor " + valor_a_buscar + " se encontró en la posición " + posicion + " del vector.");
        }
    }
}
