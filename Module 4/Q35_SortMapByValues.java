// Question: Write a program to sort a Map by its values using a custom Comparator.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Q35_SortMapByValues {

    /**
     * Sorts a map by its values in ascending or descending order.
     *
     * @param map       the input map
     * @param ascending true for ascending, false for descending
     * @return a new LinkedHashMap preserving sorted value order
     */
    public static <K, V extends Comparable<V>> Map<K, V> sortMapByValue(Map<K, V> map, boolean ascending) {
        // Convert Map entries to a List
        List<Map.Entry<K, V>> entryList = new ArrayList<>(map.entrySet());

        // Sort list using Comparator on Entry value
        entryList.sort((e1, e2) -> {
            if (ascending) {
                return e1.getValue().compareTo(e2.getValue());
            } else {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        // Insert sorted entries into LinkedHashMap to preserve order
        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void main(String[] args) {
        System.out.println("--- Section 10: Custom Comparator ---");
        System.out.println("--- Q35: Sorting Map by Values using Custom Comparator ---\n");

        Map<String, Integer> productScores = new HashMap<>();
        productScores.put("MacBook Pro", 95);
        productScores.put("Dell XPS", 88);
        productScores.put("ThinkPad X1", 92);
        productScores.put("HP Spectre", 82);
        productScores.put("Asus ZenBook", 85);

        System.out.println("Original Unsorted Map: " + productScores);

        // Sort by Value Descending (Highest Score First)
        Map<String, Integer> descendingMap = sortMapByValue(productScores, false);
        System.out.println("\n1. Sorted by Value (Descending - Highest Score First):");
        descendingMap.forEach((k, v) -> System.out.printf("   %-15s -> Score: %d%n", k, v));

        // Sort by Value Ascending (Lowest Score First)
        Map<String, Integer> ascendingMap = sortMapByValue(productScores, true);
        System.out.println("\n2. Sorted by Value (Ascending - Lowest Score First):");
        ascendingMap.forEach((k, v) -> System.out.printf("   %-15s -> Score: %d%n", k, v));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
