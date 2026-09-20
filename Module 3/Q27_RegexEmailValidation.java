// Question 27: Regular Expressions in java.util.regex: Create a program that uses the Pattern and Matcher classes from the java.util.regex package to check if a given string is a valid email address.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q27_RegexEmailValidation {

    // Standard RFC 5322 compatible regex pattern for email validation
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates if an email string matches standard email formatting rules.
     *
     * @param email email string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("--- Section 6: Exploring Java Packages ---");
        System.out.println("--- Q27: Email Validation with java.util.regex Pattern & Matcher ---\n");

        System.out.println("Compiled Regex: " + EMAIL_REGEX + "\n");

        String[] testEmails = {
            "mohd.ahsan@example.com",
            "ahsanmohdcr7@gmail.com",
            "student_123@university.edu.in",
            "invalid-email-at-domain.com",
            "user@.com.my",
            "user@domain..com",
            "@missingusername.com",
            "valid.name+tag@sub.domain.org",
            "spaces in email@domain.com"
        };

        System.out.printf("%-35s | %-12s%n", "EMAIL ADDRESS", "VALIDATION STATUS");
        System.out.println("-----------------------------------------------------");

        for (String email : testEmails) {
            boolean valid = isValidEmail(email);
            String status = valid ? "[VALID]" : "[INVALID]";
            System.out.printf("%-35s | %s%n", email, status);
        }

        System.out.println("-----------------------------------------------------");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
