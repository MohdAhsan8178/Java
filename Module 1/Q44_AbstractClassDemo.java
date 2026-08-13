// Question 44: Implement an abstract class and override its methods in a subclass.

// Abstract Class
abstract class Shape {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    // Concrete method in abstract class
    public void displayColor() {
        System.out.println("Shape color: " + color);
    }

    // Abstract method (must be implemented by concrete subclasses)
    public abstract double calculateArea();
}

// Subclass implementing abstract class
class CircleShape extends Shape {
    double radius;

    public CircleShape(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Q44_AbstractClassDemo {
    public static void main(String[] args) {
        System.out.println("--- Abstract Class Demo ---");

        Shape c = new CircleShape("Red", 7.0);
        c.displayColor();
        System.out.printf("Area of Circle: %.2f\n", c.calculateArea());
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
