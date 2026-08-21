// Question 10: Demonstrate the use of throw and throws keywords in a program that calculates the factorial of a number. Throw an exception if the input number is negative.

public class Q10_ThrowAndThrowsFactorial {

    /**
     * Calculates the factorial of a given non-negative integer.
     * 
     * 'throws' keyword is used in the method declaration to indicate that
     * this method can potentially throw an IllegalArgumentException to the caller.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n as a long
     * @throws IllegalArgumentException if n is negative
     */
    public static long calculateFactorial(int n) throws IllegalArgumentException {
        // 'throw' keyword is used inside the method body to explicitly throw an exception object
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number: " + n);
        }

        // Base cases: 0! = 1 and 1! = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println("--- Section 3: Errors and Exceptions ---");
        System.out.println("--- Q10: Demonstration of 'throw' and 'throws' with Factorial ---\n");

        int[] sampleInputs = {5, 0, 7, -4, 10, -1};

        for (int num : sampleInputs) {
            System.out.print("Calculating factorial for n = " + num + ": ");
            try {
                // Calling method that declares 'throws IllegalArgumentException'
                long result = calculateFactorial(num);
                System.out.println("Result = " + result);
            } catch (IllegalArgumentException e) {
                // Catching the exception explicitly thrown via 'throw'
                System.out.println("\n  [CAUGHT EXCEPTION via 'throw'] " + e.getMessage());
            }
            System.out.println("------------------------------------------------------------------");
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
