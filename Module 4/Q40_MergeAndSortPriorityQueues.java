// Question: Write a program to merge two PriorityQueue objects and sort the resulting queue.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q40_MergeAndSortPriorityQueues {

    /**
     * Merges two PriorityQueue instances into a single sorted list.
     *
     * @param pq1 first priority queue
     * @param pq2 second priority queue
     * @return sorted list containing all merged elements
     */
    public static <T extends Comparable<T>> List<T> mergeAndSort(PriorityQueue<T> pq1, PriorityQueue<T> pq2) {
        // Combined priority queue
        PriorityQueue<T> mergedPq = new PriorityQueue<>(pq1);
        mergedPq.addAll(pq2);

        // Polling from priority queue retrieves elements in sorted priority order
        List<T> sortedResult = new ArrayList<>();
        while (!mergedPq.isEmpty()) {
            sortedResult.add(mergedPq.poll());
        }

        return sortedResult;
    }

    public static void main(String[] args) {
        System.out.println("--- Section 11: Practical Use Cases ---");
        System.out.println("--- Q40: Merge and Sort Two PriorityQueues ---\n");

        // First PriorityQueue
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.offer(45);
        pq1.offer(10);
        pq1.offer(78);
        pq1.offer(23);

        // Second PriorityQueue
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.offer(89);
        pq2.offer(5);
        pq2.offer(34);
        pq2.offer(12);

        System.out.println("PriorityQueue 1 (Raw elements): " + pq1);
        System.out.println("PriorityQueue 2 (Raw elements): " + pq2);

        // Merging and extracting in natural sorted order
        List<Integer> sortedMergedList = mergeAndSort(pq1, pq2);

        System.out.println("\nMerged & Sorted Result (Ascending Priority Order):");
        System.out.println(sortedMergedList);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
