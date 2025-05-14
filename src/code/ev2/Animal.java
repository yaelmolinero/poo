package code.ev2;

class ClaseAnimal {
  public ClaseAnimal() {}

  public void caminar() {
    System.out.println("El animal camina");
  }
}

class Perro extends ClaseAnimal {
  public Perro() {}

  public void hacerSonido() {
    System.out.println("El perro ladra");
  }
}

class Gato extends ClaseAnimal {
  public Gato() {}

  public void hacerSonido() {
    System.out.println("El gato maulla");
  }
}

public class Animal {
  public static void main(String[] args) {
    Perro perro = new Perro();
    Gato gato = new Gato();

    perro.caminar();
    perro.hacerSonido();
    
    gato.caminar();
    gato.hacerSonido();
  }
}
