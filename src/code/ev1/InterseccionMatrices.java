package code.ev1;
import java.util.Scanner;

class Matrices {
  private int[][] matriz1 = new int[2][2];
  private int[][] matriz2 = new int[2][2];
  private Scanner scanner = new Scanner(System.in);

  public Matrices() {}

  public void llenarMatriz1() {
    System.out.println("Ingrese los elementos de la matriz 1:");
    for (int i = 0; i < matriz1.length; i++) {
      for (int j = 0; j < matriz1[i].length; j++) {
        System.out.printf("Elemento [%d][%d]: ", i, j);
        matriz1[i][j] = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
      }
    }
  }

  public void llenarMatriz2() {
    System.out.println("Ingrese los elementos de la matriz 2:");
    for (int i = 0; i < matriz2.length; i++) {
      for (int j = 0; j < matriz2[i].length; j++) {
        System.out.printf("Elemento [%d][%d]: ", i, j);
        matriz2[i][j] = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
      }
    }
  }

  public void interseccionMatrices() {
    int elementosComunes = 0;
    System.out.println("Intersección de las matrices:");
    
    for (int i = 0; i < matriz1.length; i++) {
      for (int j = 0; j < matriz1[i].length; j++) {
        int numeroAComparar = matriz1[i][j];
        boolean encontrado = false;
        
        for (int k = 0; k < matriz2.length; k++) {
          for (int l = 0; l < matriz2[k].length; l++) {
            if (numeroAComparar == matriz2[k][l]) {
              System.out.println("Elemento común encontrado: " + numeroAComparar);
              elementosComunes++;
              encontrado = true;
              break;
            }
          }
          if (encontrado) break; // Salir del bucle si se encontró el elemento
        }
      }
    }

    System.out.println("Total de elementos comunes: " + elementosComunes);
  }

  public void closeScanner() {
    scanner.close();
  }
}

public class InterseccionMatrices {
  public static void main(String[] args) {
    Matrices matrices = new Matrices();
    matrices.llenarMatriz1();
    matrices.llenarMatriz2();
    matrices.interseccionMatrices();
    matrices.closeScanner();
  }
}
