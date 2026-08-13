// Question 31: Write a program to remove duplicate elements from an array.

import java.util.Arrays;

public class Q31_RemoveDuplicatesArray {

    // Removes duplicates from a sorted array and returns the number of unique elements
    public static int removeDuplicatesSorted(int[] arr) {
        if (arr.length == 0) return 0;

        int uniqueIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[uniqueIndex]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] originalArray = {10, 20, 20, 30, 40, 40, 40, 50, 50};

        System.out.println("--- Remove Duplicates from Array ---");
        System.out.println("Original Array: " + Arrays.toString(originalArray));

        int newLength = removeDuplicatesSorted(originalArray);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(originalArray[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
