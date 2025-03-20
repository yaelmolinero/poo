package code.ev1;
import java.util.Scanner;

class Alumno {
  float p1, p2, p3;

  public Alumno(float p1, float p2, float p3) {
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  public void acredito() {
    float finalScore = (this.p1 + this.p2 + this.p3) / 3;

    String msg = finalScore >= 70 ? "acredito" : "no acredito";
    System.out.printf("El alumno %s con un promedio de %f", msg, finalScore);
  }
}

public class Acreditar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese la calificacion de la primer materia: ");
    float p1 = sc.nextFloat();
    
    System.out.print("Ingrese la calificacion de la segunda materia: ");
    float p2 = sc.nextFloat();

    System.out.print("Ingrese la calificacion de la tercer materia: ");
    float p3 = sc.nextFloat();

    sc.close();

    Alumno alumno = new Alumno(p1, p2, p3);

    alumno.acredito();
  }
  
}
