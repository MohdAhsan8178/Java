// Question: Create a generic MultiMap<K, V> class that stores multiple values for a single key using a HashMap<K, List<V>>.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q41_GenericMultiMap {

    // Generic MultiMap implementation mapping each key K to a List of values V
    static class MultiMap<K, V> {
        private final Map<K, List<V>> internalMap = new HashMap<>();

        public void put(K key, V value) {
            // computeIfAbsent creates a new ArrayList if key is not yet present
            internalMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        public List<V> get(K key) {
            return internalMap.getOrDefault(key, Collections.emptyList());
        }

        public boolean removeValue(K key, V value) {
            List<V> values = internalMap.get(key);
            if (values != null) {
                boolean removed = values.remove(value);
                if (values.isEmpty()) {
                    internalMap.remove(key); // Clean up empty list
                }
                return removed;
            }
            return false;
        }

        public List<V> removeAll(K key) {
            return internalMap.remove(key);
        }

        public boolean containsKey(K key) {
            return internalMap.containsKey(key);
        }

        public int totalValuesCount() {
            int total = 0;
            for (List<V> list : internalMap.values()) {
                total += list.size();
            }
            return total;
        }

        public void display() {
            System.out.println("MultiMap Contents:");
            for (Map.Entry<K, List<V>> entry : internalMap.entrySet()) {
                System.out.println("  Key: " + entry.getKey() + " -> Values: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 12: Advanced Questions ---");
        System.out.println("--- Q41: Generic MultiMap<K, V> using HashMap<K, List<V>> ---\n");

        MultiMap<String, String> departmentCourses = new MultiMap<>();

        // Adding multiple courses for a single department key
        departmentCourses.put("Computer Science", "CS101: Data Structures");
        departmentCourses.put("Computer Science", "CS201: Algorithms");
        departmentCourses.put("Computer Science", "CS301: Operating Systems");

        departmentCourses.put("Mathematics", "MATH101: Linear Algebra");
        departmentCourses.put("Mathematics", "MATH201: Discrete Math");

        departmentCourses.put("Physics", "PHYS101: Classical Mechanics");

        departmentCourses.display();

        System.out.println("\nQuerying Courses for 'Computer Science':");
        System.out.println("  " + departmentCourses.get("Computer Science"));

        // Removing a single value
        System.out.println("\nRemoving 'CS201: Algorithms' from Computer Science...");
        departmentCourses.removeValue("Computer Science", "CS201: Algorithms");

        departmentCourses.display();
        System.out.println("Total values stored across all keys: " + departmentCourses.totalValuesCount());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
