// Question: Write a program to demonstrate the sorted order of keys in TreeMap by adding unsorted key-value pairs.

import java.util.Map;
import java.util.TreeMap;

public class Q19_TreeMapUnsortedEntriesDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 5: Map Interface ---");
        System.out.println("--- Q19: Automatic Key Sorting with Unsorted Inputs in TreeMap ---\n");

        TreeMap<String, Integer> wordFrequency = new TreeMap<>();

        // Inserting unsorted alphabetical keys
        System.out.println("Inserting unsorted words into TreeMap:");
        wordFrequency.put("Zebra", 5);
        wordFrequency.put("Apple", 12);
        wordFrequency.put("Monkey", 7);
        wordFrequency.put("Cat", 20);
        wordFrequency.put("Dog", 15);
        wordFrequency.put("Banana", 9);

        System.out.println("Inserted sequence: [Zebra, Apple, Monkey, Cat, Dog, Banana]\n");

        System.out.println("TreeMap Output (Sorted Alphabetically by Key):");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.printf("  Word: %-10s | Count: %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nFirst Key : " + wordFrequency.firstKey());
        System.out.println("Last Key  : " + wordFrequency.lastKey());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
