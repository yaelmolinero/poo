package code.ev2;

class Persona {
  public Persona() {}

  public void caminar() {
    System.out.println("La persona camina");
  }
}

class Estudiante extends Persona {
  public Estudiante() {}

  public void estudiar() {
    System.out.println("El estudiante estudia");
  }
}

class Profesor extends Persona {
  public Profesor() {}

  public void enseñar() {
    System.out.println("El profesor enseña");
  }
}

public class Personas {
  public static void main(String[] args) {
    Estudiante estudiante = new Estudiante();
    Profesor profesor = new Profesor();

    estudiante.caminar();
    estudiante.estudiar();

    profesor.caminar();
    profesor.enseñar();
  }
}
