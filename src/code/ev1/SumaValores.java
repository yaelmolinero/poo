package code.ev1;
import java.util.Scanner;

class SumaDosNumeros {
  private int num1, num2;

  public SumaDosNumeros(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  public void mostrarResultado() {
    System.out.printf("La suma de %d y %d es: %d", this.num1, this.num2, this.num1 + this.num2);
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

    SumaDosNumeros suma = new SumaDosNumeros(num1, num2);
    suma.mostrarResultado();
  }
}
