package code.ev1;
import java.util.Scanner;

class Person {
  private String nombre, sexo;
  int edad;
  float peso;

  public Person(String nombre, String sexo, int edad, float peso) {
    this.nombre = nombre;
    this.sexo = sexo;
    this.edad = edad;
    this.peso = peso;
  }

  public void datosPersona() {
    System.out.println("Nombre: " + nombre);
    System.out.println("Sexo: " + sexo);
    System.out.println("Edad: " + edad);
    System.out.println("Peso: " + peso);
  }
}

public class Persona {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el nombre de la persona: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese el sexo de la persona: ");
    String sexo = scanner.nextLine();

    System.out.print("Ingrese la edad de la persona: ");
    int edad = scanner.nextInt();

    System.out.print("Ingrese el peso de la persona: ");
    float peso = scanner.nextFloat();
    
    scanner.close();

    Person persona = new Person(nombre, sexo, edad, peso);
    persona.datosPersona();
  }
}
