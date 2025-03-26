package code.ev1;
import java.util.Scanner;

class Multiplicaciones {
  private int numero;

  public Multiplicaciones(int numero) {
    this.numero = numero;
  }

  public void mostrarTabla() {
    for (int i = 1; i <= 10; i++) {
      System.out.println(numero + " x " + i + " = " + (numero * i));
    }
  }
}

public class TablaMultiplicar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce un número entero: ");
    int numero = sc.nextInt();

    sc.close();

    Multiplicaciones tabla = new Multiplicaciones(numero);
    tabla.mostrarTabla();
  }
}
