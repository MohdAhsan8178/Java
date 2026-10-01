// Question: Write a program to sort an ArrayList of strings alphabetically and reverse alphabetically.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q12_SortArrayListStrings {
    public static void main(String[] args) {
        System.out.println("--- Section 3: List Interface ---");
        System.out.println("--- Q12: Sorting ArrayList of Strings ---\n");

        List<String> fruits = new ArrayList<>(Arrays.asList("Mango", "Apple", "Orange", "Banana", "Pineapple", "Grapes", "Kiwi"));

        System.out.println("Original List: " + fruits);

        // 1. Sorting Alphabetically (Ascending / Natural Order)
        Collections.sort(fruits);
        System.out.println("\n1. Sorted Alphabetically (A to Z)         : " + fruits);

        // 2. Sorting Reverse Alphabetically (Descending Order)
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("2. Sorted Reverse Alphabetically (Z to A) : " + fruits);

        // 3. Alternative: Using List.sort with custom lambda expression
        fruits.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("3. Case-Insensitive Alphabetical Sort     : " + fruits);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
