package code.ev2;
import java.util.Scanner;

class Ropa {
  public String name;
  public double price, discount;
  public double totalPrice = 0, totalWithDiscount = 0;
  public int cantity = 0;

  public Ropa(String name, double price, double discount) {
    this.name = name;
    this.price = price;
    this.discount = discount;
  }

  public void addCantity(int cantity) {
    this.cantity += cantity;

    totalPrice += cantity * price;
    totalWithDiscount = totalPrice * discount;
  }
}

public class TiendaRopa {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final float discount = 0.9f;

    Ropa vestidosConMangas = new Ropa("Vestido con mangas", 500, discount);
    Ropa vestidosSinMangas = new Ropa("Vestido sin mangas", 450, discount);
    Ropa blusas = new Ropa("Blusa", 450, discount);
    Ropa pantalones = new Ropa("Pantalon", 600, discount);
    Ropa camisas = new Ropa("Camisa", 300, discount);

    // Ropa[] compra = { vestidosConMangas, vestidosSinMangas, blusas, pantalones, camisas };

    System.out.println("TIENDA DE ROPA");
    int opcion;
    do {
      System.out.println();
      System.out.println("1. Vestidos");
      System.out.printf("2. Blusas ($%.2f) \n", blusas.price);
      System.out.printf("3. Pantalones ($%.2f) \n", pantalones.price);
      System.out.printf("4. Camisas ($%.2f) \n", camisas.price);
      System.out.println("5. Salir");
      System.out.print("Eliga la prenda de ropa: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          System.out.printf("1. Con mangas ($%.2f) \n", vestidosConMangas.price);
          System.out.printf("2. Sin mangas ($%.2f) \n", vestidosSinMangas.price);
          System.out.print("Opcion: ");
          int opcionVestido = scanner.nextInt();

          if (opcionVestido == 1) vestidosConMangas.addCantity(1);
          else if(opcionVestido == 2) vestidosSinMangas.addCantity(1);
          else System.out.println("Opcion invalida.");
          break;

        case 2: blusas.addCantity(1); break;
        case 3: pantalones.addCantity(1); break;
        case 4: camisas.addCantity(1); break;
        case 5: System.out.println("Saliendo..."); break;
      
        default:
          System.out.println("Opcion invalida. Intente de nuevo.");
          break;
      }
      
    } while (opcion != 5);

    Ropa[] compras = { vestidosConMangas, vestidosSinMangas, blusas, pantalones, camisas };

    double total = 0;
    for (Ropa compra: compras) {
      if (compra.cantity > 0) {
        System.out.printf(
          "%s: %d x %.2f - 10 = %.2f\n", 
          compra.name, compra.cantity, compra.price, compra.totalWithDiscount
        );
        total += compra.totalWithDiscount;
      }
    }

    System.out.println("-------------------------");
    System.out.printf("Total: %.2f", total);

    scanner.close();
  }
}
