// Question 25: Write a program to find the sum of all elements in an array.

public class Q25_ArraySum {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        System.out.println("--- Sum of Array Elements ---");
        System.out.print("Array elements: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nSum = " + sum);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
