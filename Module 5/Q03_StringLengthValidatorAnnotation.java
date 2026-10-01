// Question: Write a custom annotation to validate the length of a string.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// 1. Definition of custom annotation @ValidateStringLength
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ValidateStringLength {
    int min() default 3;
    int max() default 20;
    String message() default "String length out of bounds!";
}

// 2. Domain class utilizing the validation annotation
class UserProfile {
    @ValidateStringLength(min = 4, max = 15, message = "Username must be between 4 and 15 characters.")
    private String username;

    @ValidateStringLength(min = 8, max = 30, message = "Password must be at least 8 characters long.")
    private String password;

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}

// 3. Reflection-based Validator Engine
class ValidationEngine {
    public static boolean validate(Object target) {
        Class<?> clazz = target.getClass();
        boolean allValid = true;

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ValidateStringLength.class)) {
                ValidateStringLength annotation = field.getAnnotation(ValidateStringLength.class);
                field.setAccessible(true); // Enable access to private field
                try {
                    Object value = field.get(target);
                    if (value instanceof String) {
                        String str = (String) value;
                        if (str.length() < annotation.min() || str.length() > annotation.max()) {
                            System.err.println("  [VALIDATION ERROR] Field '" + field.getName() + "' (Value: \"" + str + "\") -> " + annotation.message());
                            allValid = false;
                        } else {
                            System.out.println("  [VALIDATION OK] Field '" + field.getName() + "' (Length: " + str.length() + ") is valid.");
                        }
                    }
                } catch (IllegalAccessException e) {
                    System.err.println("Reflection error: " + e.getMessage());
                }
            }
        }
        return allValid;
    }
}

public class Q03_StringLengthValidatorAnnotation {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Java Annotations ---");
        System.out.println("--- Q03: Custom @ValidateStringLength with Reflection Validator ---\n");

        System.out.println("1. Validating Valid User Profile (Username: 'ahsan_dev', Password: 'SecuredPassword2026'):");
        UserProfile validUser = new UserProfile("ahsan_dev", "SecuredPassword2026");
        boolean validResult = ValidationEngine.validate(validUser);
        System.out.println("Result -> Overall Valid: " + validResult);

        System.out.println("\n2. Validating Invalid User Profile (Username: 'ali', Password: '123'):");
        UserProfile invalidUser = new UserProfile("ali", "123");
        boolean invalidResult = ValidationEngine.validate(invalidUser);
        System.out.println("Result -> Overall Valid: " + invalidResult);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
