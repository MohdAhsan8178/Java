// Question 6: Implement a method reference in a program to find the square of a number using a static method.

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Functional interface to represent square calculation
@FunctionalInterface
interface SquareCalculator {
    int findSquare(int number);
}

// Utility class containing the static method
class MathOperations {
    /**
     * Static method to calculate the square of a given integer.
     *
     * @param n the input number
     * @return the square of n (n * n)
     */
    public static int square(int n) {
        return n * n;
    }
}

public class Q06_MethodReferenceSquare {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Interfaces & Method References ---");
        System.out.println("--- Q6: Static Method Reference for Square Calculation ---\n");

        // 1. Using Custom Functional Interface with Static Method Reference
        // Syntax: ClassName::staticMethodName
        SquareCalculator calculator = MathOperations::square;

        int num = 8;
        int result = calculator.findSquare(num);
        System.out.println("Input Number : " + num);
        System.out.println("Square Result (via SquareCalculator) : " + result);

        // 2. Using Built-in java.util.function.Function with Method Reference
        Function<Integer, Integer> squareFunction = MathOperations::square;
        int anotherNum = 12;
        System.out.println("\nInput Number : " + anotherNum);
        System.out.println("Square Result (via Function<Integer, Integer>) : " + squareFunction.apply(anotherNum));

        // 3. Applying Method Reference across a List of Numbers using Streams
        System.out.println("\n--- Calculating Squares for a List of Numbers ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Original Numbers: " + numbers);

        System.out.print("Squared Numbers : ");
        numbers.stream()
               .map(MathOperations::square) // Static method reference in Stream API
               .forEach(sq -> System.out.print(sq + " "));
        System.out.println();

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
