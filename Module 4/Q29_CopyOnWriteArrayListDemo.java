// Question: Write a program using CopyOnWriteArrayList to iterate and modify a list safely in a multithreaded environment.

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q29_CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Section 8: Concurrency and Thread-Safety ---");
        System.out.println("--- Q29: CopyOnWriteArrayList Safe Concurrent Iteration & Modification ---\n");

        // CopyOnWriteArrayList creates a fresh copy of the underlying array whenever a mutating operation (add, set, remove) occurs
        CopyOnWriteArrayList<String> subscriberList = new CopyOnWriteArrayList<>();
        subscriberList.add("User_Alpha");
        subscriberList.add("User_Beta");
        subscriberList.add("User_Gamma");

        System.out.println("Initial Subscribers: " + subscriberList + "\n");

        // Thread 1: Iterates through the list
        Thread readerThread = new Thread(() -> {
            System.out.println("Reader Thread started iterating...");
            Iterator<String> it = subscriberList.iterator();
            while (it.hasNext()) {
                String sub = it.next();
                System.out.println("  [Reader Thread] Reading: " + sub);
                try {
                    Thread.sleep(150); // Simulate processing latency
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Reader Thread finished iterating without ConcurrentModificationException!");
        }, "ReaderThread");

        // Thread 2: Modifies the list concurrently while Thread 1 is iterating
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(50); // Ensure reader has started iterating
                System.out.println("\n  >> [Writer Thread] Adding 'User_Delta' and 'User_Epsilon'...");
                subscriberList.add("User_Delta");
                subscriberList.add("User_Epsilon");
                System.out.println("  >> [Writer Thread] Modification complete.\n");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "WriterThread");

        readerThread.start();
        writerThread.start();

        readerThread.join();
        writerThread.join();

        System.out.println("\nFinal State of List: " + subscriberList);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
