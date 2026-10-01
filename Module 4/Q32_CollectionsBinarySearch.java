// Question: Write a program to perform a binary search on a List using the Collections.binarySearch() method.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q32_CollectionsBinarySearch {
    public static void main(String[] args) {
        System.out.println("--- Section 9: Utility Methods in Collections Class ---");
        System.out.println("--- Q32: Binary Search on List using Collections.binarySearch() ---\n");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(45, 12, 85, 32, 89, 3, 67, 101, 23));
        System.out.println("Unsorted List: " + numbers);

        // Precondition for Binary Search: List MUST be sorted in ascending order
        Collections.sort(numbers);
        System.out.println("Sorted List  : " + numbers);

        // Case 1: Searching for an existing key
        int target1 = 67;
        int index1 = Collections.binarySearch(numbers, target1);
        System.out.println("\nSearch Key: " + target1);
        if (index1 >= 0) {
            System.out.println("  [FOUND] Key " + target1 + " found at index: " + index1);
        } else {
            System.out.println("  [NOT FOUND] Key " + target1 + " is not in the list.");
        }

        // Case 2: Searching for a non-existing key (Returns (-(insertion point) - 1))
        int target2 = 50;
        int index2 = Collections.binarySearch(numbers, target2);
        System.out.println("\nSearch Key: " + target2);
        if (index2 >= 0) {
            System.out.println("  [FOUND] Key " + target2 + " found at index: " + index2);
        } else {
            int insertionPoint = -index2 - 1;
            System.out.println("  [NOT FOUND] Key " + target2 + " returned index: " + index2);
            System.out.println("  (It should be inserted at index " + insertionPoint + " to maintain sorted order)");
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
