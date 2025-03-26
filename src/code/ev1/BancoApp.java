package code.ev1;
import java.util.Scanner;

class CuentaBancaria {
  private double saldo;

  public CuentaBancaria() {
    this.saldo = 0;
  }

  public void depositar(double cantidad) {
    if (cantidad <= 0) {
      System.out.println("Cantidad no válida");
      return;
    }

    this.saldo += cantidad;
    System.out.println("Deposito exitoso");
  }

  public void retirar(double cantidad) {
    if (cantidad <= 0) {
      System.out.println("Cantidad no válida");
      return;
    }

    if (cantidad > this.saldo) {
      System.out.println("Saldo insuficiente");
      return;
    }

    this.saldo -= cantidad;
    System.out.println("Retiro exitoso");
  }

  public void consultarSaldo() {
    System.out.println("Saldo actual: " + this.saldo);
  }
}

public class BancoApp {
  public static void main(String[] args) {
    CuentaBancaria cuenta = new CuentaBancaria();
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
      System.out.println("1. Depositar");
      System.out.println("2. Retirar");
      System.out.println("3. Consultar saldo");
      System.out.println("4. Salir");
      System.out.print("Opción: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          System.out.print("Cantidad a depositar: ");
          double cantidadDeposito = scanner.nextDouble();
          cuenta.depositar(cantidadDeposito);
          break;
        case 2:
          System.out.print("Cantidad a retirar: ");
          double cantidadRetiro = scanner.nextDouble();
          cuenta.retirar(cantidadRetiro);
          break;
        case 3:
          cuenta.consultarSaldo();
          break;
        case 4:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción no válida");
      }
    } while (opcion != 4);

    scanner.close();
  }
}
