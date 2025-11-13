package AEA2;

import java.util.Arrays;

public class trobar_maxim_minim {

    public static void main(String[] args) {
        int[] vector = {12, 3, 45, -3, 65, -5, 88, 99, 2, 23, 54, 33, 27, 53, 96, 0};

        int min = vector[0];
        int max = vector[0];

        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < min) {
                min = vector[i];
            }
            if (vector[i] > max) {
                max = vector[i];
            }
        }

        System.out.println("El vector és: " + Arrays.toString(vector));
        System.out.println();
        System.out.println("El nombre més petit del vector és: " + min);
        System.out.println("El nombre més gran del vector és: " + max);
    }
}