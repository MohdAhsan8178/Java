// Question 20: Write a program to find the largest of three numbers entered by the user.

public class Q20_LargestOfThreeNumbers {

    public static int findLargest(int num1, int num2, int num3) {
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }

    public static void main(String[] args) {
        int a = 45;
        int b = 89;
        int c = 32;

        System.out.println("--- Largest of Three Numbers ---");
        System.out.println("Numbers: " + a + ", " + b + ", " + c);

        int largest = findLargest(a, b, c);
        System.out.println("The largest number is: " + largest);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
