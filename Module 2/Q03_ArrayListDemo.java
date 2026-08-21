// Question 3: Write a program to import classes from java.util and use ArrayList to store and display a list of integers.

import java.util.ArrayList;
import java.util.List;

public class Q03_ArrayListDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Packages ---");
        System.out.println("--- Q3: ArrayList from java.util Package Demo ---\n");

        // Creating an ArrayList of Integers using the java.util collection
        List<Integer> numbers = new ArrayList<>();

        // Adding elements to the ArrayList
        numbers.add(10);
        numbers.add(25);
        numbers.add(40);
        numbers.add(55);
        numbers.add(70);

        // Displaying the ArrayList directly
        System.out.println("Initial List of Integers: " + numbers);
        System.out.println("Total elements in list   : " + numbers.size());

        // Displaying elements using an enhanced for-loop
        System.out.print("\nIterating through list elements: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Performing operations: Accessing element, adding at index, removing element
        System.out.println("\n--- Performing List Operations ---");
        System.out.println("Element at index 2 (0-indexed): " + numbers.get(2));

        // Insert element at index 2
        numbers.add(2, 35);
        System.out.println("After inserting 35 at index 2: " + numbers);

        // Remove element at index 0
        int removed = numbers.remove(0);
        System.out.println("Removed element at index 0: " + removed);
        System.out.println("Updated List: " + numbers);

        // Calculating the sum of all elements in the list
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of all integers in the list: " + sum);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
