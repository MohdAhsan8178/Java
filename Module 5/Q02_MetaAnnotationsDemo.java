// Question: List the meta-annotations available in Java and describe their purposes. Demonstrate with examples.

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1. Meta-Annotation @Retention: Specifies how long the annotation is retained (SOURCE, CLASS, or RUNTIME)
// 2. Meta-Annotation @Target: Specifies where the annotation can be applied (TYPE, METHOD, FIELD, etc.)
// 3. Meta-Annotation @Documented: Specifies that this annotation should be included in generated Javadoc
// 4. Meta-Annotation @Inherited: Specifies that subclasses automatically inherit this annotation from superclass
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Inherited
@interface AuditableService {
    String serviceName() default "DefaultAuditService";
    String securityLevel() default "HIGH";
}

// Applying custom annotation to a Superclass
@AuditableService(serviceName = "UserAuthenticationService", securityLevel = "CRITICAL")
class BaseAuthService {
    public void authenticateUser() {
        System.out.println("BaseAuthService: Authenticating credentials...");
    }
}

// Subclass: Does NOT explicitly declare @AuditableService, but inherits it because of @Inherited
class CloudAuthService extends BaseAuthService {
    @Override
    public void authenticateUser() {
        System.out.println("CloudAuthService: Authenticating via OAuth2 / JWT token...");
    }
}

public class Q02_MetaAnnotationsDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Java Annotations ---");
        System.out.println("--- Q02: Meta-Annotations Demo (@Retention, @Target, @Documented, @Inherited) ---\n");

        Class<CloudAuthService> clazz = CloudAuthService.class;

        // Inspecting inherited annotation at runtime via Reflection
        if (clazz.isAnnotationPresent(AuditableService.class)) {
            AuditableService audit = clazz.getAnnotation(AuditableService.class);
            System.out.println("Annotation successfully detected on subclass: " + clazz.getSimpleName());
            System.out.println("  - Service Name    : " + audit.serviceName());
            System.out.println("  - Security Level  : " + audit.securityLevel());
            System.out.println("  - (Inherited from : " + clazz.getSuperclass().getSimpleName() + ")");
        } else {
            System.out.println("Annotation not found on class.");
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
