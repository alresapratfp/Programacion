package AEA5.Calculadora;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalculadoraLogica {
    // Guarda el formato de los números, el historial y los datos necesarios para repetir la última operación.
    private final DecimalFormat formatNumeros;
    private final ArrayList<String> historial;
    private char ultimOperador;
    private double ultimNombre;
    private double ultimResultat;
    private boolean esPotRepetir;

    public CalculadoraLogica() {
        DecimalFormatSymbols simbols = new DecimalFormatSymbols(Locale.US);
        formatNumeros = new DecimalFormat("0.############", simbols);
        historial = new ArrayList<>();
        ultimOperador = ' ';
        ultimNombre = 0;
        ultimResultat = 0;
        esPotRepetir = false;
    }

    public String calcular(String expressio) {
        // Limpia el texto introducido, separa números y operadores y calcula respetando prioridad de * y /.
        String text = normalitzar(expressio);

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Introduce una operación.");
        }

        ArrayList<Double> nombres = new ArrayList<>();
        ArrayList<Character> operadors = new ArrayList<>();
        separarExpressio(text, nombres, operadors);

        if (operadors.isEmpty()) {
            try {
                double valor = nombres.get(0);
                ultimResultat = valor;
                esPotRepetir = false;
                return formatNombre(valor);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato de número no válido.");
            }
        }

        ArrayList<Double> nombresSenseMultiplicacions = new ArrayList<>();
        ArrayList<Character> operadorsSenseMultiplicacions = new ArrayList<>();

        double acumulat = nombres.get(0);
        for (int i = 0; i < operadors.size(); i++) {
            char operador = operadors.get(i);
            double numeroSeguent = nombres.get(i + 1);

            if (operador == '*' || operador == '/') {
                acumulat = ferOperacio(acumulat, numeroSeguent, operador);
            } else {
                nombresSenseMultiplicacions.add(acumulat);
                operadorsSenseMultiplicacions.add(operador);
                acumulat = numeroSeguent;
            }
        }
        nombresSenseMultiplicacions.add(acumulat);

        double resultat = nombresSenseMultiplicacions.get(0);
        double resultatAbans = resultat;

        for (int i = 0; i < operadorsSenseMultiplicacions.size(); i++) {
            resultatAbans = resultat;
            resultat = ferOperacio(resultat, nombresSenseMultiplicacions.get(i + 1), operadorsSenseMultiplicacions.get(i));
        }

        if (operadorsSenseMultiplicacions.isEmpty()) {
            double valorTemporal = nombres.get(0);
            for (int i = 0; i < operadors.size(); i++) {
                resultatAbans = valorTemporal;
                valorTemporal = ferOperacio(valorTemporal, nombres.get(i + 1), operadors.get(i));
            }
            resultat = valorTemporal;
            ultimOperador = operadors.get(operadors.size() - 1);
            ultimNombre = nombres.get(nombres.size() - 1);
        } else {
            ultimOperador = operadorsSenseMultiplicacions.get(operadorsSenseMultiplicacions.size() - 1);
            ultimNombre = nombresSenseMultiplicacions.get(nombresSenseMultiplicacions.size() - 1);
        }

        ultimResultat = resultat;
        esPotRepetir = true;

        String expressioFormatejada = formatExpressio(nombres, operadors);
        String resultatFormatejat = formatNombre(resultat);
        historial.add(0, expressioFormatejada + " = " + resultatFormatejat);

        return resultatFormatejat;
    }

    public String repetirOperacio() {
        // Repite la última operación usando el resultado anterior como primer número.
        if (!esPotRepetir) {
            throw new IllegalArgumentException("No hay ninguna operación para repetir.");
        }

        double nouResultat = ferOperacio(ultimResultat, ultimNombre, ultimOperador);
        String expressioFormatejada = formatNombre(ultimResultat) + " " + ultimOperador + " " + formatNombre(ultimNombre);
        String resultatFormatejat = formatNombre(nouResultat);

        historial.add(0, expressioFormatejada + " = " + resultatFormatejat);
        ultimResultat = nouResultat;

        return resultatFormatejat;
    }

    public String obtenirExpressioRepetida() {
        // Devuelve la operación que se usará al pulsar "=" de nuevo.
        if (!esPotRepetir) {
            return "";
        }

        return formatNombre(ultimResultat) + " " + ultimOperador + " " + formatNombre(ultimNombre);
    }

    public boolean esPotRepetir() {
        return esPotRepetir;
    }

    public List<String> getHistorial() {
        return new ArrayList<>(historial);
    }

    public void esborrarHistorial() {
        historial.clear();
    }

    public String canviarSigne(String expressio, int cursor) {
        // Cambia el signo del número donde está situado el cursor.
        if (expressio == null || expressio.isEmpty()) {
            return "-";
        }

        int posicioCursor = Math.max(0, Math.min(cursor, expressio.length()));
        int inici = posicioCursor;
        int fi = posicioCursor;

        while (inici > 0 && esPartNumero(expressio.charAt(inici - 1))) {
            inici--;
        }
        if (inici > 0 && expressio.charAt(inici - 1) == '-' && esSigneNegatiu(expressio, inici - 1)) {
            inici--;
        }

        while (fi < expressio.length() && esPartNumero(expressio.charAt(fi))) {
            fi++;
        }

        if (inici == fi) {
            return expressio.substring(0, posicioCursor) + "-" + expressio.substring(posicioCursor);
        }

        if (expressio.charAt(inici) == '-') {
            return expressio.substring(0, inici) + expressio.substring(inici + 1);
        }

        return expressio.substring(0, inici) + "-" + expressio.substring(inici);
    }

    private String normalitzar(String expressio) {
        // Convierte la coma decimal en punto y elimina espacios sobrantes.
        return expressio.replace(" ", "").replace(",", ".").trim();
    }

    private boolean esSigneNegatiu(String text, int index) {
        if (text.charAt(index) != '-') {
            return false;
        }
        return index == 0 || text.charAt(index - 1) == '+' || text.charAt(index - 1) == '-'
                || text.charAt(index - 1) == '*' || text.charAt(index - 1) == '/';
    }

    private boolean esPartNumero(char caracter) {
        return Character.isDigit(caracter) || caracter == '.';
    }

    private void separarExpressio(String text, ArrayList<Double> nombres, ArrayList<Character> operadors) {
        // Recorre la expresión y separa los números de los operadores.
        StringBuilder numeroActual = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char caracter = text.charAt(i);

            if (Character.isDigit(caracter) || caracter == '.') {
                numeroActual.append(caracter);
            } else if (caracter == '-' && (i == 0 || esOperador(text.charAt(i - 1)))) {
                numeroActual.append(caracter);
            } else if (esOperador(caracter)) {
                if (numeroActual.length() == 0 || numeroActual.toString().equals("-")) {
                    throw new IllegalArgumentException("La operación no está completa.");
                }

                afegirNombre(numeroActual.toString(), nombres);
                operadors.add(caracter);
                numeroActual.setLength(0);
            } else {
                throw new IllegalArgumentException("Expresión no válida.");
            }
        }

        if (numeroActual.length() == 0 || numeroActual.toString().equals("-")) {
            throw new IllegalArgumentException("La operación no está completa.");
        }

        afegirNombre(numeroActual.toString(), nombres);
    }

    private boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/';
    }

    private double ferOperacio(double primerNombre, double segonNombre, char operador) {
        // Ejecuta una operación básica y controla la división entre cero.
        switch (operador) {
            case '+':
                return primerNombre + segonNombre;
            case '-':
                return primerNombre - segonNombre;
            case '*':
                return primerNombre * segonNombre;
            case '/':
                if (segonNombre == 0) {
                    throw new IllegalArgumentException("No se puede dividir entre 0.");
                }
                return primerNombre / segonNombre;
            default:
                throw new IllegalArgumentException("Operador no válido.");
        }
    }

    private String formatNombre(double valor) {
        return formatNumeros.format(valor);
    }

    private String formatExpressio(ArrayList<Double> nombres, ArrayList<Character> operadors) {
        // Reconstruye la operación con espacios para mostrarla de forma más clara.
        StringBuilder text = new StringBuilder();
        text.append(formatNombre(nombres.get(0)));

        for (int i = 0; i < operadors.size(); i++) {
            text.append(" ").append(operadors.get(i)).append(" ");
            text.append(formatNombre(nombres.get(i + 1)));
        }

        return text.toString();
    }

    private void afegirNombre(String textNombre, ArrayList<Double> nombres) {
        // Intenta convertir el texto en número y lanza un error controlado si falla.
        try {
            nombres.add(Double.parseDouble(textNombre));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato de número no válido.");
        }
    }
}
