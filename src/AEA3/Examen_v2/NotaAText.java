package AEA3.Examen_v2;

public class NotaAText {
    //Param. entr: la nota que volem transformar a text
    //Param. sort: la nota transformada en text
    public String notaAText(double nota) {
        if (nota < 5) {
            return "Suspès";
        }
        else if (nota < 7) {
            return "Aprovat";
        }
        else if (nota < 9) {
            return "Notable";
        }
        else {
            return "Excel·lent";
        }
    }
}
