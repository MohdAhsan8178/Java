// Question 9: Explain and implement the concept of access modifiers in Java.

class AccessModifierExample {
    // 1. Private: Accessible only within this class
    private int privateVar = 10;

    // 2. Default (Package-private): Accessible within the same package
    int defaultVar = 20;

    // 3. Protected: Accessible within the same package and subclasses
    protected int protectedVar = 30;

    // 4. Public: Accessible from anywhere
    public int publicVar = 40;

    public void displayAll() {
        System.out.println("Inside AccessModifierExample Class:");
        System.out.println("Private Variable: " + privateVar);
        System.out.println("Default Variable: " + defaultVar);
        System.out.println("Protected Variable: " + protectedVar);
        System.out.println("Public Variable: " + publicVar);
    }
}

public class Q09_AccessModifiersDemo {
    public static void main(String[] args) {
        System.out.println("--- Access Modifiers Demo ---");
        AccessModifierExample obj = new AccessModifierExample();

        // Accessing methods and variables
        obj.displayAll();

        System.out.println("\nAccessing variables from main class (same package):");
        // System.out.println(obj.privateVar); // ERROR: privateVar has private access
        System.out.println("Default Variable: " + obj.defaultVar);
        System.out.println("Protected Variable: " + obj.protectedVar);
        System.out.println("Public Variable: " + obj.publicVar);
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
