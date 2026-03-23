package AEA3.Examen_v2;

import java.util.Scanner;

public class Examen2 {

    public static double[] notes = new double[50];
    public int MARCA_NOTES = -1;
    public int NUM_NOTES = 0;
    public String MARCA_FI = "fi";
    private boolean fi = false;
    public double max = 0;
    public double min = 10;
    public double mitj = 0;


    private Scanner s = new Scanner(System.in);


    public static void main(String[] args) {
        Examen2 programa = new Examen2();
        programa.inici();
    }

    public void inici(){
        PreguntarNotes();
        ImprimirArrayNotes();
        while (!fi) {
            MostrarMenu();
            TractarOpcio();
        }
        s.close();
    }

    //Param. entr:no en té
    //Param. sort:no en té
    private void PreguntarNotes() {
        System.out.println("\nAbans de començar, escriu tantes notes ENTERES com vulguis.");
        System.out.println("\nQuan hagis acabat d'escriure les notes, escriu un -1.");
        System.out.println("--------------------------------------");

        int nota = s.nextInt();
        while (nota != MARCA_NOTES && NUM_NOTES < notes.length) {
            notes[NUM_NOTES] = nota;
            NUM_NOTES++;
            nota = s.nextInt();
        }
        s.nextLine();
    }

    //Param. entr:no en té
    //Param. sort:no en té
    private void ImprimirArrayNotes() {
        System.out.print("\nL'array de notes avaluat és: [ ");
        for (int i = 0; i < NUM_NOTES; i++) {
            System.out.print(notes[i] + " ");
        }
        System.out.println("]\n");
    }

    //Param. entr:no en té
    //Param. sort:no en té
    private void MostrarMenu() {
        System.out.println("\nBenvinguda al càlcul de notes de classe.");
        System.out.println("--------------------------------------");
        System.out.println("[MAX] Saber la nota màxima de classe");
        System.out.println("[MIN] Saber la nota mínima de classe");
        System.out.println("[MIT] Saber la nota mitjana de classe");
        System.out.println("[FI] Sortir.");
        System.out.print("Opció: ");
    }

    //Param. entr:no en té
    //Param. sort:no en té
    private void TractarOpcio() {
        String opcio = s.nextLine();

        if (opcio.equalsIgnoreCase("MAX")) {
            CalculArrays calculador = new CalculArrays();
            double[] notesCopia = new double[NUM_NOTES];
            for (int i = 0; i < NUM_NOTES; i++) {
                notesCopia[i] = notes[i];
            }
            max = calculador.calcularMaxim(notesCopia);
            ImprimirResultat(max, PrepararSortida(max), opcio);
        }
        else if (opcio.equalsIgnoreCase("MIN")) {
            CalculArrays calculador = new CalculArrays();
            double[] notesCopia = new double[NUM_NOTES];
            for (int i = 0; i < NUM_NOTES; i++) {
                notesCopia[i] = notes[i];
            }
            min = calculador.calcularMinim(notesCopia);
            ImprimirResultat(min, PrepararSortida(min), opcio);
        }
        else if (opcio.equalsIgnoreCase("MIT")) {
            CalculArrays calculador = new CalculArrays();
            mitj = calculador.calcularMitjana(notes, NUM_NOTES);
            ImprimirResultat(mitj, PrepararSortida(mitj), opcio);
        }
        else if (opcio.equalsIgnoreCase(MARCA_FI)) {
            fi = true;
            return;
        }

        if (!fi && MirarSiAlgu8()) {
            System.out.println("\nA més, el número 8 es troba dins les notes! Felicitats\n");
        }
    }

    //Param. entr: la nota que volem transformar en text
    //Param. sort: la nota transformada en text
    private String PrepararSortida(double valor) {
        NotaAText transformar = new NotaAText();
        return transformar.notaAText(valor);
    }
    
    //Param. entr:no en té
    //Param. sort: cert si hi ha algun 8 dins l'array, fals si no n'hi ha
    private boolean MirarSiAlgu8() {
        CercaDicotomica cerca = new CercaDicotomica();
        double[] arrayOrdenat = new double[NUM_NOTES];
        for (int i = 0; i < NUM_NOTES; i++) {
            arrayOrdenat[i] = notes[i];
        }

        double auxiliar = 0;
        for (int i = 0; i < arrayOrdenat.length - 1; i++) {
            for (int j = i + 1; j < arrayOrdenat.length; j++) {
                if (arrayOrdenat[i] > arrayOrdenat[j]) {
                    auxiliar = arrayOrdenat[i];
                    arrayOrdenat[i] = arrayOrdenat[j];
                    arrayOrdenat[j] = auxiliar;
                }
            }
        }

        int posicio = cerca.cercaDicotomica(arrayOrdenat, 0, arrayOrdenat.length - 1, 8);
        return posicio != -1;
    }

    //Param. entr: el valor de la nota, el text equivalent i l'opció triada
    //Param. sort:no en té
    private void ImprimirResultat(double valornota, String text, String opcio) {
        String opcioescollida = "";
        if (opcio.equalsIgnoreCase("MAX")){
            opcioescollida = "màxim";
        }
        else if (opcio.equalsIgnoreCase("MIN")){
            opcioescollida = "mínim";
        }
        else {
            opcioescollida = "mitjà";
        }
        System.out.print("El valor " + opcioescollida +" de l'array que has escrit és " + valornota);
        System.out.println(" que equival a un " + text + ".\n");
    }

}
