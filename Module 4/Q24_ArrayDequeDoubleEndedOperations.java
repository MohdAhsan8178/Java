// Question: Implement a deque using the ArrayDeque class. Perform operations like: Add elements at both ends. Remove elements from both ends. Peek at both ends.

import java.util.ArrayDeque;
import java.util.Deque;

public class Q24_ArrayDequeDoubleEndedOperations {
    public static void main(String[] args) {
        System.out.println("--- Section 6: Queue and Stack ---");
        System.out.println("--- Q24: Double-Ended Queue (ArrayDeque) Operations ---\n");

        Deque<Integer> deque = new ArrayDeque<>();

        // 1. Add elements at both ends
        System.out.println("1. Adding Elements at Both Ends:");
        deque.addFirst(20);
        System.out.println("   addFirst(20) -> " + deque);
        deque.addFirst(10);
        System.out.println("   addFirst(10) -> " + deque);
        deque.addLast(30);
        System.out.println("   addLast(30)  -> " + deque);
        deque.addLast(40);
        System.out.println("   addLast(40)  -> " + deque);

        // 2. Peek at both ends
        System.out.println("\n2. Peeking at Both Ends:");
        System.out.println("   peekFirst() (Head): " + deque.peekFirst());
        System.out.println("   peekLast()  (Tail): " + deque.peekLast());

        // 3. Remove elements from both ends
        System.out.println("\n3. Removing Elements from Both Ends:");
        int removedFirst = deque.removeFirst();
        System.out.println("   removeFirst() -> Removed: " + removedFirst + " | Remaining: " + deque);
        int removedLast = deque.removeLast();
        System.out.println("   removeLast()  -> Removed: " + removedLast + " | Remaining: " + deque);

        System.out.println("\nFinal Deque State: " + deque);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
