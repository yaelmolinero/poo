package code.ev1;
import java.util.Scanner;

class Circulo {
  private double radio;

  public Circulo(double radio) {
    this.radio = radio;
  }

  public double calcularArea() {
    return Math.PI * Math.pow(this.radio, 2);
  }
}

public class AreaCirculo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese el radio del círculo: ");
    double radio = sc.nextDouble();

    sc.close();

    Circulo circulo = new Circulo(radio);
    System.out.println("El área del círculo es: " + circulo.calcularArea());
  }
}
