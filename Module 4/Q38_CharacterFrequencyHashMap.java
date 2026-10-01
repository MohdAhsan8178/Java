// Question: Write a program to count the frequency of characters in a string using a HashMap.

import java.util.HashMap;
import java.util.Map;

public class Q38_CharacterFrequencyHashMap {

    /**
     * Counts the frequency of each character in a given string using HashMap.
     *
     * @param input the input string
     * @return Map containing characters and their counts
     */
    public static Map<Character, Integer> countCharacterFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        if (input == null) return frequencyMap;

        for (char ch : input.toCharArray()) {
            // Using getOrDefault to increment or initialize
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        System.out.println("--- Section 11: Practical Use Cases ---");
        System.out.println("--- Q38: Character Frequency Counter using HashMap ---\n");

        String sampleText = "Java Collections Framework and Generics";
        System.out.println("Input String: \"" + sampleText + "\"\n");

        Map<Character, Integer> freq = countCharacterFrequency(sampleText);

        System.out.printf("%-10s | %-12s%n", "CHARACTER", "FREQUENCY");
        System.out.println("-------------------------");

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char c = entry.getKey();
            String displayChar = (c == ' ') ? "[Space]" : "'" + c + "'";
            System.out.printf("%-10s | %-12d%n", displayChar, entry.getValue());
        }

        System.out.println("-------------------------");
        System.out.println("Total Unique Characters: " + freq.size());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
