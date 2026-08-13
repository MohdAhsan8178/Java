// Question 16: Create a program to calculate the factorial of a number using recursion.

public class Q16_FactorialRecursion {

    // Recursive method to calculate factorial
    public static long calculateFactorial(int n) {
        if (n < 0) {
            System.out.println("Factorial of negative numbers does not exist.");
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1; // Base case
        }
        return n * calculateFactorial(n - 1); // Recursive step
    }

    public static void main(String[] args) {
        int number = 5;
        long result = calculateFactorial(number);

        System.out.println("--- Factorial using Recursion ---");
        System.out.println("The factorial of " + number + " is: " + result);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
