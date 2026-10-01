// Question: Write a program to check if a string is a palindrome using a Deque.

import java.util.ArrayDeque;
import java.util.Deque;

public class Q25_PalindromeCheckDeque {

    /**
     * Checks if a string is a palindrome by comparing front and back characters using Deque.
     *
     * @param input the string to test
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        // Clean input: remove non-alphanumeric and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> charDeque = new ArrayDeque<>();

        // Add all characters into the deque
        for (char c : cleaned.toCharArray()) {
            charDeque.addLast(c);
        }

        // Compare characters from both ends
        while (charDeque.size() > 1) {
            char front = charDeque.removeFirst();
            char back = charDeque.removeLast();

            if (front != back) {
                return false; // Mismatch found
            }
        }

        return true; // All matched
    }

    public static void main(String[] args) {
        System.out.println("--- Section 6: Queue and Stack ---");
        System.out.println("--- Q25: Palindrome Check using Deque ---\n");

        String[] testStrings = {
            "radar",
            "RaceCar",
            "A man, a plan, a canal: Panama",
            "hello",
            "java",
            "12321",
            "Was it a car or a cat I saw?"
        };

        System.out.printf("%-35s | %-12s%n", "INPUT STRING", "IS PALINDROME?");
        System.out.println("-----------------------------------------------------");

        for (String test : testStrings) {
            boolean result = isPalindrome(test);
            System.out.printf("%-35s | %s%n", "\"" + test + "\"", result ? "[YES / TRUE]" : "[NO / FALSE]");
        }

        System.out.println("-----------------------------------------------------");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
