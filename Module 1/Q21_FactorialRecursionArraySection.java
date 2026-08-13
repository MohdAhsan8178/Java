// Question 21: Write a program to calculate the factorial of a given number using recursion.

public class Q21_FactorialRecursionArraySection {

    // Recursive function for factorial
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 6;
        long fact = factorial(n);

        System.out.println("--- Recursive Factorial Calculation ---");
        System.out.println("Factorial of " + n + " = " + fact);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
