// Question 47: Write a program to reverse a string without using built-in methods.

public class Q47_ReverseStringCustom {

    public static String reverseString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String original = "Java Programming";
        String reversed = reverseString(original);

        System.out.println("--- Custom String Reversal (Without Built-in Methods) ---");
        System.out.println("Original String: \"" + original + "\"");
        System.out.println("Reversed String: \"" + reversed + "\"");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
