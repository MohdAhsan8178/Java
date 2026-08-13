// Question 3: Explain and implement the concept of abstraction in Java using interfaces.

// Interface defining abstract methods (100% abstraction)
interface Drawable {
    void draw(); // implicitly public and abstract
}

// Class Circle implementing interface
class Circle implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }
}

// Class Rectangle implementing interface
class Rectangle implements Drawable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void draw() {
        System.out.println("Drawing a Rectangle of dimensions " + length + " x " + width);
    }
}

public class Q03_AbstractionInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("--- Abstraction Using Interface Demo ---");

        // Interface references pointing to implementing class objects
        Drawable shape1 = new Circle(5.0);
        Drawable shape2 = new Rectangle(4.0, 6.0);

        shape1.draw();
        shape2.draw();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
