// Question: Write a program to demonstrate the use of ArrayList for storing and iterating over elements.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q09_ArrayListDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 3: List Interface ---");
        System.out.println("--- Q09: ArrayList Storage & Iteration Demo ---\n");

        // Creating an ArrayList to store programming languages
        List<String> frameworkList = new ArrayList<>();

        // Adding elements to the ArrayList
        frameworkList.add("Spring Boot");
        frameworkList.add("Hibernate");
        frameworkList.add("React");
        frameworkList.add("Angular");
        frameworkList.add("Node.js");

        System.out.println("Initial ArrayList: " + frameworkList);
        System.out.println("Total elements   : " + frameworkList.size());
        System.out.println("Element at index 2: " + frameworkList.get(2));

        // Modifying and searching
        frameworkList.set(2, "React.js (Updated)");
        System.out.println("Contains 'Spring Boot'? " + frameworkList.contains("Spring Boot"));

        // Iterating over the list using enhanced for-loop
        System.out.println("\nIterating through ArrayList:");
        int index = 0;
        for (String framework : frameworkList) {
            System.out.println("  [" + index++ + "] " + framework);
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
