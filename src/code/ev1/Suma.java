package code.ev1;
import java.util.Scanner;

class Operaciones {
  protected float n1, n2;

  public Operaciones(float n1, float n2) {
    this.n1 = n1;
    this.n2 = n2;
  }

  public void suma() {
    System.out.printf("La suma de %f + %f = %f", n1, n2, n1 + n2);
  }
}

public class Suma {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese un numero: ");
    float n1 = sc.nextFloat();
    
    System.out.print("Ingrese otro numero: ");
    float n2 = sc.nextFloat();

    sc.close();

    Operaciones op = new Operaciones(n1, n2);

    op.suma();
  }
}
