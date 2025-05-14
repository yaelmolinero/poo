package code.ev2;
import java.util.Scanner;

class Aritmetica {
  int num1, num2;

  public Aritmetica(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }
}

class Sumar extends Aritmetica {
  public Sumar(int num1, int num2) {
    super(num1, num2);
  }

  public int sumar() {
    return num1 + num2;
  }
}

class Resta extends Aritmetica {
  public Resta(int num1, int num2) {
    super(num1, num2);
  }

  public int restar() {
    return num1 - num2;
  }
}

public class OperacionAritmetica {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el primer número: ");
    int num1 = scanner.nextInt();

    System.out.print("Ingrese el segundo número: ");
    int num2 = scanner.nextInt();

    Sumar suma = new Sumar(num1, num2);
    Resta resta = new Resta(num1, num2);

    System.out.println("La suma es: " + suma.sumar());
    System.out.println("La resta es: " + resta.restar());

    scanner.close();
  }
}
