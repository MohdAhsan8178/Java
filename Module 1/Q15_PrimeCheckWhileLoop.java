// Question 15: Write a program to check if a number is prime using a while loop.

public class Q15_PrimeCheckWhileLoop {
    public static void main(String[] args) {
        int num = 29; // Sample number to check
        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false;
        } else {
            int i = 2;
            // Loop from 2 up to num/2
            while (i <= num / 2) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
        }

        System.out.println("--- Prime Check Using While Loop ---");
        if (isPrime) {
            System.out.println(num + " is a Prime number.");
        } else {
            System.out.println(num + " is NOT a Prime number.");
        }
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
