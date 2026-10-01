// Question: Implement a generic class MinMaxFinder<T extends Comparable<T>> that provides methods findMin() and findMax() to find the minimum and maximum elements in a list. Demonstrate it with a list of integers and strings.

import java.util.Arrays;
import java.util.List;

public class Q06_GenericMinMaxFinder {

    // Generic class bounded by Comparable<T> to allow natural ordering comparisons
    static class MinMaxFinder<T extends Comparable<T>> {

        public T findMin(List<T> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("List must not be null or empty.");
            }
            T min = list.get(0);
            for (T item : list) {
                if (item.compareTo(min) < 0) {
                    min = item;
                }
            }
            return min;
        }

        public T findMax(List<T> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("List must not be null or empty.");
            }
            T max = list.get(0);
            for (T item : list) {
                if (item.compareTo(max) > 0) {
                    max = item;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 1: Generics ---");
        System.out.println("--- Q06: Generic MinMaxFinder<T extends Comparable<T>> Demo ---\n");

        // 1. Finding Min/Max in a List of Integers
        List<Integer> numbers = Arrays.asList(45, 12, 89, 3, 67, 102, -15, 54);
        MinMaxFinder<Integer> intFinder = new MinMaxFinder<>();
        System.out.println("Integer List: " + numbers);
        System.out.println("Minimum Element : " + intFinder.findMin(numbers));
        System.out.println("Maximum Element : " + intFinder.findMax(numbers));

        // 2. Finding Min/Max in a List of Strings
        List<String> names = Arrays.asList("Zaid", "Ahsan", "Hamza", "Bilal", "Faizan");
        MinMaxFinder<String> stringFinder = new MinMaxFinder<>();
        System.out.println("\nString List: " + names);
        System.out.println("Minimum String (Alphabetical) : " + stringFinder.findMin(names));
        System.out.println("Maximum String (Alphabetical) : " + stringFinder.findMax(names));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
