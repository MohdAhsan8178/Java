// Question 3: Create a program that creates two threads. The first thread should print "Thread 1" every 1 second, and the second thread should print "Thread 2" every 2 seconds.

public class Q03_ThreadSleepTwoThreads {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Thread Concepts and Implementation ---");
        System.out.println("--- Q3: Thread Sleep Method with Two Threads ---\n");

        // Thread 1: Prints "Thread 1" every 1000ms (1 second) for 5 iterations
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("[1s Interval] Thread 1 - Iteration " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-1");

        // Thread 2: Prints "Thread 2" every 2000ms (2 seconds) for 3 iterations
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("  [2s Interval] Thread 2 - Iteration " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Thread 2 interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-2");

        // Starting both threads concurrently
        thread1.start();
        thread2.start();

        // Waiting for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\nBoth threads have completed execution.");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
