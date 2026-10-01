// Question: Write a program to iterate over a LinkedHashSet and explain its order-preserving property.

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q16_LinkedHashSetOrderPreserving {
    public static void main(String[] args) {
        System.out.println("--- Section 4: Set Interface ---");
        System.out.println("--- Q16: LinkedHashSet Order-Preserving Property Demo ---\n");

        // LinkedHashSet uses a doubly-linked list running across all entries to maintain insertion order
        Set<String> registrationQueue = new LinkedHashSet<>();

        System.out.println("Inserting elements in sequence: [Ahsan, Zaid, Bilal, Hamza, Ayaan]");
        registrationQueue.add("Ahsan");
        registrationQueue.add("Zaid");
        registrationQueue.add("Bilal");
        registrationQueue.add("Hamza");
        registrationQueue.add("Ayaan");
        registrationQueue.add("Zaid"); // Duplicate insertion - will not change existing order

        System.out.println("\nIterating over LinkedHashSet (Guaranteed Insertion Order):");
        int step = 1;
        Iterator<String> it = registrationQueue.iterator();
        while (it.hasNext()) {
            System.out.println("  " + (step++) + ". " + it.next());
        }

        System.out.println("\nExplanation:");
        System.out.println("Unlike HashSet (which does not guarantee any order), LinkedHashSet maintains");
        System.out.println("the exact sequence in which unique elements were inserted.");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
