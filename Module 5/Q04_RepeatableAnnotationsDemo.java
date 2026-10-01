// Question: What are repeatable annotations in Java? Provide an example.

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// 1. Container Annotation holding an array of @AccessRole
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AccessRoles {
    AccessRole[] value();
}

// 2. Repeatable Annotation referencing its container annotation class
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(AccessRoles.class)
@interface AccessRole {
    String role();
    String permission() default "READ";
}

// 3. Service class applying repeatable annotations to a method
class FinancialReportService {

    @AccessRole(role = "ADMIN", permission = "READ_WRITE_DELETE")
    @AccessRole(role = "FINANCIAL_MANAGER", permission = "READ_WRITE")
    @AccessRole(role = "AUDITOR", permission = "READ_ONLY")
    public void generateQuarterlyAudit() {
        System.out.println("Executing sensitive financial audit report generation...");
    }
}

public class Q04_RepeatableAnnotationsDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("--- Section 1: Java Annotations ---");
        System.out.println("--- Q04: Repeatable Annotations Demo (@Repeatable & Container) ---\n");

        Method method = FinancialReportService.class.getMethod("generateQuarterlyAudit");

        // Inspecting repeatable annotations using getAnnotationsByType (Java 8+)
        AccessRole[] roles = method.getAnnotationsByType(AccessRole.class);

        System.out.println("Inspecting Method: " + method.getName() + "()");
        System.out.println("Total Authorized Roles Configured: " + roles.length + "\n");

        for (AccessRole r : roles) {
            System.out.println("  [Authorized Role] Name: " + r.role() + " | Permission: " + r.permission());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
