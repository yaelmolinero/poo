package code.ev2;
import java.util.Scanner;

class Coleccion {
  private int[] numeros = new int[10];

  public Coleccion() {}

  public void llenarColeccion() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese 10 numeros:");

    for (int i = 0; i < 10; i++) {
      System.out.print("Numero " + (i + 1) + ": ");
      numeros[i] = scanner.nextInt();
    }

    scanner.close();
  }

  public void mostrarDivisibles() {
    System.out.println("Numeros divisibles por 2:");

    for (int numero : numeros) {
      if (numero % 2 == 0) {
        System.out.print(numero + " ");
      }
    }
  }
}

public class Divisible {
  public static void main(String[] args) {
    Coleccion coleccion = new Coleccion();
    coleccion.llenarColeccion();
    coleccion.mostrarDivisibles();
  }
}
