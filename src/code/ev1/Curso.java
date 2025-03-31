package code.ev1;
import java.util.Scanner;

class Course{
  private String name, duration;
  private float price;

  public Course(String name, String duration, float price) {
    this.name = name;
    this.duration = duration;
    this.price = price;
  }

  public void courseDetails() {
    System.out.println("Course Name: " + name);
    System.out.println("Duration: " + duration);
    System.out.println("Price: " + price);
  }
}

public class Curso {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the course name: ");
    String name = scanner.nextLine();

    System.out.print("Enter the course duration: ");
    String duration = scanner.nextLine();

    System.out.print("Enter the course price: ");
    float price = scanner.nextFloat();
    
    scanner.close();

    Course course = new Course(name, duration, price);
    course.courseDetails();
  }
}
