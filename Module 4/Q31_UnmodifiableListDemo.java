// Question: Create an unmodifiable List using Collections.unmodifiableList() and show what happens when you try to modify it.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q31_UnmodifiableListDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 9: Utility Methods in Collections Class ---");
        System.out.println("--- Q31: Collections.unmodifiableList() Demo ---\n");

        List<String> mutableList = new ArrayList<>();
        mutableList.add("Read");
        mutableList.add("Write");
        mutableList.add("Execute");

        System.out.println("Original Mutable List: " + mutableList);

        // Creating an unmodifiable view of the list
        List<String> readOnlyList = Collections.unmodifiableList(mutableList);
        System.out.println("Unmodifiable List View : " + readOnlyList);
        System.out.println("Can read elements      : " + readOnlyList.get(0));

        // Attempting to modify the unmodifiable list
        System.out.println("\nAttempting to add 'Delete' to unmodifiable list...");
        try {
            readOnlyList.add("Delete");
        } catch (UnsupportedOperationException e) {
            System.out.println("[CAUGHT EXCEPTION] java.lang.UnsupportedOperationException: Cannot modify an unmodifiable collection!");
        }

        // Attempting to remove from the unmodifiable list
        System.out.println("\nAttempting to remove element at index 0 from unmodifiable list...");
        try {
            readOnlyList.remove(0);
        } catch (UnsupportedOperationException e) {
            System.out.println("[CAUGHT EXCEPTION] java.lang.UnsupportedOperationException: Deletion is blocked on read-only view!");
        }

        System.out.println("\nConfirmed: The unmodifiable list remains intact -> " + readOnlyList);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
