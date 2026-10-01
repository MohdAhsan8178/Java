// Question: Implement a simple program using Queue (with LinkedList) to simulate a ticket booking system.

import java.util.LinkedList;
import java.util.Queue;

public class Q21_QueueTicketBookingSystem {
    public static void main(String[] args) {
        System.out.println("--- Section 6: Queue and Stack ---");
        System.out.println("--- Q21: Ticket Booking Queue Simulation using LinkedList ---\n");

        // Creating a FIFO Queue using LinkedList
        Queue<String> bookingQueue = new LinkedList<>();

        // Customers arriving and joining the queue (enqueue via offer/add)
        bookingQueue.offer("Mohd Ahsan (Ticket #1)");
        bookingQueue.offer("Zaid Khan (Ticket #2)");
        bookingQueue.offer("Hamza Ali (Ticket #3)");
        bookingQueue.offer("Bilal Ahmed (Ticket #4)");
        bookingQueue.offer("Faizan Siddiqui (Ticket #5)");

        System.out.println("Initial Customer Waiting Queue: " + bookingQueue);
        System.out.println("Total Customers in Line       : " + bookingQueue.size());
        System.out.println("Next customer to be served    : " + bookingQueue.peek() + "\n");

        System.out.println("--- Serving Customers at Ticket Counter (FIFO Order) ---");
        int counter = 1;
        while (!bookingQueue.isEmpty()) {
            // poll() retrieves and removes the head of the queue
            String servedCustomer = bookingQueue.poll();
            System.out.println("Served " + counter++ + ": " + servedCustomer + " -> [Booking Confirmed]");
            System.out.println("  Remaining in Queue: " + bookingQueue.size());
        }

        System.out.println("\nAll customers served! Queue is empty: " + bookingQueue.isEmpty());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
