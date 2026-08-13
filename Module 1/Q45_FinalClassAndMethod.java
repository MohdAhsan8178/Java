// Question 45: Write a program to demonstrate final classes and methods.

// Base class with a final method
class BaseSecurity {
    // Final method cannot be overridden by subclasses
    public final void verifyIdentity() {
        System.out.println("BaseSecurity: Standard identity check executed. Security mechanism locked.");
    }

    public void displayStatus() {
        System.out.println("BaseSecurity status: Active");
    }
}

class ExtendedSecurity extends BaseSecurity {
    // Overriding displayStatus is allowed
    public void displayStatus() {
        System.out.println("ExtendedSecurity status: Active with enhanced monitoring.");
    }

    // Attempting to override verifyIdentity() causes compilation error.
}

// Final class cannot be inherited at all
final class SecureVault {
    public void accessVault() {
        System.out.println("SecureVault accessed. No subclassing allowed for safety.");
    }
}

public class Q45_FinalClassAndMethod {
    public static void main(String[] args) {
        System.out.println("--- Final Class & Method Demo ---");

        ExtendedSecurity sec = new ExtendedSecurity();
        sec.displayStatus();
        sec.verifyIdentity(); // Calling final method inherited from parent

        SecureVault vault = new SecureVault();
        vault.accessVault();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
