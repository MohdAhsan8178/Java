// Question: Write a generic class Pair<K, V> that holds two values of any types, K and V. Include methods to get and set the values.

public class Q02_GenericPair {

    // Generic class with two type parameters: K and V
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair [Key = " + key + ", Value = " + value + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 1: Generics ---");
        System.out.println("--- Q02: Generic Class Pair<K, V> Demo ---\n");

        // Pair 1: Integer Key, String Value (e.g., Roll No -> Student Name)
        Pair<Integer, String> student = new Pair<>(101, "Mohd Ahsan");
        System.out.println("Student Record : " + student);

        // Pair 2: String Key, Double Value (e.g., Currency -> Exchange Rate)
        Pair<String, Double> exchangeRate = new Pair<>("USD/INR", 83.45);
        System.out.println("Exchange Rate  : " + exchangeRate);

        // Updating values using setters
        student.setValue("Mohd Ahsan (Updated)");
        exchangeRate.setValue(84.10);

        System.out.println("\nAfter Modification:");
        System.out.println("Updated Student Key   : " + student.getKey());
        System.out.println("Updated Student Value : " + student.getValue());
        System.out.println("Updated Exchange Rate : " + exchangeRate.getValue());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
