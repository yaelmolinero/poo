package code.utils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;

public class ImageCoverLabel extends JLabel {
  private BufferedImage image;

  public ImageCoverLabel(String resourcePath) {
    setHorizontalAlignment(SwingConstants.CENTER);
    	try {
        image = ImageIO.read(getClass().getResource(resourcePath));
      } catch (IOException | IllegalArgumentException e) {
  	      image = null;
      }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
      if (image != null) {
        double panelWidth = getWidth();
        double panelHeight = getHeight();
        double imgWidth = image.getWidth();
        double imgHeight = image.getHeight();

        double scale = Math.max(panelWidth / imgWidth, panelHeight / imgHeight);

        int width = (int) (imgWidth * scale);
        int height = (int) (imgHeight * scale);

        int x = (int) ((panelWidth - width) / 2);
        int y = (int) ((panelHeight - height) / 2);

        g.drawImage(image, x, y, width, height, this);
      }
  }
}

