// Question 19: Write a program to check if a given number is odd or even.

import java.util.Scanner;

public class Q19_OddEvenCheck {

    public static void checkOddEven(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is an EVEN number.");
        } else {
            System.out.println(number + " is an ODD number.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Odd or Even Check ---");

        // Demonstration with sample numbers
        int sampleNumber1 = 28;
        int sampleNumber2 = 37;

        checkOddEven(sampleNumber1);
        checkOddEven(sampleNumber2);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
