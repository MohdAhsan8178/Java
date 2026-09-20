// Question 11: Write a program where two threads print numbers from 1 to 20 alternately: one prints odd numbers, and the other prints even numbers. Use wait() and notify() for synchronization.

class NumberPrinter {
    private int number = 1;
    private final int maxLimit;

    public NumberPrinter(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    // Method to print odd numbers
    public synchronized void printOdd() {
        while (number <= maxLimit) {
            // If current number is even, wait for even thread to print
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            } else {
                System.out.println("Odd Thread  : " + number);
                number++;
                // Notify even thread that its turn is up
                notify();
            }
        }
    }

    // Method to print even numbers
    public synchronized void printEven() {
        while (number <= maxLimit) {
            // If current number is odd, wait for odd thread to print
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            } else {
                System.out.println("Even Thread : " + number);
                number++;
                // Notify odd thread that its turn is up
                notify();
            }
        }
    }
}

public class Q11_AlternatingEvenOddThreads {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Thread Synchronization ---");
        System.out.println("--- Q11: Alternating Odd and Even Numbers (1 to 20) ---\n");

        NumberPrinter printer = new NumberPrinter(20);

        Thread oddThread = new Thread(printer::printOdd, "OddThread");
        Thread evenThread = new Thread(printer::printEven, "EvenThread");

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted: " + e.getMessage());
        }

        System.out.println("\nAlternating sequence 1 to 20 completed successfully.");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
