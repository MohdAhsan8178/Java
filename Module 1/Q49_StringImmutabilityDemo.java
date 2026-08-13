// Question 49: Write a program to demonstrate the immutability of the String class.

public class Q49_StringImmutabilityDemo {
    public static void main(String[] args) {
        System.out.println("--- String Immutability Core Demo ---");

        String str = "Immutable";
        System.out.println("Original String: " + str + " (Hash: " + System.identityHashCode(str) + ")");

        // Calling String modification methods
        str.concat(" String in Java");
        System.out.println("After concat without assignment: " + str + " (Hash: " + System.identityHashCode(str) + ")");

        str.toUpperCase();
        System.out.println("After toUpperCase without assignment: " + str + " (Hash: " + System.identityHashCode(str) + ")");

        // Reassigning creates a NEW String object in memory
        str = str.concat(" Object");
        System.out.println("After reassignment (str = str.concat(' Object')): " + str + " (New Hash: " + System.identityHashCode(str) + ")");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
