package code.ev1;
import java.util.Scanner;

class ParImparClass {
  protected int num;

  public ParImparClass(int num) {
    this.num = num;
  }

  public void compruebaNumero() {
    String msg = num % 2 == 0 ? "El numero es par" : "El numero es impar";
    System.out.println(msg);
  }
}

public class ParImpar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese un numero entero: ");
    int num = sc.nextInt();

    sc.close();

    ParImparClass obj = new ParImparClass(num);
    obj.compruebaNumero();
  }
}
