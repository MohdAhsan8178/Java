// Question 48: Implement a program to count the frequency of characters in a string.

public class Q48_CharacterFrequency {

    public static void printCharacterFrequency(String str) {
        // ASCII array to store character counts
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        System.out.println("Character Frequencies in \"" + str + "\":");
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0 && (char) i != ' ') { // excluding spaces for clean display
                System.out.println("'" + (char) i + "' : " + freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        String text = "hello world java";

        System.out.println("--- Character Frequency Counter ---");
        printCharacterFrequency(text);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
