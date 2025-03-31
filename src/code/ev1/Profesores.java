package code.ev1;
import java.util.Scanner;

class Profesor {
  private String nombre, materia;
  private int edad;

  public Profesor(String nombre, String materia, int edad) {
    this.nombre = nombre;
    this.materia = materia;
    this.edad = edad;
  }

  public void datosProfesor() {
    System.out.println("Nombre: " + nombre);
    System.out.println("Materia: " + materia);
    System.out.println("Edad: " + edad);
  }
}

public class Profesores {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el nombre del profesor:");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese la materia que imparte:");
    String materia = scanner.nextLine();

    System.out.print("Ingrese la edad del profesor:");
    int edad = scanner.nextInt();
    
    scanner.close();

    Profesor profesor = new Profesor(nombre, materia, edad);
    profesor.datosProfesor();
  }
}
