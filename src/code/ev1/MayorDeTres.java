package code.ev1;

import java.util.Scanner;
import java.util.Arrays;

class Coleccion {
  private int[] numeros = new int[3];

  public Coleccion(int num1, int num2, int num3) {
    this.numeros[0] = num1;
    this.numeros[1] = num2;
    this.numeros[2] = num3;
  }

  public void calcularMayor() {
    Arrays.sort(this.numeros);
    int max = this.numeros[2];
    System.out.println("El número mayor es: " + max);
  }
}

public class MayorDeTres {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese el primer número: ");
    int num1 = scanner.nextInt();
    System.out.println("Ingrese el segundo número: ");
    int num2 = scanner.nextInt();
    System.out.println("Ingrese el tercer número: ");
    int num3 = scanner.nextInt();

    scanner.close();

    Coleccion coleccion = new Coleccion(num1, num2, num3);
    coleccion.calcularMayor();
  }
}
