package shapes;

/**
 * Circle class implementing the Shape interface.
 * Belongs to the user-defined package 'shapes'.
 */
public class Circle implements Shape {
    private double radius;

    /**
     * Parameterized constructor to initialize radius.
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
