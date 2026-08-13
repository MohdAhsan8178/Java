// Question 30: Write a program to search for an element in a sorted array using the binary search algorithm.

public class Q30_BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found, return index
            } else if (arr[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {12, 24, 35, 47, 59, 68, 81, 95};
        int key1 = 47;
        int key2 = 50;

        System.out.println("--- Binary Search Demo ---");

        int index1 = binarySearch(sortedArray, key1);
        if (index1 != -1) {
            System.out.println("Element " + key1 + " found at index: " + index1);
        } else {
            System.out.println("Element " + key1 + " not found in array.");
        }

        int index2 = binarySearch(sortedArray, key2);
        if (index2 != -1) {
            System.out.println("Element " + key2 + " found at index: " + index2);
        } else {
            System.out.println("Element " + key2 + " not found in array.");
        }
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
