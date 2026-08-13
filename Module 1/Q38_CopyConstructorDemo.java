// Question 38: Implement a program to demonstrate the use of a copy constructor in Java.

class ComplexNumber {
    double real;
    double imaginary;

    // Parameterized constructor
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Copy Constructor
    public ComplexNumber(ComplexNumber other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    public void display() {
        System.out.println(real + " + " + imaginary + "i");
    }
}

public class Q38_CopyConstructorDemo {
    public static void main(String[] args) {
        System.out.println("--- Copy Constructor Demo ---");

        // Original object
        ComplexNumber c1 = new ComplexNumber(4.5, 3.2);
        System.out.print("Original Complex Number c1: ");
        c1.display();

        // Copying object c1 using copy constructor
        ComplexNumber c2 = new ComplexNumber(c1);
        System.out.print("Copied Complex Number c2:   ");
        c2.display();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
