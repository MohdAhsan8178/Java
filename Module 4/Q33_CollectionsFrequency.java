// Question: Write a program to find the frequency of elements in a list using Collections.frequency().

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q33_CollectionsFrequency {
    public static void main(String[] args) {
        System.out.println("--- Section 9: Utility Methods in Collections Class ---");
        System.out.println("--- Q33: Element Frequency using Collections.frequency() ---\n");

        List<String> votes = new ArrayList<>(Arrays.asList(
            "Java", "Python", "Java", "C++", "Java", "Rust", "Python", "Java", "Go", "Python"
        ));

        System.out.println("All Votes List: " + votes + "\n");

        // Specific element frequency lookup
        System.out.println("Target Lookups:");
        System.out.println("  Frequency of 'Java'   : " + Collections.frequency(votes, "Java") + " times");
        System.out.println("  Frequency of 'Python' : " + Collections.frequency(votes, "Python") + " times");
        System.out.println("  Frequency of 'Rust'   : " + Collections.frequency(votes, "Rust") + " times");
        System.out.println("  Frequency of 'Kotlin' : " + Collections.frequency(votes, "Kotlin") + " times");

        // Finding frequency of all unique elements using a Set
        System.out.println("\nFrequency Table for All Elements:");
        Set<String> uniqueLanguages = new HashSet<>(votes);
        for (String lang : uniqueLanguages) {
            int count = Collections.frequency(votes, lang);
            System.out.printf("  %-10s -> %d occurrences%n", lang, count);
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
