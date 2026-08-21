package shapes;

/**
 * Rectangle class implementing the Shape interface.
 * Belongs to the user-defined package 'shapes'.
 */
public class Rectangle implements Shape {
    private double length;
    private double width;

    /**
     * Parameterized constructor to initialize length and width.
     *
     * @param length the length of the rectangle
     * @param width  the width of the rectangle
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}
