// Question 10: Implement a producer-consumer scenario where one thread (producer) produces data and another thread (consumer) consumes it. Use the wait() and notify() methods for synchronization.

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Producer method: inserts item into buffer
    public synchronized void produce(int value) throws InterruptedException {
        // While buffer is full, producer must wait
        while (queue.size() == capacity) {
            System.out.println("  [Buffer Full] Producer waiting to produce item " + value + "...");
            wait();
        }

        queue.add(value);
        System.out.println("[PRODUCED] Item: " + value + " | Buffer size: " + queue.size() + "/" + capacity);

        // Notify consumer that an item is available
        notify();
    }

    // Consumer method: removes item from buffer
    public synchronized int consume() throws InterruptedException {
        // While buffer is empty, consumer must wait
        while (queue.isEmpty()) {
            System.out.println("  [Buffer Empty] Consumer waiting for new items...");
            wait();
        }

        int value = queue.remove();
        System.out.println("  [CONSUMED] Item: " + value + " | Buffer size: " + queue.size() + "/" + capacity);

        // Notify producer that space is available
        notify();
        return value;
    }
}

public class Q10_ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Thread Synchronization ---");
        System.out.println("--- Q10: Producer-Consumer Scenario using wait() and notify() ---\n");

        int bufferCapacity = 3;
        SharedBuffer buffer = new SharedBuffer(bufferCapacity);
        int totalItems = 6;

        // Producer Thread
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= totalItems; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(150); // Simulate production time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "ProducerThread");

        // Consumer Thread
        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= totalItems; i++) {
                try {
                    buffer.consume();
                    Thread.sleep(300); // Simulate consumption time (slower consumer)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "ConsumerThread");

        // Start both threads
        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted: " + e.getMessage());
        }

        System.out.println("\nAll items produced and consumed successfully.");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
