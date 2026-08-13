// Question 12: Write a program to demonstrate the immutability of the String class.

public class Q12_StringImmutability {
    public static void main(String[] args) {
        System.out.println("--- String Immutability Demo ---");

        String str1 = "Java";
        System.out.println("Original String str1: " + str1);

        // Attempting to modify str1 using concat()
        str1.concat(" Programming");
        System.out.println("str1 after concat(' Programming') without reassigning: " + str1);

        // Notice str1 is unchanged! concat returns a new String object.
        String str2 = str1.concat(" Programming");
        System.out.println("New String str2 receiving concat result: " + str2);

        // Comparing references
        String s1 = "Hello";
        String s2 = s1; // Both reference the same object
        s1 = s1 + " World"; // Creates a NEW object in memory for s1

        System.out.println("\nChecking reference immutability:");
        System.out.println("s1: " + s1);
        System.out.println("s2 (remains original): " + s2);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
