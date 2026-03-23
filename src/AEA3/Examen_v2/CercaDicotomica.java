package AEA3.Examen_v2;

public class CercaDicotomica {
    //Param. entr: l'array ordenat, la posició inicial, la posició final i el valor a buscar
    //Param. sort: la posició on es troba el valor o -1 si no existeix
    public int cercaDicotomica(double[] array, int inici, int fi, double valor) {
        if (inici > fi) {
            return -1;
        }
        int pos = inici + (fi - inici) / 2;

        if (array[pos] > valor) {
            return cercaDicotomica(array, inici, pos - 1, valor);
        }
        else if (array[pos] < valor) {
            return cercaDicotomica(array, pos + 1, fi, valor);
        }
        else {
            return pos;
        }
    }
}
