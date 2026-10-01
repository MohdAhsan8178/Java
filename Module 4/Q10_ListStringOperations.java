// Question: Create a List of strings and perform the following operations: Add elements to the list. Remove an element by value and index. Replace an element at a specific index. Print the list after each operation.

import java.util.ArrayList;
import java.util.List;

public class Q10_ListStringOperations {
    public static void main(String[] args) {
        System.out.println("--- Section 3: List Interface ---");
        System.out.println("--- Q10: List of Strings Basic CRUD Operations ---\n");

        List<String> cities = new ArrayList<>();

        // 1. Add elements
        cities.add("New Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");
        cities.add("Hyderabad");
        cities.add("Chennai");
        System.out.println("1. After Adding Elements       : " + cities);

        // 2. Remove an element by value
        cities.remove("Hyderabad");
        System.out.println("2. After Removing by Value ('Hyderabad') : " + cities);

        // 3. Remove an element by index (removing index 1 -> 'Mumbai')
        String removedCity = cities.remove(1);
        System.out.println("3. After Removing by Index (idx 1 = " + removedCity + ") : " + cities);

        // 4. Replace an element at a specific index (index 0 -> 'New Delhi' replaced with 'Kolkata')
        cities.set(0, "Kolkata");
        System.out.println("4. After Replacing at Index 0 ('Kolkata') : " + cities);

        System.out.println("\nFinal List: " + cities);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
