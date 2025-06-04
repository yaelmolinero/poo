package code.ev3;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ArchivoNoEncontrado {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Archivo No Encontrado");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 300);
    frame.setResizable(false);
    frame.setLayout(new GridLayout(1, 2));

    // Panel 1: Botón y mensaje
    JPanel panel1 = new JPanel();
    panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
    panel1.setBackground(Color.BLACK);
    
    JButton openButton = new JButton("Abrir archivo");
    openButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel messageLabel = new JLabel(" ");
    messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    messageLabel.setForeground(Color.WHITE);

    openButton.addActionListener((e) -> {
      try {
        File file = new File("archivo.txt");
          if (!file.exists()) throw new Exception("Archivo no encontrado");

          messageLabel.setText("Archivo encontrado: " + file.getName());
      } catch (Exception err) {
          messageLabel.setText("Archivo no encontrado");
      }
    });

    panel1.add(Box.createVerticalStrut(30));
    panel1.add(openButton);
    panel1.add(Box.createVerticalStrut(20));
    panel1.add(messageLabel);

    // Panel 2: Imagen
    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout());

    ImageIcon icon = new ImageIcon(ArchivoNoEncontrado.class.getResource("/img/bornfire.gif"));
    JLabel imageLabel = new JLabel(icon, JLabel.CENTER);

    panel2.add(imageLabel, BorderLayout.CENTER);

    frame.add(panel1);
    frame.add(panel2);
    frame.setVisible(true);
  }
}
