// Question: Write a program to compare the performance of ArrayList and LinkedList for: Adding elements at the beginning. Removing elements from the middle. Iterating through the list.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q11_ArrayListVsLinkedListPerformance {

    private static final int NUM_OPERATIONS = 50000;

    public static void main(String[] args) {
        System.out.println("--- Section 3: List Interface ---");
        System.out.println("--- Q11: Performance Benchmark: ArrayList vs LinkedList ---\n");
        System.out.println("Benchmark Size: " + NUM_OPERATIONS + " operations\n");

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Test 1: Adding elements at the beginning (index 0)
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM_OPERATIONS; i++) {
            arrayList.add(0, i);
        }
        long arrayListAddFirst = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < NUM_OPERATIONS; i++) {
            linkedList.add(0, i);
        }
        long linkedListAddFirst = System.currentTimeMillis() - start;

        System.out.println("1. Adding at Beginning (index 0):");
        System.out.println("   - ArrayList  : " + arrayListAddFirst + " ms (O(N) due to array shifting)");
        System.out.println("   - LinkedList : " + linkedListAddFirst + " ms (O(1) pointer updates)");

        // Test 2: Iterating through the list (for-each)
        start = System.currentTimeMillis();
        long sumArray = 0;
        for (int num : arrayList) {
            sumArray += num;
        }
        long arrayListIterate = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        long sumLinked = 0;
        for (int num : linkedList) {
            sumLinked += num;
        }
        long linkedListIterate = System.currentTimeMillis() - start;

        System.out.println("\n2. Iterating Through Full List:");
        System.out.println("   - ArrayList  : " + arrayListIterate + " ms (Cache-friendly contiguous memory)");
        System.out.println("   - LinkedList : " + linkedListIterate + " ms (Node traversal overhead)");

        // Test 3: Removing elements from the middle
        int removeCount = 5000;
        start = System.currentTimeMillis();
        for (int i = 0; i < removeCount; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        long arrayListRemoveMid = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < removeCount; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        long linkedListRemoveMid = System.currentTimeMillis() - start;

        System.out.println("\n3. Removing 5000 Elements from Middle:");
        System.out.println("   - ArrayList  : " + arrayListRemoveMid + " ms (Fast index lookup, shift cost)");
        System.out.println("   - LinkedList : " + linkedListRemoveMid + " ms (O(N/2) seek time to node)");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
