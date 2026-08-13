// Question 26: Implement a program to reverse the elements of an array.

public class Q26_ReverseArray {

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("--- Array Reversal Demo ---");
        System.out.print("Original Array: ");
        printArray(numbers);

        reverseArray(numbers);

        System.out.print("Reversed Array: ");
        printArray(numbers);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
