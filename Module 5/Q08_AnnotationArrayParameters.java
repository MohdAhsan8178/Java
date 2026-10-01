// Question: Can annotations take arrays as parameters? Provide an example.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

enum Environment { DEV, STAGING, PRODUCTION }

// Custom annotation accepting multiple array parameter types: String[], int[], Enum[]
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SecurityPolicy {
    String[] allowedRoles() default {"GUEST"};
    int[] allowedPortNumbers() default {80, 443};
    Environment[] activeEnvironments() default {Environment.DEV};
}

class CloudApiController {

    // Passing array parameters to custom annotation
    @SecurityPolicy(
        allowedRoles = {"ADMIN", "SUPERUSER", "DEVOPS"},
        allowedPortNumbers = {8080, 8443, 9090},
        activeEnvironments = {Environment.DEV, Environment.STAGING, Environment.PRODUCTION}
    )
    public void deployMicroservice() {
        System.out.println("Deploying microservice across multi-cloud clusters...");
    }
}

public class Q08_AnnotationArrayParameters {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("--- Section 2: Creating Custom Annotations ---");
        System.out.println("--- Q08: Custom Annotations with Array Parameters Demo ---\n");

        Method method = CloudApiController.class.getMethod("deployMicroservice");

        if (method.isAnnotationPresent(SecurityPolicy.class)) {
            SecurityPolicy policy = method.getAnnotation(SecurityPolicy.class);

            System.out.println("Inspecting Security Policy for method: " + method.getName() + "()");
            System.out.println("  1. Allowed Roles (String[])           : " + Arrays.toString(policy.allowedRoles()));
            System.out.println("  2. Allowed Ports (int[])              : " + Arrays.toString(policy.allowedPortNumbers()));
            System.out.println("  3. Active Environments (Enum[])       : " + Arrays.toString(policy.activeEnvironments()));
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
