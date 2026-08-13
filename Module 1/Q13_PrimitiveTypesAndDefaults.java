// Question 13: Write a program to declare variables of all primitive data types in Java and print their default values.

class PrimitiveDefaults {
    // Instance variables of all 8 primitive types (Java automatically assigns default values to fields)
    byte defaultByte;
    short defaultShort;
    int defaultInt;
    long defaultLong;
    float defaultFloat;
    double defaultDouble;
    char defaultChar;
    boolean defaultBoolean;

    public void printDefaults() {
        System.out.println("Default Values of Primitive Data Types in Java:");
        System.out.println("byte: " + defaultByte);
        System.out.println("short: " + defaultShort);
        System.out.println("int: " + defaultInt);
        System.out.println("long: " + defaultLong);
        System.out.println("float: " + defaultFloat);
        System.out.println("double: " + defaultDouble);
        System.out.println("char: '" + defaultChar + "' (Unicode: \\u" + Integer.toHexString(defaultChar) + ")");
        System.out.println("boolean: " + defaultBoolean);
    }
}

public class Q13_PrimitiveTypesAndDefaults {
    public static void main(String[] args) {
        System.out.println("--- Primitive Data Types & Default Values ---");
        PrimitiveDefaults obj = new PrimitiveDefaults();
        obj.printDefaults();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
