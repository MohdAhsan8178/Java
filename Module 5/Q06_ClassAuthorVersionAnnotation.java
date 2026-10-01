// Question: Write a custom annotation to specify the author and version of a class.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 1. Definition of custom annotation @ClassMetadata
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ClassMetadata {
    String author() default "Mohd Ahsan";
    String version() default "1.0.0";
    String dateCreated() default "2026-10-01";
    String[] reviewers() default {"Lead Architect", "Security Team"};
}

// 2. Classes annotated with custom metadata
@ClassMetadata(
    author = "Mohd Ahsan",
    version = "3.5.2",
    dateCreated = "2026-10-01",
    reviewers = {"Zaid Khan", "Hamza Ali"}
)
class EnterpriseBillingModule {
    public void generateInvoice() {
        System.out.println("Generating invoice...");
    }
}

public class Q06_ClassAuthorVersionAnnotation {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Creating Custom Annotations ---");
        System.out.println("--- Q06: Class Author & Version Metadata Annotation ---\n");

        Class<EnterpriseBillingModule> targetClass = EnterpriseBillingModule.class;

        if (targetClass.isAnnotationPresent(ClassMetadata.class)) {
            ClassMetadata metadata = targetClass.getAnnotation(ClassMetadata.class);
            System.out.println("Target Class     : " + targetClass.getSimpleName());
            System.out.println("Author           : " + metadata.author());
            System.out.println("Version          : " + metadata.version());
            System.out.println("Date Created     : " + metadata.dateCreated());
            System.out.print("Reviewers List   : ");
            for (String reviewer : metadata.reviewers()) {
                System.out.print("[" + reviewer + "] ");
            }
            System.out.println();
        } else {
            System.out.println("No @ClassMetadata found on class.");
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
