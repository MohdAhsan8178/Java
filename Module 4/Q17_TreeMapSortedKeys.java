// Question: Write a program to demonstrate the use of TreeMap for sorting keys.

import java.util.Map;
import java.util.TreeMap;

public class Q17_TreeMapSortedKeys {
    public static void main(String[] args) {
        System.out.println("--- Section 5: Map Interface ---");
        System.out.println("--- Q17: TreeMap for Natural Sorting of Keys ---\n");

        // TreeMap automatically sorts entries based on the natural ordering of keys
        Map<Integer, String> employeeDirectory = new TreeMap<>();

        // Inserting unsorted keys
        employeeDirectory.put(105, "Faizan");
        employeeDirectory.put(101, "Mohd Ahsan");
        employeeDirectory.put(104, "Hamza");
        employeeDirectory.put(102, "Zaid");
        employeeDirectory.put(103, "Bilal");

        System.out.println("Inserted Key Sequence: 105, 101, 104, 102, 103");
        System.out.println("\nTreeMap Sorted Key-Value Pairs (Ascending Order of ID):");
        for (Map.Entry<Integer, String> entry : employeeDirectory.entrySet()) {
            System.out.println("  ID: " + entry.getKey() + " -> Employee Name: " + entry.getValue());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
