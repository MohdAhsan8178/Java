// Question: Create a ConcurrentHashMap and demonstrate how it handles concurrent modifications.

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Q28_ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Section 8: Concurrency and Thread-Safety ---");
        System.out.println("--- Q28: ConcurrentHashMap Concurrent Operations Demo ---\n");

        // ConcurrentHashMap uses lock striping / CAS operations allowing concurrent reads and writes
        ConcurrentHashMap<String, Integer> inventoryMap = new ConcurrentHashMap<>();

        inventoryMap.put("Laptops", 100);
        inventoryMap.put("Smartphones", 250);
        inventoryMap.put("Headphones", 150);
        inventoryMap.put("Keyboards", 80);

        System.out.println("Initial Inventory: " + inventoryMap + "\n");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Task 1: Updating existing items concurrently using computeIfPresent
        executor.submit(() -> {
            for (int i = 0; i < 20; i++) {
                inventoryMap.computeIfPresent("Laptops", (k, v) -> v + 1);
            }
            System.out.println("Worker 1: Updated Laptops count (+20)");
        });

        // Task 2: Inserting new products concurrently
        executor.submit(() -> {
            inventoryMap.putIfAbsent("Smartwatches", 75);
            inventoryMap.putIfAbsent("Monitors", 45);
            System.out.println("Worker 2: Inserted new product lines");
        });

        // Task 3: Iterating while other threads are modifying (No ConcurrentModificationException!)
        executor.submit(() -> {
            System.out.println("Worker 3 (Iterator Snapshot):");
            inventoryMap.forEach((key, val) -> {
                System.out.println("   [Live Read] " + key + " = " + val);
            });
        });

        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("\nFinal Inventory in ConcurrentHashMap: " + inventoryMap);
        System.out.println("Note: ConcurrentHashMap allows safe concurrent reads/writes without throwing ConcurrentModificationException.");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
