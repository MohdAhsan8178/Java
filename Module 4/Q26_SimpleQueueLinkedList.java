// Question: Write a program to implement a simple Queue using the LinkedList class.

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Q26_SimpleQueueLinkedList {

    // Custom Queue wrapper around java.util.LinkedList
    static class SimpleQueue<E> {
        private final LinkedList<E> list = new LinkedList<>();

        // Enqueue: Add element to the tail of the list
        public void enqueue(E item) {
            list.addLast(item);
        }

        // Dequeue: Remove and return the element at the head of the list
        public E dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty!");
            }
            return list.removeFirst();
        }

        // Peek: View front element without removing
        public E peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty!");
            }
            return list.getFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int size() {
            return list.size();
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 7: Specialized Classes ---");
        System.out.println("--- Q26: Simple FIFO Queue Implementation using LinkedList ---\n");

        SimpleQueue<String> printJobs = new SimpleQueue<>();

        // Enqueue operations
        printJobs.enqueue("Document_A.pdf");
        printJobs.enqueue("Spreadsheet_Q3.xlsx");
        printJobs.enqueue("Presentation_Final.pptx");
        printJobs.enqueue("Resume_Ahsan.docx");

        System.out.println("Print Queue Contents : " + printJobs);
        System.out.println("Total Jobs in Queue  : " + printJobs.size());
        System.out.println("Next Job to Print    : " + printJobs.peek() + "\n");

        // Dequeue operations
        System.out.println("--- Processing Print Queue (FIFO) ---");
        while (!printJobs.isEmpty()) {
            System.out.println("Printing -> " + printJobs.dequeue());
        }

        System.out.println("\nAll jobs finished. Is queue empty? " + printJobs.isEmpty());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
