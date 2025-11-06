package AEA2;

public class inicializacion_pares {
    public static void main(String[] args) {
        int[] parells = new int[100];

        for (int i = 0; i < parells.length; i++) {
            parells[i] = i * 2;
        }

        System.out.println("Array amb els 100 primers nombres parells:");
        for (int i = 0; i < parells.length; i++) {
            System.out.print(parells[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
