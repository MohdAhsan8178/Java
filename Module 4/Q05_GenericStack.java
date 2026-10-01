// Question: Develop a user-defined generic class Stack<T> that provides standard stack operations like push(T item), pop(), and peek(). Demonstrate with integers and strings.

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Q05_GenericStack {

    // User-defined generic Stack implementation using an internal List
    static class CustomGenericStack<T> {
        private final List<T> elements = new ArrayList<>();

        public void push(T item) {
            elements.add(item);
        }

        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return elements.remove(elements.size() - 1);
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return elements.get(elements.size() - 1);
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }

        public int size() {
            return elements.size();
        }

        @Override
        public String toString() {
            return elements.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 1: Generics ---");
        System.out.println("--- Q05: Generic Stack<T> Implementation Demo ---\n");

        // 1. Integer Stack Demonstration
        System.out.println("1. Testing Stack<Integer>:");
        CustomGenericStack<Integer> intStack = new CustomGenericStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("   Stack after pushes : " + intStack);
        System.out.println("   Peek top element   : " + intStack.peek());
        System.out.println("   Popped element     : " + intStack.pop());
        System.out.println("   Stack after pop    : " + intStack);

        // 2. String Stack Demonstration
        System.out.println("\n2. Testing Stack<String>:");
        CustomGenericStack<String> stringStack = new CustomGenericStack<>();
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");
        System.out.println("   Stack after pushes : " + stringStack);
        System.out.println("   Peek top element   : " + stringStack.peek());
        System.out.println("   Popped element     : " + stringStack.pop());
        System.out.println("   Popped element     : " + stringStack.pop());
        System.out.println("   Stack after pops   : " + stringStack);
        System.out.println("   Is stack empty?    : " + stringStack.isEmpty());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
