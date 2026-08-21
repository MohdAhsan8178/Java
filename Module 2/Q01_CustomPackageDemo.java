// Question 1: Create a Java package utilities that contains a class MathUtils with a method add(int a, int b) to return the sum of two numbers. Demonstrate the use of this package in another class.

// Importing the user-defined package and class
import utilities.MathUtils;

public class Q01_CustomPackageDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Packages ---");
        System.out.println("--- Q1: Custom Package 'utilities' Demo ---");

        int num1 = 45;
        int num2 = 30;

        // Calling the static method add() from the imported MathUtils class
        int result = MathUtils.add(num1, num2);

        System.out.println("First Number  : " + num1);
        System.out.println("Second Number : " + num2);
        System.out.println("Sum (using utilities.MathUtils.add) : " + result);

        // Additional demonstration with negative and zero values
        int num3 = -15;
        int num4 = 25;
        System.out.println("\nAdditional Test:");
        System.out.println(num3 + " + " + num4 + " = " + MathUtils.add(num3, num4));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
