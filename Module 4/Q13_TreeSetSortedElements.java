// Question: Write a program to demonstrate the use of TreeSet for storing sorted elements.

import java.util.Set;
import java.util.TreeSet;

public class Q13_TreeSetSortedElements {
    public static void main(String[] args) {
        System.out.println("--- Section 4: Set Interface ---");
        System.out.println("--- Q13: TreeSet Storing Sorted Elements Demo ---\n");

        // Creating a TreeSet of integers (stores elements in Red-Black Tree, sorted naturally)
        Set<Integer> scores = new TreeSet<>();

        // Adding unsorted scores
        scores.add(85);
        scores.add(42);
        scores.add(99);
        scores.add(67);
        scores.add(85); // Duplicate - will be ignored
        scores.add(12);

        System.out.println("Inserted Elements : 85, 42, 99, 67, 85 (duplicate), 12");
        System.out.println("TreeSet Output    : " + scores);
        System.out.println("(Notice: Elements are automatically sorted in ascending order and duplicates are removed)\n");

        // TreeSet with Strings
        Set<String> countries = new TreeSet<>();
        countries.add("India");
        countries.add("USA");
        countries.add("Germany");
        countries.add("Australia");
        countries.add("Canada");

        System.out.println("Countries TreeSet (Alphabetical Order):");
        for (String country : countries) {
            System.out.println("  - " + country);
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
