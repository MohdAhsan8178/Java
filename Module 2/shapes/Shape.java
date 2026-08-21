package shapes;

/**
 * Shape interface defining common contract for geometric shapes.
 * Belongs to the user-defined package 'shapes'.
 */
public interface Shape {
    /**
     * Computes and returns the area of the shape.
     *
     * @return area as a double
     */
    double area();

    /**
     * Computes and returns the perimeter of the shape.
     *
     * @return perimeter as a double
     */
    double perimeter();
}
