// Question: Create a custom annotation @MinLength to validate the minimum length of a string in a Java class.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// 1. Definition of @MinLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MinLength {
    int value() default 5;
    String errorMessage() default "Field length is below minimum required characters!";
}

// 2. Class using @MinLength
class AccountRegistration {
    @MinLength(value = 6, errorMessage = "Account number must be at least 6 digits long.")
    private String accountNumber;

    @MinLength(value = 8, errorMessage = "Security PIN/Password must be at least 8 characters.")
    private String securityKey;

    public AccountRegistration(String accountNumber, String securityKey) {
        this.accountNumber = accountNumber;
        this.securityKey = securityKey;
    }
}

// 3. Validation Runner
class MinLengthValidator {
    public static void validateFields(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        System.out.println("Validating class: " + clazz.getSimpleName());

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLength = field.getAnnotation(MinLength.class);
                field.setAccessible(true);
                String fieldValue = (String) field.get(obj);

                if (fieldValue == null || fieldValue.length() < minLength.value()) {
                    System.out.println("  [-] FAIL: Field '" + field.getName() + "' (Value: \"" + fieldValue + "\") -> " + minLength.errorMessage());
                } else {
                    System.out.println("  [+] PASS: Field '" + field.getName() + "' (Length: " + fieldValue.length() + " >= " + minLength.value() + ") is valid.");
                }
            }
        }
    }
}

public class Q05_MinLengthValidationAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("--- Section 2: Creating Custom Annotations ---");
        System.out.println("--- Q05: Custom @MinLength Field Validation Demo ---\n");

        System.out.println("Test Case 1: Valid Account Registration");
        AccountRegistration validAccount = new AccountRegistration("ACC100293", "P@ssw0rd2026");
        MinLengthValidator.validateFields(validAccount);

        System.out.println("\nTest Case 2: Invalid Account Registration");
        AccountRegistration invalidAccount = new AccountRegistration("123", "pass");
        MinLengthValidator.validateFields(invalidAccount);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
