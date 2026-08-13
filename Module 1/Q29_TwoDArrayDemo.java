// Question 29: Write a program to demonstrate a 2D array and print its elements.

public class Q29_TwoDArrayDemo {
    public static void main(String[] args) {
        System.out.println("--- 2D Array Demonstration ---");

        // Declaring and initializing a 3x3 2D array (matrix)
        int[][] matrix = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        System.out.println("Printing 2D Array using nested loops:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println(); // Newline after each row
        }
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
