// Question 22: Write a program to check if a given string or number is a palindrome.

public class Q22_PalindromeCheck {

    // Method to check if a number is palindrome
    public static boolean isNumberPalindrome(int number) {
        int original = number;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    // Method to check if a string is palindrome
    public static boolean isStringPalindrome(String str) {
        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("--- Palindrome Check Demo ---");

        // Checking number palindrome
        int num1 = 12321;
        int num2 = 12345;
        System.out.println("Number " + num1 + " is Palindrome? " + isNumberPalindrome(num1));
        System.out.println("Number " + num2 + " is Palindrome? " + isNumberPalindrome(num2));

        // Checking string palindrome
        String str1 = "madam";
        String str2 = "hello";
        System.out.println("String \"" + str1 + "\" is Palindrome? " + isStringPalindrome(str1));
        System.out.println("String \"" + str2 + "\" is Palindrome? " + isStringPalindrome(str2));
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
