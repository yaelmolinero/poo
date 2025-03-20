package code.ev1;
import java.util.Scanner;

class Triangulo {
  private double base;
  private double altura;

  public Triangulo(double base, double altura) {
    this.base = base;
    this.altura = altura;
  }

  public double calcularArea() {
    return (this.base * this.altura) / 2;
  }
}

public class AreaTriangulo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese la base del triángulo: ");
    double base = sc.nextDouble();
    System.out.print("Ingrese la altura del triángulo: ");
    double altura = sc.nextDouble();

    sc.close();

    Triangulo triangulo = new Triangulo(base, altura);
    System.out.println("El área del triángulo es: " + triangulo.calcularArea());
  }
}
