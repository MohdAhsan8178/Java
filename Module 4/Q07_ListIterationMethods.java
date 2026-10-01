// Question: Write a program to iterate over a List of integers using: A simple for loop, An enhanced for loop, A while loop with an Iterator.

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Q07_ListIterationMethods {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Collection Framework ---");
        System.out.println("--- Q07: List Iteration Techniques ---\n");

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("Original List: " + numbers + "\n");

        // 1. Using a simple for loop (indexed access)
        System.out.print("1. Simple for loop (index-based)     : ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        // 2. Using an enhanced for-each loop
        System.out.print("2. Enhanced for-each loop            : ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 3. Using a while loop with an Iterator
        System.out.print("3. While loop with Iterator<Integer> : ");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
