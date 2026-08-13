// Question 34: Write a program to illustrate the use of the ternary operator.

public class Q34_TernaryOperatorDemo {
    public static void main(String[] args) {
        System.out.println("--- Ternary Operator (?:) Demo ---");

        int number = 27;

        // Syntax: condition ? expressionIfTrue : expressionIfFalse
        String evenOrOdd = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("The number " + number + " is " + evenOrOdd);

        // Finding maximum of two numbers using ternary operator
        int x = 45;
        int y = 78;
        int max = (x > y) ? x : y;
        System.out.println("Max of " + x + " and " + y + " is: " + max);

        // Finding maximum of three numbers using nested ternary operator
        int a = 12, b = 55, c = 34;
        int maxOfThree = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        System.out.println("Max of (" + a + ", " + b + ", " + c + ") is: " + maxOfThree);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
