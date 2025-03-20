package code.ev1;
import java.util.Scanner;

class Cuadrado {
  private double lado;

  public Cuadrado(double lado) {
    this.lado = lado;
  }

  public double calcularPerimetro() {
    return 4 * this.lado;
  }
}

public class PerimetroCuadrado {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese el lado del cuadrado: ");
    double lado = sc.nextDouble();

    sc.close();

    Cuadrado cuadrado = new Cuadrado(lado);
    System.out.println("El perímetro del cuadrado es: " + cuadrado.calcularPerimetro());
  }
}
