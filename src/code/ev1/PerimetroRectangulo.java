package code.ev1;
import java.util.Scanner;

class Rectangulo {
  private double base;
  private double altura;

  public Rectangulo(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }

  public double calcularPerimetro() {
    return 2 * (this.base + this.altura);
  }
}

public class PerimetroRectangulo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese la base del rectángulo: ");
    double base = sc.nextDouble();
    System.out.print("Ingrese la altura del rectángulo: ");
    double altura = sc.nextDouble();

    sc.close();

    Rectangulo rectangulo = new Rectangulo(base, altura);
    System.out.println("El perímetro del rectángulo es: " + rectangulo.calcularPerimetro());
  }
}
