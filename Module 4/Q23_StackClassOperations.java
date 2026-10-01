// Question: Write a program to implement a Stack using the Stack class. Perform operations like push, pop, peek, and check if it is empty.

import java.util.Stack;

public class Q23_StackClassOperations {
    public static void main(String[] args) {
        System.out.println("--- Section 6: Queue and Stack ---");
        System.out.println("--- Q23: Standard java.util.Stack Class Operations ---\n");

        Stack<String> browserHistory = new Stack<>();

        // 1. Check if stack is empty initially
        System.out.println("1. Is browser history empty? " + browserHistory.isEmpty());

        // 2. Push operations (LIFO - Last In First Out)
        System.out.println("\n2. Pushing pages to history stack:");
        browserHistory.push("https://google.com");
        System.out.println("   Pushed: google.com");
        browserHistory.push("https://github.com");
        System.out.println("   Pushed: github.com");
        browserHistory.push("https://stackoverflow.com");
        System.out.println("   Pushed: stackoverflow.com");
        browserHistory.push("https://oracle.com/java");
        System.out.println("   Pushed: oracle.com/java");

        System.out.println("   Current Stack: " + browserHistory);

        // 3. Peek operation (view top without removing)
        System.out.println("\n3. Peek Current Active Page (peek()): " + browserHistory.peek());

        // 4. Pop operation (navigate back by removing top page)
        System.out.println("\n4. Popping Pages (Navigating Back):");
        System.out.println("   Popped: " + browserHistory.pop());
        System.out.println("   New Top Page: " + browserHistory.peek());
        System.out.println("   Popped: " + browserHistory.pop());
        System.out.println("   Stack After 2 Pops: " + browserHistory);

        // 5. Search operation (1-based position from top of stack)
        System.out.println("\n5. Searching 'https://google.com' position from top (search()): " + browserHistory.search("https://google.com"));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
