// Question 23: Write a program to generate the first n terms of the Fibonacci series.

public class Q23_FibonacciSeries {

    public static void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        System.out.print("First " + n + " terms of Fibonacci series: ");

        long first = 0, second = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(first + (i == n ? "" : ", "));
            long next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Fibonacci Series Generator ---");
        generateFibonacci(10);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
