// Question 18: Write a program to find the largest and smallest numbers in an array.

public class Q18_ArrayMinMax {
    public static void main(String[] args) {
        int[] numbers = {45, 12, 89, 3, 67, 24, 99, 1};

        if (numbers.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int smallest = numbers[0];
        int largest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("--- Find Smallest & Largest in Array ---");
        System.out.print("Array elements: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Smallest Number: " + smallest);
        System.out.println("Largest Number: " + largest);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
