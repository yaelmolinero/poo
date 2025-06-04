package code.ev3;

import javax.swing.*;
import java.awt.*;

public class Paneles {
  private JFrame frame;
  private CardLayout cardLayout;
  private JPanel panelPrincipal;

  public void iniciarComponentes() {
    frame = new JFrame();
    frame.setTitle("App de Paneles");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);

    cardLayout = new CardLayout();
    panelPrincipal = new JPanel(cardLayout);

    // Panel 1
    JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout());

    JLabel label1 = new JLabel("Este es el Panel 1", SwingConstants.CENTER);
    JLabel imagen1 = new JLabel();

    imagen1.setHorizontalAlignment(SwingConstants.CENTER);
    imagen1.setIcon(new ImageIcon(Paneles.class.getResource("/img/bornfire.gif")));
    panel1.add(label1, BorderLayout.NORTH);
    panel1.add(imagen1, BorderLayout.CENTER);

    // Panel 2
    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout());

    JLabel label2 = new JLabel("Este es el Panel 2", SwingConstants.CENTER);
    JLabel imagen2 = new JLabel();
       
    imagen2.setHorizontalAlignment(SwingConstants.CENTER);
    imagen2.setIcon(new ImageIcon(Paneles.class.getResource("/img/walter.jpg")));
    panel2.add(label2, BorderLayout.NORTH);
    panel2.add(imagen2, BorderLayout.CENTER);

    panelPrincipal.add(panel1, "Panel1");
    panelPrincipal.add(panel2, "Panel2");

    // Botones para cambiar de panel
    JPanel panelBotones = new JPanel();

    JButton boton1 = new JButton("Mostrar Panel 1");
    JButton boton2 = new JButton("Mostrar Panel 2");

    panelBotones.add(boton1);
    panelBotones.add(boton2);

    boton1.addActionListener((e) -> {
			cardLayout.show(panelPrincipal, "Panel1");
		});

    boton2.addActionListener((e) -> {
      cardLayout.show(panelPrincipal, "Panel2");
    });

    frame.setLayout(new BorderLayout());
    frame.add(panelBotones, BorderLayout.NORTH);
    frame.add(panelPrincipal, BorderLayout.CENTER);
  	frame.setVisible(true);
  }

  public static void main(String[] args) {
		Paneles run = new Paneles();
		run.iniciarComponentes();
  }
}
