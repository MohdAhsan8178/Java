// Question 10: Show an example of the final keyword for variables, methods, and classes.

// 1. Final Class: Cannot be subclassed/extended
final class ImmutableConfig {
    public void showConfig() {
        System.out.println("This is a final class. It cannot be inherited.");
    }
}

class ParentWithFinalMethod {
    // 2. Final Variable: Value cannot be changed (constant)
    final double PI = 3.14159;

    // 3. Final Method: Cannot be overridden in subclass
    public final void displayPI() {
        System.out.println("Final Variable PI = " + PI);
        // PI = 3.14; // Compilation Error: cannot assign value to final variable
    }
}

class ChildClass extends ParentWithFinalMethod {
    // Attempting to override displayPI() would cause a compilation error.
    public void childInfo() {
        System.out.println("Child class can inherit parent, but cannot override its final method.");
    }
}

public class Q10_FinalKeywordDemo {
    public static void main(String[] args) {
        System.out.println("--- Final Keyword Demo ---");

        ImmutableConfig config = new ImmutableConfig();
        config.showConfig();

        ChildClass child = new ChildClass();
        child.displayPI();
        child.childInfo();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
