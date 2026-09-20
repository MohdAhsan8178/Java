// Question 14: Write a program where two threads acquire two locks (lock1 and lock2) in opposite order, causing a deadlock. Then, fix the deadlock by using tryLock() with timeout.

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Q14_DeadlockResolutionTryLock {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    // Method demonstrating safe lock acquisition using tryLock() with timeout
    public static void safeTask(String threadName, ReentrantLock firstLock, ReentrantLock secondLock) {
        boolean acquiredFirst = false;
        boolean acquiredSecond = false;

        try {
            // Attempt to acquire first lock with timeout
            acquiredFirst = firstLock.tryLock(500, TimeUnit.MILLISECONDS);
            if (acquiredFirst) {
                System.out.println(threadName + ": Acquired First Lock.");
                Thread.sleep(100); // Simulate work

                System.out.println(threadName + ": Trying to acquire Second Lock...");
                acquiredSecond = secondLock.tryLock(500, TimeUnit.MILLISECONDS);

                if (acquiredSecond) {
                    System.out.println(threadName + ": [SUCCESS] Acquired BOTH locks! Executing critical work.");
                } else {
                    System.out.println(threadName + ": [TIMEOUT] Could not acquire Second Lock. Backing off to prevent deadlock!");
                }
            } else {
                System.out.println(threadName + ": [TIMEOUT] Could not acquire First Lock.");
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        } finally {
            // Release acquired locks safely
            if (acquiredSecond) {
                secondLock.unlock();
                System.out.println(threadName + ": Released Second Lock.");
            }
            if (acquiredFirst) {
                firstLock.unlock();
                System.out.println(threadName + ": Released First Lock.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 3: Lock Interface ---");
        System.out.println("--- Q14: Deadlock Resolution using ReentrantLock.tryLock(timeout) ---\n");

        System.out.println("Explanation:");
        System.out.println("Standard lock() without timeout can cause indefinite deadlock when locks are requested in reverse order.");
        System.out.println("Using tryLock(timeout) allows threads to time out, release their partial lock, and avoid deadlock.\n");

        // Thread A requests lock1 then lock2
        Thread threadA = new Thread(() -> safeTask("Thread-A", lock1, lock2), "Thread-A");

        // Thread B requests lock2 then lock1 (Opposite order)
        Thread threadB = new Thread(() -> safeTask("Thread-B", lock2, lock1), "Thread-B");

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted: " + e.getMessage());
        }

        System.out.println("\nExecution completed safely without freezing / deadlock!");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
