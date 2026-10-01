// Question: Create a user-defined generic class Box<T> with methods addItem(T item) and getItem(). Demonstrate its usage with String and Integer types.

public class Q03_GenericBox {

    // User-defined generic Box class parameterized over type T
    static class Box<T> {
        private T item;

        public void addItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public boolean hasItem() {
            return item != null;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 1: Generics ---");
        System.out.println("--- Q03: Generic Class Box<T> Demo ---\n");

        // 1. Box holding a String
        Box<String> stringBox = new Box<>();
        stringBox.addItem("Java Collections & Generics Framework");
        System.out.println("1. String Box Content : \"" + stringBox.getItem() + "\"");

        // 2. Box holding an Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.addItem(2026);
        System.out.println("2. Integer Box Content: " + integerBox.getItem());

        // 3. Box holding custom Double
        Box<Double> doubleBox = new Box<>();
        doubleBox.addItem(99.95);
        System.out.println("3. Double Box Content : " + doubleBox.getItem());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
