package code.ev3;

import javax.swing.*;
import java.awt.Color;
import code.utils.ImageCoverLabel;

public class Division {
  public static void main(String[] args) {
    JFrame frame = new JFrame("División");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(500, 250);
    frame.setBackground(Color.BLACK);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new java.awt.GridLayout(1, 2, 10, 10));

    // Panel izquierdo (inputs, botones, resultado)
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JTextField num1Field = new JTextField(10);
    JTextField num2Field = new JTextField(10);
    JLabel resultLabel = new JLabel("Resultado: ");
    JButton divideButton = new JButton("Dividir");
    JButton resetButton = new JButton("Reiniciar");

    leftPanel.add(new JLabel("Número 1:"));
    leftPanel.add(num1Field);
    leftPanel.add(Box.createVerticalStrut(10));
    leftPanel.add(new JLabel("Número 2:"));
    leftPanel.add(num2Field);
    leftPanel.add(Box.createVerticalStrut(10));
    leftPanel.add(divideButton);
    leftPanel.add(Box.createVerticalStrut(10));
    leftPanel.add(resetButton);
    leftPanel.add(Box.createVerticalStrut(20));
    leftPanel.add(resultLabel);

    // Panel derecho (imagen/gif)
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new java.awt.BorderLayout());

    // ImageIcon icon = new ImageIcon(Division.class.getResource("/img/bornfire.gif"));
    // JLabel imageLabel = new JLabel(icon);
    ImageCoverLabel imageLabel = new ImageCoverLabel("/img/walter.jpg");
    rightPanel.add(imageLabel, java.awt.BorderLayout.CENTER);

    // Acción del botón dividir
    divideButton.addActionListener((e) -> {
      try {
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());

        try {
          double result = num1 / num2;
          resultLabel.setText("Resultado: " + result);
          
        } catch (ArithmeticException err) {
          resultLabel.setText("Resultado: Infinity");
        }
      } catch (NumberFormatException ex) {
        resultLabel.setText("Resultado: Ingresa números válidos");
      }
    });

    // Acción del botón reiniciar
    resetButton.addActionListener((e) -> {
      num1Field.setText("");
      num2Field.setText("");
      resultLabel.setText("Resultado: ");
    });

    mainPanel.add(leftPanel);
    mainPanel.add(rightPanel);

    frame.setContentPane(mainPanel);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
