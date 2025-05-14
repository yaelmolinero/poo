package code.ev2;

interface Mensaje {
  void dialogo();

  default void despedida() {
    System.out.println("Hasta luego");
  }
}

class Dialogo1 implements Mensaje {
  @Override
  public void dialogo() {
    System.out.println("Hola desde diaologo 1");
  }

  @Override
  public void despedida() {
    System.out.println("Adios desde diaologo 1");
  }
}

class Dialogo2 implements Mensaje {
  @Override
  public void dialogo() {
    System.out.println("Hola desde diaologo 2");
  }
}

public class Interfaces {
  public static void main(String[] args) {
    Mensaje mensaje1 = new Dialogo1();
    Mensaje mensaje2 = new Dialogo2();

    mensaje1.dialogo();
    mensaje1.despedida();

    mensaje2.dialogo();
    mensaje2.despedida();
  } 
}
