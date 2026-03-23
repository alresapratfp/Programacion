package AEA3.Examen_v2;

public class CalculArrays {
    //Param. entr: l'array de notes
    //Param. sort: el valor màxim de l'array
    public double calcularMaxim(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    //Param. entr: l'array de notes
    //Param. sort: el valor mínim de l'array
    public double calcularMinim(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    //Param. entr: l'array de notes i la seva mida real
    //Param. sort: el valor mitjà de l'array
    public double calcularMitjana(double[] array, int mida) {
        double suma = 0;
        for (int i = 0; i < mida; i++) {
            suma = suma + array[i];
        }
        return suma/mida;
    }
}
