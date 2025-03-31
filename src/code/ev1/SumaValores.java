package code.ev1;
import java.util.Scanner;

class Suma {
  private int num1, num2, resultado;

  public Suma(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
    this.resultado = num1 + num2;
  }

  public void mostrarResultado() {
    System.out.println("La suma de " + num1 + " y " + num2 + " es: " + resultado);
  }
}

public class SumaValores {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el primer número: ");
    int num1 = scanner.nextInt();

    System.out.print("Ingrese el segundo número: ");
    int num2 = scanner.nextInt();

    scanner.close();

    Suma suma = new Suma(num1, num2);
    suma.mostrarResultado();
  }
}
