// Question: Create a TreeSet of integers and perform the following operations: Add elements to the set. Find the smallest and largest elements. Remove a specific element.

import java.util.TreeSet;

public class Q15_TreeSetOperations {
    public static void main(String[] args) {
        System.out.println("--- Section 4: Set Interface ---");
        System.out.println("--- Q15: TreeSet Navigation and Modification Operations ---\n");

        TreeSet<Integer> numberSet = new TreeSet<>();

        // 1. Add elements
        numberSet.add(55);
        numberSet.add(12);
        numberSet.add(89);
        numberSet.add(34);
        numberSet.add(7);
        numberSet.add(99);
        numberSet.add(23);

        System.out.println("1. TreeSet Elements (Sorted)       : " + numberSet);

        // 2. Find smallest (first) and largest (last) elements
        int smallest = numberSet.first();
        int largest = numberSet.last();
        System.out.println("2. Smallest Element (first())       : " + smallest);
        System.out.println("   Largest Element (last())         : " + largest);

        // Additional NavigableSet methods
        System.out.println("   Element strictly lower than 34   : " + numberSet.lower(34));
        System.out.println("   Element strictly higher than 34  : " + numberSet.higher(34));

        // 3. Remove a specific element (e.g., 55)
        boolean isRemoved = numberSet.remove(55);
        System.out.println("\n3. Removing Element 55 -> Success  : " + isRemoved);
        System.out.println("   TreeSet After Removal            : " + numberSet);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
