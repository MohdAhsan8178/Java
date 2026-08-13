// Question 33: Create a program to show the difference between == and equals() for string comparison.

public class Q33_StringEqualsVsOperator {
    public static void main(String[] args) {
        System.out.println("--- Difference between '==' and '.equals()' in String Comparison ---");

        // String literals (stored in String Constant Pool)
        String s1 = "Hello";
        String s2 = "Hello";

        // String created with 'new' keyword (stored in Heap memory)
        String s3 = new String("Hello");

        System.out.println("s1 (literal): \"" + s1 + "\"");
        System.out.println("s2 (literal): \"" + s2 + "\"");
        System.out.println("s3 (new Object): \"" + s3 + "\"");

        System.out.println("\n1. Comparing String Literals (s1 == s2): " + (s1 == s2) + " (Same memory reference in Pool)");
        System.out.println("2. Comparing Literal vs New Object (s1 == s3): " + (s1 == s3) + " (Different memory references)");

        System.out.println("\n3. Comparing Content using s1.equals(s2): " + s1.equals(s2) + " (Same characters)");
        System.out.println("4. Comparing Content using s1.equals(s3): " + s1.equals(s3) + " (Same characters)");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
