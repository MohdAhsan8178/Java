// Question: Use a WeakHashMap to demonstrate how entries are garbage-collected when keys are no longer strongly referenced.

import java.util.Map;
import java.util.WeakHashMap;

public class Q43_WeakHashMapGarbageCollection {

    static class CacheKey {
        private final String keyName;

        public CacheKey(String keyName) {
            this.keyName = keyName;
        }

        @Override
        public String toString() {
            return keyName;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Section 12: Advanced Questions ---");
        System.out.println("--- Q43: WeakHashMap and Garbage Collection Demo ---\n");

        // WeakHashMap holds weak references to its keys. When a key is no longer strongly referenced elsewhere,
        // the garbage collector (GC) will reclaim it, and WeakHashMap automatically discards the entry.
        Map<CacheKey, String> weakCache = new WeakHashMap<>();

        // Creating strong references to two keys
        CacheKey key1 = new CacheKey("Key_Persistent");
        CacheKey key2 = new CacheKey("Key_Temporary");

        weakCache.put(key1, "Cached Value for Persistent Key");
        weakCache.put(key2, "Cached Value for Temporary Key");

        System.out.println("1. Initial WeakHashMap size : " + weakCache.size());
        System.out.println("   WeakHashMap Contents     : " + weakCache);

        // Making key2 eligible for Garbage Collection by removing the strong reference
        System.out.println("\n2. Setting 'key2 = null' (Removing strong reference to key2)...");
        key2 = null;

        // Suggesting Garbage Collection to the JVM
        System.out.println("   Requesting JVM Garbage Collection (System.gc())...");
        System.gc();

        // Give GC a brief moment to run finalizers / clean up weak references
        Thread.sleep(200);

        System.out.println("\n3. Post-GC WeakHashMap size : " + weakCache.size());
        System.out.println("   WeakHashMap Contents     : " + weakCache);
        System.out.println("   (Notice: Entry for key2 was automatically garbage-collected!)");
        System.out.println("   Is key1 still present?   : " + weakCache.containsKey(key1));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
