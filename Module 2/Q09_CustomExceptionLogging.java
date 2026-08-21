// Question 9: Create a custom exception InvalidAgeException that is thrown when a user's age is less than 18. Handle the exception and log the error to a file using java.util.logging.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Q09_CustomExceptionLogging {

    // Custom Exception Definition
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    // Initializing Logger for this class
    private static final Logger logger = Logger.getLogger(Q09_CustomExceptionLogging.class.getName());
    private static final String LOG_FILE_NAME = "age_validation_error.log";

    /**
     * Checks if the age is eligible; throws InvalidAgeException if age < 18.
     *
     * @param age user's age
     * @throws InvalidAgeException if age < 18
     */
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Validation Failed: Age " + age + " is strictly less than 18.");
        }
        System.out.println("Status: Age " + age + " is valid. User registered successfully.");
    }

    public static void main(String[] args) {
        System.out.println("--- Section 3: Errors and Exceptions ---");
        System.out.println("--- Q9: Custom Exception with java.util.logging File Logging ---\n");

        FileHandler fileHandler = null;

        try {
            // Disable default console logging so output goes specifically to the log file
            logger.setUseParentHandlers(false);

            // Configure FileHandler to log messages to 'age_validation_error.log' (append = false to start fresh)
            fileHandler = new FileHandler(LOG_FILE_NAME, false);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            // Attach handler to logger
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

            System.out.println("[Configuration] Logger initialized. Target log file: " + LOG_FILE_NAME);
            System.out.println("==================================================");

            // Test Case 1: Valid age
            int validAge = 25;
            System.out.println("Attempt 1: Registering with Age " + validAge);
            try {
                checkAge(validAge);
                logger.info("Registration successful for user with age: " + validAge);
            } catch (InvalidAgeException e) {
                logger.log(Level.SEVERE, "Exception during registration: " + e.getMessage(), e);
            }

            System.out.println("--------------------------------------------------");

            // Test Case 2: Invalid age (< 18)
            int invalidAge = 15;
            System.out.println("Attempt 2: Registering with Age " + invalidAge);
            try {
                checkAge(invalidAge);
                logger.info("Registration successful for user with age: " + invalidAge);
            } catch (InvalidAgeException e) {
                System.out.println("Status: [CAUGHT InvalidAgeException] " + e.getMessage());
                
                // Logging the error and stack trace to the log file using java.util.logging
                logger.log(Level.SEVERE, "Underage attempt detected with age " + invalidAge + ": " + e.getMessage(), e);
                System.out.println("Action: Error details and stack trace have been logged to '" + LOG_FILE_NAME + "'");
            }

            System.out.println("==================================================");

        } catch (IOException e) {
            System.err.println("Failed to initialize file logger: " + e.getMessage());
        } finally {
            // Ensure FileHandler is flushed and closed cleanly
            if (fileHandler != null) {
                fileHandler.close();
            }
        }

        // Reading and displaying the contents of the generated log file
        System.out.println("\n--- Verification: Contents of '" + LOG_FILE_NAME + "' ---");
        File logFile = new File(LOG_FILE_NAME);
        if (logFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("  " + line);
                }
            } catch (IOException e) {
                System.err.println("Could not read log file: " + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
