package java_files;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Question 11: Implement a simple annotation-based validation framework for
 * user input (e.g., checking if a string is not empty, within a certain length, etc.).
 *
 * Demonstrates:
 * 1. Defining custom constraint annotations (@NotNull, @NotEmpty, @Size, @Email, @Range).
 * 2. Implementing a generic reflection-driven Validation Engine.
 * 3. Validating complete domain objects and aggregating error reports.
 */
public class Q11_UserInputValidationFramework {

    // --- Validation Annotations ---

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface NotNull {
        String message() default "Field must not be null";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface NotEmpty {
        String message() default "Field must not be empty";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Size {
        int min() default 0;
        int max() default Integer.MAX_VALUE;
        String message() default "Field length is out of valid bounds";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Email {
        String message() default "Field must be a valid email format";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Range {
        long min() default Long.MIN_VALUE;
        long max() default Long.MAX_VALUE;
        String message() default "Field value is outside acceptable range";
    }

    // --- Domain Models ---

    public static class UserRegistrationForm {
        @NotNull(message = "Username cannot be null")
        @NotEmpty(message = "Username cannot be blank")
        @Size(min = 4, max = 15, message = "Username must be between 4 and 15 characters")
        private final String username;

        @NotNull(message = "Email cannot be null")
        @Email(message = "Must provide a well-formed email address")
        private final String email;

        @NotNull(message = "Password cannot be null")
        @Size(min = 8, max = 32, message = "Password must be between 8 and 32 characters long")
        private final String password;

        @Range(min = 18, max = 120, message = "Age must be between 18 and 120 years")
        private final int age;

        public UserRegistrationForm(String username, String email, String password, int age) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.age = age;
        }

        public String getUsername() {
            return username;
        }
    }

    // --- Error Representation ---

    public static class ValidationError {
        private final String fieldName;
        private final Object rejectedValue;
        private final String errorMessage;

        public ValidationError(String fieldName, Object rejectedValue, String errorMessage) {
            this.fieldName = fieldName;
            this.rejectedValue = rejectedValue;
            this.errorMessage = errorMessage;
        }

        @Override
        public String toString() {
            return String.format(" - Field '%s' [value: '%s']: %s", fieldName, rejectedValue, errorMessage);
        }
    }

    // --- Validation Engine ---

    public static class Validator {
        private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

        public static List<ValidationError> validate(Object object) {
            List<ValidationError> errors = new ArrayList<>();
            if (object == null) {
                errors.add(new ValidationError("object", null, "Target object is null"));
                return errors;
            }

            Class<?> clazz = object.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    String fieldName = field.getName();

                    // 1. @NotNull check
                    if (field.isAnnotationPresent(NotNull.class)) {
                        if (value == null) {
                            errors.add(new ValidationError(fieldName, null, field.getAnnotation(NotNull.class).message()));
                            continue; // Skip further checks if null
                        }
                    }

                    // 2. @NotEmpty check
                    if (field.isAnnotationPresent(NotEmpty.class)) {
                        if (value == null || value.toString().trim().isEmpty()) {
                            errors.add(new ValidationError(fieldName, value, field.getAnnotation(NotEmpty.class).message()));
                        }
                    }

                    // 3. @Size check (for Strings and CharSequences)
                    if (field.isAnnotationPresent(Size.class) && value != null) {
                        Size size = field.getAnnotation(Size.class);
                        int length = value.toString().length();
                        if (length < size.min() || length > size.max()) {
                            errors.add(new ValidationError(fieldName, value,
                                    size.message() + " (min=" + size.min() + ", max=" + size.max() + ", actual=" + length + ")"));
                        }
                    }

                    // 4. @Email check
                    if (field.isAnnotationPresent(Email.class) && value != null) {
                        Email email = field.getAnnotation(Email.class);
                        if (!EMAIL_PATTERN.matcher(value.toString()).matches()) {
                            errors.add(new ValidationError(fieldName, value, email.message()));
                        }
                    }

                    // 5. @Range check (for Numbers)
                    if (field.isAnnotationPresent(Range.class) && value != null) {
                        Range range = field.getAnnotation(Range.class);
                        if (value instanceof Number) {
                            long longVal = ((Number) value).longValue();
                            if (longVal < range.min() || longVal > range.max()) {
                                errors.add(new ValidationError(fieldName, value,
                                        range.message() + " (min=" + range.min() + ", max=" + range.max() + ", actual=" + longVal + ")"));
                            }
                        }
                    }

                } catch (IllegalAccessException e) {
                    errors.add(new ValidationError(field.getName(), null, "Access error: " + e.getMessage()));
                }
            }

            return errors;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Annotation-Based Validation Framework Demo ===");

        // Test 1: Valid User Registration Form
        System.out.println("\n--- Test 1: Valid User Form ---");
        UserRegistrationForm validUser = new UserRegistrationForm(
                "john_doe",
                "john.doe@university.edu",
                "SecureP@ss123",
                25
        );
        List<ValidationError> validResults = Validator.validate(validUser);
        if (validResults.isEmpty()) {
            System.out.println("Form validation PASSED successfully for: " + validUser.getUsername());
        } else {
            System.out.println("Form validation FAILED:");
            validResults.forEach(System.out::println);
        }

        // Test 2: Invalid User Registration Form with Multiple Violations
        System.out.println("\n--- Test 2: Invalid User Form (Multiple Constraint Failures) ---");
        UserRegistrationForm invalidUser = new UserRegistrationForm(
                "ab", // Too short (min 4)
                "invalid-email-format", // Not an email
                "123", // Too short (min 8)
                15 // Below minimum age 18
        );
        List<ValidationError> invalidResults = Validator.validate(invalidUser);
        System.out.println("Form validation FAILED with " + invalidResults.size() + " errors:");
        invalidResults.forEach(System.out::println);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
