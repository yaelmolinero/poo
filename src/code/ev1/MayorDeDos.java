package code.ev1;
import java.util.Scanner;

class Numeros {
  protected int n1, n2;

  public Numeros(int n1, int n2) {
    this.n1 = n1;
    this.n2 = n2;
  }

  public void numeroMayor() {
    if (this.n1 == this.n2)
      System.out.println("Los numeros son iguales");
    else if (this.n1 > this.n2)
      System.out.println(this.n1 + " es el numero mayor");
    else
      System.out.println(this.n2 + " es el numero mayor");
  }
}

public class MayorDeDos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese un numero: ");
    int n1 = sc.nextInt();
    
    System.out.print("Ingrese otro numero: ");
    int n2 = sc.nextInt();

    sc.close();

    Numeros obj = new Numeros(n1, n2);
    obj.numeroMayor();
  }
}
