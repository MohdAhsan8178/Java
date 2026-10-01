// Question: Create a class LruCache<K, V> using LinkedHashMap to implement an LRU (Least Recently Used) cache.

import java.util.LinkedHashMap;
import java.util.Map;

public class Q36_LruCacheLinkedHashMap {

    // LRU Cache backed by LinkedHashMap with access-order mode
    static class LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public LruCache(int capacity) {
            // initialCapacity, loadFactor, accessOrder (true = access-order, false = insertion-order)
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            // Automatically removes the least recently accessed entry when size exceeds capacity
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 11: Practical Use Cases ---");
        System.out.println("--- Q36: LRU (Least Recently Used) Cache using LinkedHashMap ---\n");

        int maxCapacity = 3;
        LruCache<String, String> cache = new LruCache<>(maxCapacity);
        System.out.println("Created LRU Cache with Max Capacity = " + maxCapacity + "\n");

        // 1. Inserting items A, B, C
        cache.put("Page1", "Home Page Data");
        cache.put("Page2", "Profile Page Data");
        cache.put("Page3", "Dashboard Data");
        System.out.println("After inserting Page1, Page2, Page3:");
        System.out.println("  Cache State (Oldest -> Newest): " + cache.keySet());

        // 2. Accessing Page1 (moves Page1 to most recently used position)
        System.out.println("\nAccessing Page1 -> Data: " + cache.get("Page1"));
        System.out.println("After accessing Page1:");
        System.out.println("  Cache State: " + cache.keySet() + " (Page2 is now least recently used)");

        // 3. Inserting Page4 (will evict the least recently used: Page2!)
        System.out.println("\nInserting Page4 (Exceeds capacity -> Eviction triggered)...");
        cache.put("Page4", "Settings Data");
        System.out.println("After inserting Page4:");
        System.out.println("  Cache State: " + cache.keySet());
        System.out.println("  Is Page2 still in cache? " + cache.containsKey("Page2") + " (EVICTED)");
        System.out.println("  Is Page1 still in cache? " + cache.containsKey("Page1") + " (RETAINED)");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
