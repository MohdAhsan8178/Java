// Question: How do bounded type parameters work in generics? Write a generic class that accepts only subclasses of Number.

public class Q01_BoundedTypeParameters {

    // Generic class bounded by Number (accepts Integer, Double, Float, Long, etc.)
    static class NumericBox<T extends Number> {
        private T value;

        public NumericBox(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        // Method demonstrating operations allowed on Number type
        public double doubleValue() {
            return value.doubleValue();
        }

        public boolean isGreaterThan(NumericBox<?> other) {
            return this.doubleValue() > other.doubleValue();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 1: Generics ---");
        System.out.println("--- Q01: Bounded Type Parameters (<T extends Number>) ---\n");

        NumericBox<Integer> intBox = new NumericBox<>(100);
        NumericBox<Double> doubleBox = new NumericBox<>(75.5);
        NumericBox<Float> floatBox = new NumericBox<>(120.25f);

        System.out.println("Integer Box Value : " + intBox.getValue());
        System.out.println("Double Box Value  : " + doubleBox.getValue());
        System.out.println("Float Box Value   : " + floatBox.getValue());

        System.out.println("\nDouble Conversion Comparisons:");
        System.out.println("Is " + intBox.getValue() + " > " + doubleBox.getValue() + "? -> " + intBox.isGreaterThan(doubleBox));
        System.out.println("Is " + doubleBox.getValue() + " > " + floatBox.getValue() + "? -> " + doubleBox.isGreaterThan(floatBox));

        // Note: NumericBox<String> stringBox = new NumericBox<>("Hello"); // COMPILE ERROR: String does not extend Number

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
