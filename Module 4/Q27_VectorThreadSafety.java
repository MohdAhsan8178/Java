// Question: Write a program to demonstrate the thread-safe nature of Vector by adding elements to it from multiple threads.

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Q27_VectorThreadSafety {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Section 8: Concurrency and Thread-Safety ---");
        System.out.println("--- Q27: Thread-Safe Vector vs Unsafe ArrayList Concurrent Add ---\n");

        int numThreads = 5;
        int additionsPerThread = 1000;
        int expectedSize = numThreads * additionsPerThread;

        System.out.println("Test Parameters: " + numThreads + " threads, each adding " + additionsPerThread + " items.");
        System.out.println("Expected Final Count: " + expectedSize + "\n");

        // 1. Thread-safe Vector test
        Vector<Integer> safeVector = new Vector<>();
        Thread[] vectorThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            vectorThreads[i] = new Thread(() -> {
                for (int j = 0; j < additionsPerThread; j++) {
                    safeVector.add(j);
                }
            });
            vectorThreads[i].start();
        }
        for (Thread t : vectorThreads) {
            t.join();
        }

        System.out.println("1. Vector Result (Synchronized methods)   : " + safeVector.size() + " (MATCHES: " + (safeVector.size() == expectedSize) + ")");

        // 2. Unsafe ArrayList test (Demonstrates race conditions & lost updates)
        List<Integer> unsafeList = new ArrayList<>();
        Thread[] listThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            listThreads[i] = new Thread(() -> {
                for (int j = 0; j < additionsPerThread; j++) {
                    unsafeList.add(j);
                }
            });
            listThreads[i].start();
        }
        for (Thread t : listThreads) {
            t.join();
        }

        System.out.println("2. ArrayList Result (Not Thread-Safe)    : " + unsafeList.size() + " (Discrepancy due to race conditions)");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
