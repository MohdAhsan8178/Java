// Question 24: Write a program to check whether a given number is prime.

public class Q24_PrimeCheck {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testNumber1 = 17;
        int testNumber2 = 24;

        System.out.println("--- Prime Number Check ---");
        System.out.println(testNumber1 + " is Prime? " + isPrime(testNumber1));
        System.out.println(testNumber2 + " is Prime? " + isPrime(testNumber2));
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
