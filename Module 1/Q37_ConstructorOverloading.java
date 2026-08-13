// Question 37: Write a program to create a class with multiple constructors (constructor overloading).

class Box {
    double width, height, depth;

    // Constructor 1: Default constructor (cube of unit dimensions)
    public Box() {
        this.width = 1.0;
        this.height = 1.0;
        this.depth = 1.0;
    }

    // Constructor 2: Single parameter constructor (Cube)
    public Box(double len) {
        this.width = len;
        this.height = len;
        this.depth = len;
    }

    // Constructor 3: Parameterized constructor (Cuboid)
    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getVolume() {
        return width * height * depth;
    }
}

public class Q37_ConstructorOverloading {
    public static void main(String[] args) {
        System.out.println("--- Constructor Overloading Demo ---");

        Box box1 = new Box();
        Box box2 = new Box(5.0);
        Box box3 = new Box(3.0, 4.0, 5.0);

        System.out.println("Box 1 (Default) Volume: " + box1.getVolume());
        System.out.println("Box 2 (Cube) Volume:    " + box2.getVolume());
        System.out.println("Box 3 (Cuboid) Volume:  " + box3.getVolume());
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
