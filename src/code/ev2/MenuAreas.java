package code.ev2;
import java.util.Scanner;

class Figuras {
  public Figuras() {}

  public double areaCirculo(double radio) {
    return Math.PI * Math.pow(radio, 2);
  }

  public double areaCirculito(double radio1, double radio2) {
    return Math.PI * (radio1 * radio2);
  }

  public double areaCuadrado(double lado) {
    return Math.pow(lado, 2);
  }

  public double areaRectangulo(double base, double altura) {
    return base * altura;
  }

  public double areaTriangulo(double base, double altura) {
    return (base * altura) / 2;
  }
}

public class MenuAreas {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Figuras figuras = new Figuras();
    String opcion;
    
    do {
      System.out.println("Seleccione la figura para calcular el área:");
      System.out.println("1. Circulo");
      System.out.println("1.1. Circulito");
      System.out.println("2. Cuadrado");
      System.out.println("3. Rectangulo");
      System.out.println("4. Triangulo");
      System.out.println("5. Salir");
      opcion = scanner.next();

      switch (opcion) {
        case "1":
          System.out.print("Ingrese el radio del círculo: ");
          double radio = scanner.nextDouble();
          System.out.println("Área del círculo: " + figuras.areaCirculo(radio));
          break;
        case "1.1":
          System.out.print("Ingrese el radio1 del círculo: ");
          double radio1 = scanner.nextDouble();
          System.out.print("Ingrese el radio2 del círculo: ");
          double radio2 = scanner.nextDouble();
          System.out.println("Área del círculo: " + figuras.areaCirculito(radio1, radio2));
          break;
        case "2":
          System.out.print("Ingrese el lado del cuadrado: ");
          double lado = scanner.nextDouble();
          System.out.println("Área del cuadrado: " + figuras.areaCuadrado(lado));
          break;
        case "3":
          System.out.print("Ingrese la base del rectángulo: ");
          double base = scanner.nextDouble();
          System.out.print("Ingrese la altura del rectángulo: ");
          double altura = scanner.nextDouble();
          System.out.println("Área del rectángulo: " + figuras.areaRectangulo(base, altura));
          break;
        case "4":
          System.out.print("Ingrese la base del triángulo: ");
          double baseTriangulo = scanner.nextDouble();
          System.out.print("Ingrese la altura del triángulo: ");
          double alturaTriangulo = scanner.nextDouble();
          System.out.println("Área del triángulo: " + figuras.areaTriangulo(baseTriangulo, alturaTriangulo));
          break;
        case "5":
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción no válida. Intente de nuevo.");
      }
      
    } while (!opcion.equals("5"));

    scanner.close();
  }
}
