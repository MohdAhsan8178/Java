// Question 36: Write a program to demonstrate operator precedence in Java.

public class Q36_OperatorPrecedence {
    public static void main(String[] args) {
        System.out.println("--- Operator Precedence Demo ---");

        int a = 10;
        int b = 5;
        int c = 2;

        // Multiplication (*) has higher precedence than Addition (+)
        int res1 = a + b * c; // 10 + (5 * 2) = 20
        System.out.println("Expression (a + b * c) = " + res1);

        // Parentheses () override default precedence
        int res2 = (a + b) * c; // (10 + 5) * 2 = 30
        System.out.println("Expression ((a + b) * c) = " + res2);

        // Division (/) and Multiplication (*) have same precedence, evaluated left to right
        int res3 = a / b * c; // (10 / 5) * 2 = 4
        System.out.println("Expression (a / b * c) = " + res3);

        // Relational operators (<, >) evaluated before Logical operators (&&)
        boolean res4 = a > b && b > c; // (10 > 5) && (5 > 2) -> true && true -> true
        System.out.println("Expression (a > b && b > c) = " + res4);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
