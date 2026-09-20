// Question 13: Write a Java program using the ReentrantLock class to create a simple counter that can be safely incremented by multiple threads. Compare the result with the version that does not use a lock.

import java.util.concurrent.locks.ReentrantLock;

// 1. Thread-safe counter using ReentrantLock
class LockedCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire lock
        try {
            count++;
        } finally {
            lock.unlock(); // Always release lock in finally block
        }
    }

    public int getCount() {
        return count;
    }
}

// 2. Unsafe counter without locking (Demonstrates Race Condition)
class UnsafeCounter {
    private int count = 0;

    public void increment() {
        count++; // Non-atomic read-modify-write operation
    }

    public int getCount() {
        return count;
    }
}

public class Q13_ReentrantLockCounter {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Section 3: Lock Interface ---");
        System.out.println("--- Q13: ReentrantLock vs Unsynchronized Counter ---\n");

        int numThreads = 5;
        int incrementsPerThread = 2000;
        int expectedCount = numThreads * incrementsPerThread;

        System.out.println("Test Configuration: " + numThreads + " threads, each incrementing " + incrementsPerThread + " times.");
        System.out.println("Expected Final Count: " + expectedCount + "\n");

        // PART 1: Safe Counter with ReentrantLock
        LockedCounter safeCounter = new LockedCounter();
        Thread[] safeThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            safeThreads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    safeCounter.increment();
                }
            });
            safeThreads[i] = safeThreads[i];
            safeThreads[i].start();
        }
        for (Thread t : safeThreads) {
            t.join();
        }

        System.out.println("1. With ReentrantLock : Result = " + safeCounter.getCount() + " (MATCHES EXPECTED: " + (safeCounter.getCount() == expectedCount) + ")");

        // PART 2: Unsafe Counter without Lock
        UnsafeCounter unsafeCounter = new UnsafeCounter();
        Thread[] unsafeThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            unsafeThreads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    unsafeCounter.increment();
                }
            });
            unsafeThreads[i].start();
        }
        for (Thread t : unsafeThreads) {
            t.join();
        }

        System.out.println("2. Without Lock (Unsafe): Result = " + unsafeCounter.getCount() + " (Data race / inconsistency observed)");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
