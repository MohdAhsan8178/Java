// Question: Write a program to shuffle and sort an ArrayList using methods from the Collections class.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q30_CollectionsShuffleAndSort {
    public static void main(String[] args) {
        System.out.println("--- Section 9: Utility Methods in Collections Class ---");
        System.out.println("--- Q30: Collections.shuffle() and Collections.sort() Demo ---\n");

        List<Integer> deck = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("1. Initial Sorted List : " + deck);

        // Shuffling the list randomly using Collections.shuffle()
        Collections.shuffle(deck);
        System.out.println("2. After 1st Shuffle   : " + deck);

        Collections.shuffle(deck);
        System.out.println("3. After 2nd Shuffle   : " + deck);

        // Sorting back using Collections.sort()
        Collections.sort(deck);
        System.out.println("4. Re-sorted (Ascending): " + deck);

        // Sorting in reverse using Collections.reverse()
        Collections.reverse(deck);
        System.out.println("5. Reversed (Descending): " + deck);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
