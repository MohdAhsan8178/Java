// Question: Demonstrate built-in Java annotations: @Override, @Deprecated, and @SuppressWarnings.

import java.util.ArrayList;
import java.util.List;

// Superclass defining base behavior
class BasePaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("BasePaymentProcessor: Processing payment of $" + amount);
    }

    // Deprecated method: Marked as obsolete and scheduled for future removal
    @Deprecated(since = "2.0", forRemoval = true)
    public void processLegacyMagneticStripe(String cardData) {
        System.out.println("Warning: Using legacy insecure magnetic stripe processor for card: " + cardData);
    }
}

// Subclass overriding base method
class ModernPaymentProcessor extends BasePaymentProcessor {

    // @Override: Instructs compiler to verify that this method overrides a declaration in superclass
    @Override
    public void processPayment(double amount) {
        System.out.println("ModernPaymentProcessor: Processing encrypted contactless payment of $" + amount);
    }

    // @SuppressWarnings: Tells compiler to ignore specific compiler warnings (e.g., deprecation, rawtypes, unchecked)
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public void demonstrateSuppressWarnings() {
        System.out.println("\nExecuting method with @SuppressWarnings({\"deprecation\", \"rawtypes\", \"unchecked\"}):");
        
        // 1. Invoking deprecated method (warning suppressed)
        processLegacyMagneticStripe("CARD-NUM-9876-XXXX");

        // 2. Using raw collection type without generic parameter (warning suppressed)
        List rawList = new ArrayList();
        rawList.add("Raw Type Element");
        rawList.add(Integer.valueOf(100));
        System.out.println("Raw List elements: " + rawList);
    }
}

public class Q01_BuiltInAnnotationsDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Java Annotations ---");
        System.out.println("--- Q01: Built-in Annotations (@Override, @Deprecated, @SuppressWarnings) ---\n");

        ModernPaymentProcessor processor = new ModernPaymentProcessor();

        // 1. Calling overridden method
        processor.processPayment(250.75);

        // 2. Calling method with suppressed warnings
        processor.demonstrateSuppressWarnings();

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
