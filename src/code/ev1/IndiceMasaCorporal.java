package code.ev1;
import java.util.Scanner;

class IMC {
  double peso;
  double altura;

  public IMC(double peso, double altura) {
    this.peso = peso;
    this.altura = altura;
  }

  public double calcularIMC() {
    return peso / (altura * altura);
  }
}

public class IndiceMasaCorporal{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Introduce tu peso en kg: ");
    double peso = sc.nextDouble();

    System.out.println("Introduce tu altura en metros: ");
    double altura = sc.nextDouble();

    sc.close();

    IMC imc = new IMC(peso, altura);
    var resultado = Math.round(imc.calcularIMC());

    String mensaje;
    if (resultado < 18.5) {
      mensaje = "Peso bajo";
    } else if (resultado < 24.9) {
      mensaje = "Peso normal";
    } else if (resultado < 29.9) {
      mensaje = "Sobrepeso";
    } else {
      mensaje = "Obesidad";
    }

    System.out.println("Tu IMC es: " + resultado);
    System.out.println("Tu clasificación es: " + mensaje);
  }
}
