package AEA5.Calculadora;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class CalculadoraApp extends JFrame {
    // Define colores básicos de la interfaz para distinguir pantalla, botones y acciones.
    private static final Color COLOR_FONDO = new Color(240, 243, 247);
    private static final Color COLOR_PANEL = new Color(255, 255, 255);
    private static final Color COLOR_NUMEROS = new Color(250, 250, 252);
    private static final Color COLOR_OPERADORES = new Color(255, 183, 77);
    private static final Color COLOR_ACCIONES = new Color(207, 216, 220);
    private static final Color COLOR_IGUAL = new Color(79, 140, 255);
    private static final Color COLOR_TEXTO = new Color(33, 37, 41);

    private final CalculadoraLogica logica;
    private final JTextField campOperacio;
    private final JLabel etiquetaResultat;
    private final JTextArea areaHistorial;
    private final JPanel panellHistorial;
    private boolean historialVisible;

    public CalculadoraApp() {
        // Crea la lógica y todos los componentes principales de la ventana.
        logica = new CalculadoraLogica();
        campOperacio = new JTextField();
        etiquetaResultat = new JLabel("Resultat: 0", SwingConstants.RIGHT);
        areaHistorial = new JTextArea();
        panellHistorial = new JPanel(new BorderLayout(10, 10));
        historialVisible = false;

        setTitle("AEA5 - Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(920, 560);
        setMinimumSize(new Dimension(760, 500));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));
        getContentPane().setBackground(COLOR_FONDO);

        afegirPantalla();
        afegirBotons();
        afegirHistorial();
    }

    private void afegirPantalla() {
        // Monta la parte superior con el campo de operación, el resultado y el botón del historial.
        JPanel panellPantalla = new JPanel(new BorderLayout(8, 8));
        panellPantalla.setBackground(COLOR_FONDO);
        panellPantalla.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 12));

        campOperacio.setFont(new Font("SansSerif", Font.BOLD, 30));
        campOperacio.setHorizontalAlignment(SwingConstants.RIGHT);
        campOperacio.setBackground(COLOR_PANEL);
        campOperacio.setForeground(COLOR_TEXTO);
        campOperacio.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 218, 226), 1),
                BorderFactory.createEmptyBorder(14, 16, 14, 16)
        ));
        campOperacio.addActionListener(e -> calcular());

        etiquetaResultat.setFont(new Font("SansSerif", Font.BOLD, 22));
        etiquetaResultat.setForeground(new Color(36, 99, 71));

        JButton botoHistorial = new JButton("Mostrar historial");
        estilitzarBotoPetit(botoHistorial);
        botoHistorial.addActionListener(e -> {
            historialVisible = !historialVisible;
            panellHistorial.setVisible(historialVisible);
            botoHistorial.setText(historialVisible ? "Ocultar historial" : "Mostrar historial");
            revalidate();
        });

        JPanel filaInferior = new JPanel(new BorderLayout(8, 8));
        filaInferior.setBackground(COLOR_FONDO);
        filaInferior.add(botoHistorial, BorderLayout.WEST);
        filaInferior.add(etiquetaResultat, BorderLayout.CENTER);

        panellPantalla.add(campOperacio, BorderLayout.CENTER);
        panellPantalla.add(filaInferior, BorderLayout.SOUTH);

        add(panellPantalla, BorderLayout.NORTH);
    }

    private void afegirBotons() {
        // Crea la rejilla de botones de la calculadora y los conecta con su acción.
        JPanel panellCentral = new JPanel(new BorderLayout(12, 12));
        panellCentral.setBackground(COLOR_FONDO);
        panellCentral.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));

        JPanel panellBotons = new JPanel(new GridLayout(5, 4, 10, 10));
        panellBotons.setBackground(COLOR_FONDO);

        String[] textos = {
                "+/-", "AC", "⌫", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                ",", "0", " ", "="
        };

        for (String text : textos) {
            JButton boto = new JButton(text);
            if (text.equals(" ")) {
                boto.setBorderPainted(false);
                boto.setContentAreaFilled(false);
                boto.setEnabled(false);
            } else {
                estilitzarBotoGran(boto, text);
                boto.addActionListener(e -> accioBoto(text));
            }
            panellBotons.add(boto);
        }

        panellCentral.add(panellBotons, BorderLayout.CENTER);
        panellCentral.add(panellHistorial, BorderLayout.EAST);

        add(panellCentral, BorderLayout.CENTER);
    }

    private void afegirHistorial() {
        // Prepara el panel lateral del historial y el botón para vaciarlo.
        panellHistorial.setPreferredSize(new Dimension(280, 0));
        panellHistorial.setBackground(COLOR_PANEL);
        panellHistorial.setBorder(BorderFactory.createTitledBorder("Historial"));

        areaHistorial.setEditable(false);
        areaHistorial.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaHistorial.setBackground(COLOR_PANEL);
        areaHistorial.setForeground(COLOR_TEXTO);

        JButton botoEsborrar = new JButton("Borrar historial");
        estilitzarBotoPetit(botoEsborrar);
        botoEsborrar.addActionListener(e -> {
            logica.esborrarHistorial();
            actualitzarHistorial();
        });

        panellHistorial.add(new JScrollPane(areaHistorial), BorderLayout.CENTER);
        panellHistorial.add(botoEsborrar, BorderLayout.SOUTH);
        panellHistorial.setVisible(false);
    }

    private void accioBoto(String text) {
        // Decide qué hacer según el botón pulsado.
        switch (text) {
            case "AC":
                campOperacio.setText("");
                etiquetaResultat.setText("Resultat: 0");
                campOperacio.requestFocusInWindow();
                break;
            case "⌫":
                esborrarUltimCaracter();
                break;
            case "=":
                if (logica.esPotRepetir() && campOperacio.getText().equals(logica.obtenirExpressioRepetida())) {
                    repetir();
                } else {
                    calcular();
                }
                break;
            case "+/-":
                campOperacio.setText(logica.canviarSigne(campOperacio.getText(), campOperacio.getCaretPosition()));
                campOperacio.requestFocusInWindow();
                campOperacio.setCaretPosition(campOperacio.getText().length());
                break;
            case "+":
            case "-":
                inserirText(" " + text + " ");
                break;
            case "×":
                inserirText(" * ");
                break;
            case "÷":
                inserirText(" / ");
                break;
            case ",":
                inserirDecimal();
                break;
            default:
                inserirText(text);
                break;
        }
    }

    private void inserirText(String text) {
        // Inserta texto en la posición actual del cursor.
        int inici = campOperacio.getSelectionStart();
        int fi = campOperacio.getSelectionEnd();
        String contingut = campOperacio.getText();
        String nouText = contingut.substring(0, inici) + text + contingut.substring(fi);

        campOperacio.setText(nouText);
        campOperacio.requestFocusInWindow();
        campOperacio.setCaretPosition(inici + text.length());
    }

    private void inserirDecimal() {
        int inici = campOperacio.getSelectionStart();
        int fi = campOperacio.getSelectionEnd();
        String contingut = campOperacio.getText();

        int iniciNumero = inici;
        while (iniciNumero > 0) {
            char caracter = contingut.charAt(iniciNumero - 1);
            if (Character.isDigit(caracter) || caracter == ',' || caracter == '.') {
                iniciNumero--;
            } else {
                break;
            }
        }

        int fiNumero = fi;
        while (fiNumero < contingut.length()) {
            char caracter = contingut.charAt(fiNumero);
            if (Character.isDigit(caracter) || caracter == ',' || caracter == '.') {
                fiNumero++;
            } else {
                break;
            }
        }

        String numeroActual = contingut.substring(iniciNumero, fiNumero);

        if (numeroActual.contains(",") || numeroActual.contains(".")) {
            return;
        }

        if (iniciNumero == fiNumero) {
            inserirText("0,");
        } else {
            inserirText(",");
        }
    }

    private void esborrarUltimCaracter() {
        // Borra el texto seleccionado o el carácter anterior al cursor.
        int inici = campOperacio.getSelectionStart();
        int fi = campOperacio.getSelectionEnd();
        String contingut = campOperacio.getText();

        if (inici != fi) {
            campOperacio.setText(contingut.substring(0, inici) + contingut.substring(fi));
            campOperacio.setCaretPosition(inici);
            return;
        }

        if (inici == 0) {
            return;
        }

        campOperacio.setText(contingut.substring(0, inici - 1) + contingut.substring(inici));
        campOperacio.setCaretPosition(inici - 1);
    }

    private void calcular() {
        // Envía la operación a la lógica y actualiza el resultado y el historial.
        try {
            String resultat = logica.calcular(campOperacio.getText());
            etiquetaResultat.setText("Resultat: " + resultat);
            actualitzarHistorial();
        } catch (Exception e) {
            etiquetaResultat.setText("Resultat: " + e.getMessage());
        }
    }

    private void repetir() {
        // Repite la última operación guardada en la lógica.
        try {
            String resultat = logica.repetirOperacio();
            campOperacio.setText(logica.obtenirExpressioRepetida());
            etiquetaResultat.setText("Resultat: " + resultat);
            actualitzarHistorial();
        } catch (Exception e) {
            etiquetaResultat.setText("Resultat: " + e.getMessage());
        }
    }

    private void actualitzarHistorial() {
        // Pasa la lista del historial al área de texto de la interfaz.
        StringBuilder text = new StringBuilder();

        for (String linia : logica.getHistorial()) {
            if (text.length() > 0) {
                text.append("\n");
            }
            text.append(linia);
        }

        areaHistorial.setText(text.toString());
    }

    private void estilitzarBotoGran(JButton boto, String text) {
        // Aplica el estilo principal de los botones según su tipo.
        boto.setFont(new Font("SansSerif", Font.BOLD, 24));
        boto.setFocusable(false);
        boto.setForeground(COLOR_TEXTO);
        boto.setOpaque(true);
        boto.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(214, 220, 228), 1),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)
        ));

        if (text.equals("÷") || text.equals("×") || text.equals("-") || text.equals("+")) {
            boto.setBackground(COLOR_OPERADORES);
        } else if (text.equals("=")) {
            boto.setBackground(COLOR_IGUAL);
            boto.setForeground(Color.WHITE);
        } else if (text.equals("AC") || text.equals("⌫") || text.equals("+/-")) {
            boto.setBackground(COLOR_ACCIONES);
        } else {
            boto.setBackground(COLOR_NUMEROS);
        }
    }

    private void estilitzarBotoPetit(JButton boto) {
        // Aplica un estilo más discreto a los botones secundarios.
        boto.setFont(new Font("SansSerif", Font.BOLD, 14));
        boto.setFocusable(false);
        boto.setBackground(COLOR_PANEL);
        boto.setForeground(COLOR_TEXTO);
        boto.setOpaque(true);
        boto.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(214, 220, 228), 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraApp app = new CalculadoraApp();
            app.setVisible(true);
        });
    }
}
