package code.ev3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Multifuncional {
  private JLabel labelInput;
  private JLabel labelInput2;
  private JTextField inputField;
  private JTextField inputField2;
  private JButton submitButton;
  private JLabel resultLabel;

  private String formVariant;
  private JPanel formPanel;

  JButton crearBoton(String texto, ActionListener listener) {
    JButton btn = new JButton(texto);
    btn.setFont(new Font("Arial", Font.BOLD, 14));
    btn.setBackground(Color.LIGHT_GRAY);
    btn.setForeground(Color.BLACK);
    btn.setBorderPainted(false);
    btn.setFocusPainted(false);
    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

    btn.addActionListener(listener);
    return btn;
  }

  void reiniciarCampos() {
    inputField.setText("");
    inputField2.setText("");
    resultLabel.setText("Resultado: ");
    resultLabel.setForeground(Color.WHITE);

    if (labelInput2.isVisible() && inputField2.isVisible()) {
      inputField2.setVisible(false);
      labelInput2.setVisible(false);
      formPanel.revalidate();
      formPanel.repaint();
    }
  }

  void iniciarComponentes() {
    JFrame frame = new JFrame("App");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(700, 300);

    JPanel panelPrincipal = new JPanel();
    panelPrincipal.setLayout(new BorderLayout());
    panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panelPrincipal.setBackground(new Color(18, 20, 22));

    // Parte 1 del codigo - Crear los paneles que se mostraran dentro del outlet
    CardLayout outlet = new CardLayout();
    JPanel panelOutlet = new JPanel(outlet);

    // Panel 1 - Imagen
    JPanel panelImagen = new JPanel();
    panelImagen.setLayout(new BorderLayout());

    JLabel labelImagen = new JLabel(new ImageIcon(getClass().getResource("/img/japanese.gif")));
    labelImagen.setHorizontalAlignment(SwingConstants.CENTER);

    panelImagen.add(labelImagen, BorderLayout.CENTER);
    enum PanelTipo {
      IMAGEN,
      FACTORIAL,
      RAIZ_CUADRADA,
      VALOR_ABSOLUTO,
      IMC
    }
    formVariant = PanelTipo.FACTORIAL.name();

    formPanel = new JPanel();
    formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    formPanel.setBackground(new Color(18, 20, 22));

    GroupLayout formLayout = new GroupLayout(formPanel);
    formPanel.setLayout(formLayout);
    formLayout.setAutoCreateGaps(true);

    labelInput = new JLabel("");
    labelInput2 = new JLabel("Ingrese su altura (en metros):");
    inputField = new JTextField(10);
    inputField2 = new JTextField(10);
    resultLabel = new JLabel("");

    labelInput.setForeground(Color.WHITE);
    labelInput2.setForeground(Color.WHITE);
    resultLabel.setForeground(Color.WHITE);
    inputField.setForeground(Color.WHITE);
    inputField.setBackground(new Color(12, 12, 12));
    inputField.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    inputField2.setForeground(Color.WHITE);
    inputField2.setBackground(new Color(12, 12, 12));
    inputField2.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));

    submitButton = crearBoton("Calcular", (e) -> {
      resultLabel.setForeground(Color.WHITE);
      try {
        Double numberParsed = Double.parseDouble(inputField.getText());

        if (formVariant.equals(PanelTipo.FACTORIAL.name())) {
          if (numberParsed % 1 != 0) {
            resultLabel.setText("El número debe ser un entero sin decimales");
            resultLabel.setForeground(Color.RED);
            return;
          }

          int result = 1;
          for (int i = 2; i <= numberParsed; i++) {
            result *= i;
          }

          resultLabel.setText("Resultado: " + result);
        } else if (formVariant.equals(PanelTipo.RAIZ_CUADRADA.name())) {
          if (numberParsed < 0) {
            resultLabel.setText("El número debe ser positivo");
            resultLabel.setForeground(Color.RED);
            return;
          }

          double result = Math.sqrt(numberParsed);
          resultLabel.setText("Resultado: " + result);
        } else if (formVariant.equals(PanelTipo.VALOR_ABSOLUTO.name())) {
          double result = Math.abs(numberParsed);
          resultLabel.setText("Resultado: " + result);
        } else if (formVariant.equals(PanelTipo.IMC.name())) {
          double height = Double.parseDouble(inputField2.getText());

          if (height <= 0 || numberParsed <= 0) {
            resultLabel.setText("Los valores deben ser positivos");
            resultLabel.setForeground(Color.RED);
            return;
          }

          double imc = numberParsed / (height * height);
          String imcStr = String.format("%.2f", imc);
          if (imc < 18.5) {
            resultLabel.setText("Resultado: " + imcStr + " (Bajo peso)");
            resultLabel.setForeground(Color.RED);
          } else if (imc < 24.9) {
            resultLabel.setText("Resultado: " + imcStr + " (Peso normal)");
            resultLabel.setForeground(Color.GREEN);
          } else if (imc < 29.9) {
            resultLabel.setText("Resultado: " + imcStr + " (Sobrepeso)");
            resultLabel.setForeground(Color.ORANGE);
          } else {
            resultLabel.setText("Resultado: " + imcStr + " (Obesidad)");
            resultLabel.setForeground(Color.RED);
          }
        }

      } catch (NumberFormatException err) {
        resultLabel.setText("El valor ingresado debe ser un numero");
        resultLabel.setForeground(Color.RED);
      }
    });

    formLayout.setHorizontalGroup(formLayout.createSequentialGroup()
        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(labelInput2)
            .addComponent(labelInput))
        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(inputField)
            .addComponent(inputField2)
            .addComponent(resultLabel))
        .addComponent(submitButton));

    formLayout.setVerticalGroup(formLayout.createSequentialGroup()
        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(labelInput)
            .addComponent(inputField)
            .addComponent(submitButton))
        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(labelInput2)
            .addComponent(inputField2))
        .addComponent(resultLabel));

    // Agregar todos los paneles
    panelOutlet.add(panelImagen, "Imagen");
    panelOutlet.add(formPanel, "Formulario");

    // Parte 2 del codigo - Crear el panel superior con los botones
    JPanel panelSuperior = new JPanel();
    panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
    panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panelSuperior.setBackground(new Color(18, 20, 22));

    JLabel titulo = new JLabel("Imagen");
    titulo.setForeground(Color.WHITE);
    titulo.setFont(new Font("Arial", Font.BOLD, 24));
    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel panelBotones = new JPanel();
    panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
    panelBotones.setBackground(new Color(18, 20, 22));

    JButton btnImagen = crearBoton("Imagen", (e) -> {
      outlet.show(panelOutlet, "Imagen");
      titulo.setText("Imagen");
    });

    JButton btnFactorial = crearBoton("Factorial", (e) -> {
      outlet.show(panelOutlet, "Formulario");
      titulo.setText("Factorial");

      formVariant = PanelTipo.FACTORIAL.name();
      labelInput.setText("Ingrese un número entero:");
      reiniciarCampos();
    });

    JButton btnRaizCuadrada = crearBoton("Raiz Cuadrada", (e) -> {
      outlet.show(panelOutlet, "Formulario");
      titulo.setText("Raiz Cuadrada");

      formVariant = PanelTipo.RAIZ_CUADRADA.name();
      labelInput.setText("Ingrese un número positivo:");
      reiniciarCampos();
    });

    JButton btnValorAbsoluto = crearBoton("Valor Absoluto", (e) -> {
      outlet.show(panelOutlet, "Formulario");
      titulo.setText("Valor Absoluto");

      formVariant = PanelTipo.VALOR_ABSOLUTO.name();
      labelInput.setText("Ingrese un número:");
      reiniciarCampos();
    });

    JButton btnIMC = crearBoton("IMC", (e) -> {
      outlet.show(panelOutlet, "Formulario");
      titulo.setText("IMC");
      reiniciarCampos();

      formVariant = PanelTipo.IMC.name();
      labelInput.setText("Ingrese su peso (en kg):");
      labelInput2.setVisible(true);
      inputField2.setVisible(true);
      formPanel.revalidate();
      formPanel.repaint();
    });

    JButton[] botones = { btnImagen, btnFactorial, btnRaizCuadrada, btnValorAbsoluto, btnIMC };
    for (int i = 0; i < botones.length; i++) {
      panelBotones.add(botones[i]);
      if (i != botones.length - 1)
        panelBotones.add(Box.createHorizontalStrut(15));
    }

    panelSuperior.add(titulo);
    panelSuperior.add(Box.createVerticalStrut(10));
    panelSuperior.add(panelBotones);

    panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
    panelPrincipal.add(panelOutlet, BorderLayout.CENTER);

    frame.setContentPane(panelPrincipal);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      Multifuncional app = new Multifuncional();
      app.iniciarComponentes();
    });
  }
}
