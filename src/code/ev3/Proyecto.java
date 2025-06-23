package code.ev3;
import javax.swing.*;
import java.awt.*;
import code.utils.ImageCoverLabel;

public class Proyecto {
    // Componentes principales
    JFrame frame;
    JPanel panelBotones;
    JPanel panelContenido;
    CardLayout cardLayout;
    JButton btnImagen, btnSuma, btnResta, btnMultiplicacion, btnDivision;
    JPanel panelImagen, panelSuma, panelResta, panelMultiplicacion, panelDivision;

    void iniciarComponentes() {
        // Tema oscuro básico
        UIManager.put("Panel.background", new Color(40, 40, 40));
        UIManager.put("Button.background", new Color(60, 60, 60));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("TextField.background", new Color(60, 60, 60));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("OptionPane.background", new Color(40, 40, 40));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);

        frame = new JFrame("App de Operaciones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        // Panel de botones (arriba)
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 5));
        panelBotones.setBackground(new Color(30, 30, 30));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnImagen = new JButton("Imagen");
        btnSuma = new JButton("Suma");
        btnResta = new JButton("Resta");
        btnMultiplicacion = new JButton("Multiplicación");
        btnDivision = new JButton("División");

        panelBotones.add(btnImagen);
        panelBotones.add(btnSuma);
        panelBotones.add(btnResta);
        panelBotones.add(btnMultiplicacion);
        panelBotones.add(btnDivision);

        frame.add(panelBotones, BorderLayout.NORTH);

        // Panel de contenido (abajo)
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);
        panelContenido.setPreferredSize(new Dimension(500, 266)); // 2/3 de 400px

        // Panel Imagen
        panelImagen = new JPanel();
        panelImagen.setBackground(new Color(40, 40, 40));
        panelImagen.setLayout(new BorderLayout());
        panelImagen.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        ImageCoverLabel lblImagen = new ImageCoverLabel("/img/walter.jpg");
        panelImagen.add(lblImagen, BorderLayout.CENTER);

        // Panel Suma
        panelSuma = crearPanelOperacion("Suma");
        // Panel Resta
        panelResta = crearPanelOperacion("Resta");
        // Panel Multiplicación
        panelMultiplicacion = crearPanelOperacion("Multiplicación");
        // Panel División
        panelDivision = crearPanelOperacion("División");

        panelContenido.add(panelImagen, "Imagen");
        panelContenido.add(panelSuma, "Suma");
        panelContenido.add(panelResta, "Resta");
        panelContenido.add(panelMultiplicacion, "Multiplicación");
        panelContenido.add(panelDivision, "División");

        frame.add(panelContenido, BorderLayout.CENTER);

        // Acciones de los botones
        btnImagen.addActionListener(e -> cardLayout.show(panelContenido, "Imagen"));
        btnSuma.addActionListener(e -> cardLayout.show(panelContenido, "Suma"));
        btnResta.addActionListener(e -> cardLayout.show(panelContenido, "Resta"));
        btnMultiplicacion.addActionListener(e -> cardLayout.show(panelContenido, "Multiplicación"));
        btnDivision.addActionListener(e -> cardLayout.show(panelContenido, "División"));

        // Mostrar ventana
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método para crear paneles de operaciones
    private JPanel crearPanelOperacion(String operacion) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(40, 40, 40));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Label de título de operación
        JLabel lblOperacion = new JLabel(operacion);
        lblOperacion.setFont(new Font("Arial", Font.BOLD, 18));
        lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lbl1 = new JLabel("Número 1:");
        JTextField txt1 = new JTextField(5);
        JLabel lbl2 = new JLabel("Número 2:");
        JTextField txt2 = new JTextField(5);
        JButton btnCalcular = new JButton("Calcular");
        JLabel lblResultado = new JLabel("Resultado: ");

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lblOperacion, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lbl1, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(txt1, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(lbl2, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(txt2, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(btnCalcular, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; panel.add(lblResultado, gbc);

        btnCalcular.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txt1.getText());
                double n2 = Double.parseDouble(txt2.getText());
                double res = 0;
                switch (operacion) {
                    case "Suma": res = n1 + n2; break;
                    case "Resta": res = n1 - n2; break;
                    case "Multiplicación": res = n1 * n2; break;
                    case "División":
                        if (n2 == 0) {
                            lblResultado.setText("No se puede dividir por cero");
                            return;
                        }
                        res = n1 / n2;
                        break;
                }
                lblResultado.setText("Resultado: " + res);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Ingrese números válidos");
            }
        });
        return panel;
    }

    public static void main(String[] args) {
        new Proyecto().iniciarComponentes();
    }
}
