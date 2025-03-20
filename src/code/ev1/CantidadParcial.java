package code.ev1;
import java.util.Scanner;

class Cantidad {
  private double cantidad;

  public Cantidad(double cantidad) {
    this.cantidad = cantidad;
  }

  public double calcularCantidad() {
    return (this.cantidad * 0.4);
  }
}

public class CantidadParcial {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese la cantidad de dinero: ");
    double cantidad = sc.nextDouble();

    sc.close();

    Cantidad cantidadObj = new Cantidad(cantidad);
    System.out.println("El 40% de la cantidad ingresada es: " + cantidadObj.calcularCantidad());
  }
}
