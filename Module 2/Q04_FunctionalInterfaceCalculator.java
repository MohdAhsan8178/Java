// Question 4: Define a functional interface Calculator with a method int compute(int a, int b). Use a lambda expression to provide implementation for addition, subtraction, and multiplication.

// Functional Interface: An interface with exactly one abstract method
@FunctionalInterface
interface Calculator {
    int compute(int a, int b);
}

public class Q04_FunctionalInterfaceCalculator {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Interfaces & Lambda Expressions ---");
        System.out.println("--- Q4: Functional Interface Calculator Demo ---\n");

        int x = 20;
        int y = 5;

        // 1. Lambda expression for Addition
        Calculator addition = (a, b) -> a + b;

        // 2. Lambda expression for Subtraction
        Calculator subtraction = (a, b) -> a - b;

        // 3. Lambda expression for Multiplication
        Calculator multiplication = (a, b) -> a * b;

        // Executing the lambda expressions using compute()
        int sum = addition.compute(x, y);
        int difference = subtraction.compute(x, y);
        int product = multiplication.compute(x, y);

        System.out.println("Input values: a = " + x + ", b = " + y);
        System.out.println("------------------------------------");
        System.out.println("Addition       : " + x + " + " + y + " = " + sum);
        System.out.println("Subtraction    : " + x + " - " + y + " = " + difference);
        System.out.println("Multiplication : " + x + " * " + y + " = " + product);

        // Demonstrating dynamic/custom lambda expression passed inline
        System.out.println("\n--- Inline Lambda Execution ---");
        Calculator modulus = (a, b) -> a % b;
        System.out.println("Modulus        : " + x + " % " + y + " = " + modulus.compute(x, y));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
