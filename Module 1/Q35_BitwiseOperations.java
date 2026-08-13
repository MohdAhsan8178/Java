// Question 35: Implement a program to perform bitwise operations in Java.

public class Q35_BitwiseOperations {
    public static void main(String[] args) {
        System.out.println("--- Bitwise Operations Demo ---");

        int a = 12; // Binary: 0000 1100
        int b = 25; // Binary: 0001 1001

        System.out.println("a = " + a + " (Binary: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (Binary: " + Integer.toBinaryString(b) + ")");

        // Bitwise AND (&)
        System.out.println("\nBitwise AND (a & b) = " + (a & b) + " (Binary: " + Integer.toBinaryString(a & b) + ")");

        // Bitwise OR (|)
        System.out.println("Bitwise OR (a | b)  = " + (a | b) + " (Binary: " + Integer.toBinaryString(a | b) + ")");

        // Bitwise XOR (^)
        System.out.println("Bitwise XOR (a ^ b) = " + (a ^ b) + " (Binary: " + Integer.toBinaryString(a ^ b) + ")");

        // Bitwise Complement (~)
        System.out.println("Bitwise NOT (~a)    = " + (~a));

        // Left Shift (<<)
        System.out.println("Left Shift (a << 2) = " + (a << 2));

        // Right Shift (>>)
        System.out.println("Right Shift (a >> 2)= " + (a >> 2));
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
