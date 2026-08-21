// Question 8: Create a custom exception InvalidAgeException that is thrown when a user's age is less than 18. Write a program to demonstrate its use.

public class Q08_CustomExceptionInvalidAge {

    // Custom / User-defined Exception class
    static class InvalidAgeException extends Exception {
        private int invalidAge;

        // Constructor with custom error message
        public InvalidAgeException(String message) {
            super(message);
        }

        // Overloaded constructor with age detail
        public InvalidAgeException(String message, int age) {
            super(message);
            this.invalidAge = age;
        }

        public int getInvalidAge() {
            return invalidAge;
        }
    }

    /**
     * Validates if a user is eligible based on age requirement (minimum 18).
     *
     * @param age age of the user
     * @throws InvalidAgeException if age is less than 18
     */
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Access Denied: Age " + age + " is below the required minimum age of 18.", age);
        } else {
            System.out.println("Access Granted: Age " + age + " is valid. Welcome to the portal to another Galaxy!");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 3: Errors and Exceptions ---");
        System.out.println("--- Q8: Custom Exception 'InvalidAgeException' Demo ---\n");

        int[] testAges = {22, 16, 18, 14};

        for (int age : testAges) {
            System.out.println("Checking registration for Age: " + age);
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("[CAUGHT EXCEPTION] " + e.getMessage());
            }
            System.out.println("--------------------------------------------------");
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
