// Question: Write a generic method swapElements that swaps two elements in an array. Demonstrate its usage with different data types.

import java.util.Arrays;

public class Q04_GenericSwapElements {

    /**
     * Generic method to swap two elements in an array of any reference type T.
     *
     * @param array  the input array
     * @param index1 first index
     * @param index2 second index
     * @param <T>    generic type parameter
     */
    public static <T> void swapElements(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
            System.err.println("Invalid indices for swapping!");
            return;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        System.out.println("--- Section 1: Generics ---");
        System.out.println("--- Q04: Generic swapElements Method Demo ---\n");

        // 1. Swapping in an Integer Array
        Integer[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Integer Array Before Swap (idx 1 & 3): " + Arrays.toString(numbers));
        swapElements(numbers, 1, 3);
        System.out.println("Integer Array After Swap             : " + Arrays.toString(numbers));

        // 2. Swapping in a String Array
        String[] languages = {"Java", "Python", "Rust", "C++", "Go"};
        System.out.println("\nString Array Before Swap (idx 0 & 2) : " + Arrays.toString(languages));
        swapElements(languages, 0, 2);
        System.out.println("String Array After Swap              : " + Arrays.toString(languages));

        // 3. Swapping in a Double Array
        Double[] prices = {9.99, 19.99, 29.99};
        System.out.println("\nDouble Array Before Swap (idx 0 & 2) : " + Arrays.toString(prices));
        swapElements(prices, 0, 2);
        System.out.println("Double Array After Swap              : " + Arrays.toString(prices));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
