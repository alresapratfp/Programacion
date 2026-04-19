package AEA4.InicialitzaParells;

public class InicialitzaParells {
    public static void main(String[] args) {

        int[] parells = new int[100];

        try {
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

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: s'ha intentat accedir a una posició fora dels límits de l'array.");
        } catch (Exception e) {
            System.out.println("Error inesperat: " + e.getMessage());
        } finally {
            System.out.println("\nEl programa ha finalitzat.");
        }
    }
}
