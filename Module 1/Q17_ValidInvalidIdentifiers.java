// Question 17: Write a program to identify valid and invalid identifiers in Java.

public class Q17_ValidInvalidIdentifiers {

    // Method to check if a string is a valid Java identifier programmatically
    public static boolean isValidIdentifier(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            return false;
        }

        // First character check
        char firstChar = identifier.charAt(0);
        if (!Character.isJavaIdentifierStart(firstChar)) {
            return false;
        }

        // Remaining characters check
        for (int i = 1; i < identifier.length(); i++) {
            char ch = identifier.charAt(i);
            if (!Character.isJavaIdentifierPart(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("--- Valid and Invalid Identifiers in Java ---");

        // Demonstration of valid variable declarations in Java
        int totalAmount = 100;
        int _score = 95;
        int $value = 50;
        int num2 = 10;

        System.out.println("Demonstration of valid declared variables:");
        System.out.println("totalAmount = " + totalAmount);
        System.out.println("_score = " + _score);
        System.out.println("$value = " + $value);
        System.out.println("num2 = " + num2);

        // Testing sample identifier strings
        String[] testIdentifiers = {
            "user_name", "totalAmount", "_temp", "$price", "3rdRank", "class", "user-name", "value#1"
        };

        System.out.println("\nTesting Identifier Validity:");
        for (String id : testIdentifiers) {
            boolean valid = isValidIdentifier(id);
            System.out.println("Identifier: '" + id + "' -> " + (valid ? "VALID" : "INVALID"));
        }
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
