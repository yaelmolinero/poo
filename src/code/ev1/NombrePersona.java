package code.ev1;
import java.util.Scanner;

class Persona {
  protected String nombre;

  public Persona(String nombre) {
    this.nombre = nombre;
  }

  public void mostrarNombre() {
    System.out.println("Nombre: " + this.nombre);
  }
}

public class NombrePersona {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese su nombre: ");
    String nombre = sc.next();

    sc.close();

    Persona persona = new Persona(nombre);
    persona.mostrarNombre();
  }
}
