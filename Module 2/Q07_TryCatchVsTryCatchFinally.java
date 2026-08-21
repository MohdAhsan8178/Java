// Question 7: Write a program that demonstrates the difference between try-catch and try-catch-finally blocks by dividing two numbers and handling ArithmeticException.

public class Q07_TryCatchVsTryCatchFinally {

    // Helper method demonstrating simple try-catch
    public static void demonstrateTryCatch(int numerator, int denominator) {
        System.out.println("Executing divide(" + numerator + ", " + denominator + ") with try-catch:");
        try {
            int result = numerator / denominator;
            System.out.println("  [try block] Division result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("  [catch block] ArithmeticException caught: " + e.getMessage());
        }
        System.out.println("  [after block] Code execution resumes after try-catch.");
    }

    // Helper method demonstrating try-catch-finally
    public static void demonstrateTryCatchFinally(int numerator, int denominator) {
        System.out.println("Executing divide(" + numerator + ", " + denominator + ") with try-catch-finally:");
        try {
            int result = numerator / denominator;
            System.out.println("  [try block] Division result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("  [catch block] ArithmeticException caught: " + e.getMessage());
        } finally {
            // The finally block ALWAYS executes, whether an exception occurred or not
            System.out.println("  [finally block] This block ALWAYS executes for cleanup / guarantees.");
        }
        System.out.println("  [after block] Code execution resumes after try-catch-finally.");
    }

    public static void main(String[] args) {
        System.out.println("--- Section 3: Errors and Exceptions ---");
        System.out.println("--- Q7: Difference Between try-catch and try-catch-finally ---\n");

        System.out.println("==================================================");
        System.out.println("PART 1: Demonstrating try-catch block");
        System.out.println("==================================================");
        
        // Case 1A: Normal division without exception
        System.out.println("Case 1A: Valid Division (20 / 4)");
        demonstrateTryCatch(20, 4);
        System.out.println();

        // Case 1B: Division by zero causing ArithmeticException
        System.out.println("Case 1B: Division by Zero (20 / 0)");
        demonstrateTryCatch(20, 0);
        System.out.println();

        System.out.println("==================================================");
        System.out.println("PART 2: Demonstrating try-catch-finally block");
        System.out.println("==================================================");

        // Case 2A: Normal division with finally
        System.out.println("Case 2A: Valid Division (50 / 5)");
        demonstrateTryCatchFinally(50, 5);
        System.out.println();

        // Case 2B: Division by zero with finally
        System.out.println("Case 2B: Division by Zero (50 / 0)");
        demonstrateTryCatchFinally(50, 0);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
