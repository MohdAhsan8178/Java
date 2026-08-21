// Question 2: Define a package shapes containing an interface Shape with methods double area() and double perimeter(). Implement the interface in classes Circle and Rectangle.

// Importing classes and interface from package 'shapes'
import shapes.Shape;
import shapes.Circle;
import shapes.Rectangle;

public class Q02_PackageShapesDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Packages & Interfaces ---");
        System.out.println("--- Q2: Package 'shapes' Interface & Implementations Demo ---\n");

        // Interface reference holding a Circle object (Polymorphism)
        Shape circle = new Circle(7.0);
        System.out.println("1. Shape: Circle");
        System.out.println("   Radius    : 7.0 units");
        System.out.printf("   Area      : %.2f sq. units%n", circle.area());
        System.out.printf("   Perimeter : %.2f units%n", circle.perimeter());

        System.out.println();

        // Interface reference holding a Rectangle object (Polymorphism)
        Shape rectangle = new Rectangle(8.0, 5.0);
        System.out.println("2. Shape: Rectangle");
        System.out.println("   Length    : 8.0 units");
        System.out.println("   Width     : 5.0 units");
        System.out.printf("   Area      : %.2f sq. units%n", rectangle.area());
        System.out.printf("   Perimeter : %.2f units%n", rectangle.perimeter());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
