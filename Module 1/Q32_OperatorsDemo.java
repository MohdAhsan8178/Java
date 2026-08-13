// Question 32: Write a program to demonstrate the use of arithmetic, relational, and logical operators.

public class Q32_OperatorsDemo {
    public static void main(String[] args) {
        System.out.println("--- Java Operators Demo ---");

        int a = 15;
        int b = 4;

        // 1. Arithmetic Operators
        System.out.println("1. Arithmetic Operators:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // 2. Relational Operators
        System.out.println("\n2. Relational Operators:");
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b:  " + (a > b));
        System.out.println("a < b:  " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // 3. Logical Operators
        boolean condition1 = (a > 10);
        boolean condition2 = (b > 10);
        System.out.println("\n3. Logical Operators:");
        System.out.println("condition1 AND condition2 (&&): " + (condition1 && condition2));
        System.out.println("condition1 OR condition2  (||): " + (condition1 || condition2));
        System.out.println("NOT condition1            (!):  " + (!condition1));
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
