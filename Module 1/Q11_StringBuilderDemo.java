// Question 11: Write a program that uses Java's StringBuilder for efficient string operations.

public class Q11_StringBuilderDemo {
    public static void main(String[] args) {
        System.out.println("--- StringBuilder Operations Demo ---");

        // 1. Creation
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Initial StringBuilder: " + sb);

        // 2. Append
        sb.append(" World");
        System.out.println("After append: " + sb);

        // 3. Insert
        sb.insert(5, " Java");
        System.out.println("After insert at index 5: " + sb);

        // 4. Replace
        sb.replace(6, 10, "Beautiful");
        System.out.println("After replace (6 to 10): " + sb);

        // 5. Delete
        sb.delete(6, 16);
        System.out.println("After delete (6 to 16): " + sb);

        // 6. Reverse
        sb.reverse();
        System.out.println("After reverse: " + sb);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
