// Question 40: Write a program to demonstrate the use of static and non-static methods.

class Utility {
    static int staticCounter = 0;
    int instanceCounter = 0;

    // Static method: Called using class name without creating an instance
    public static void printStaticMessage() {
        staticCounter++;
        System.out.println("Static method called. Static Counter: " + staticCounter);
        // Note: Non-static variables cannot be directly accessed in static methods
    }

    // Non-static (Instance) method: Called on an object instance
    public void printInstanceMessage() {
        staticCounter++;
        instanceCounter++;
        System.out.println("Instance method called. Static Counter: " + staticCounter + ", Instance Counter: " + instanceCounter);
    }
}

public class Q40_StaticNonStaticMethods {
    public static void main(String[] args) {
        System.out.println("--- Static vs Non-Static Methods Demo ---");

        // 1. Invoking Static Method directly via Class name
        Utility.printStaticMessage();
        Utility.printStaticMessage();

        // 2. Invoking Non-Static Method via Objects
        System.out.println("\nCreating Object 1:");
        Utility u1 = new Utility();
        u1.printInstanceMessage();

        System.out.println("\nCreating Object 2:");
        Utility u2 = new Utility();
        u2.printInstanceMessage();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
