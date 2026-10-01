// Question: Write a program to show the difference between HashMap and LinkedHashMap in terms of iteration order.

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q20_HashMapVsLinkedHashMapOrder {
    public static void main(String[] args) {
        System.out.println("--- Section 5: Map Interface ---");
        System.out.println("--- Q20: HashMap vs LinkedHashMap Iteration Order Comparison ---\n");

        String[] keys = {"Delhi", "Mumbai", "Kolkata", "Chennai", "Bangalore", "Hyderabad"};
        int[] values = {110001, 400001, 700001, 600001, 560001, 500001};

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Inserting into both maps in the exact same sequence
        for (int i = 0; i < keys.length; i++) {
            hashMap.put(keys[i], values[i]);
            linkedHashMap.put(keys[i], values[i]);
        }

        System.out.println("Insertion Sequence: [Delhi, Mumbai, Kolkata, Chennai, Bangalore, Hyderabad]\n");

        // 1. HashMap Iteration Order (Bucket Hash based, unpredictable order)
        System.out.println("1. HashMap Iteration Order (No order guarantee):");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }

        // 2. LinkedHashMap Iteration Order (Maintains exact insertion sequence via doubly-linked list)
        System.out.println("\n2. LinkedHashMap Iteration Order (Preserves insertion order):");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
