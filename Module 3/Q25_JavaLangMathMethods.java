// Question 25: Using java.lang Package: Write a program that demonstrates the use of Math.random(), Math.abs(), and Math.pow() from the java.lang package.

public class Q25_JavaLangMathMethods {
    public static void main(String[] args) {
        System.out.println("--- Section 6: Exploring Java Packages ---");
        System.out.println("--- Q25: java.lang.Math Methods Demo (random, abs, pow) ---\n");

        // 1. Math.abs() - Absolute value
        int negInt = -42;
        double negDouble = -99.75;
        System.out.println("1. Demonstration of Math.abs():");
        System.out.println("   Math.abs(" + negInt + ")    = " + Math.abs(negInt));
        System.out.println("   Math.abs(" + negDouble + ") = " + Math.abs(negDouble));

        // 2. Math.pow() - Exponentiation (base, exponent)
        double base = 3.0;
        double exponent = 4.0;
        double powerResult = Math.pow(base, exponent);
        System.out.println("\n2. Demonstration of Math.pow():");
        System.out.println("   Math.pow(" + base + ", " + exponent + ") = " + powerResult + " (i.e., 3^4 = 81.0)");
        System.out.println("   Math.pow(2, 8)     = " + Math.pow(2, 8));

        // 3. Math.random() - Generates pseudo-random double between 0.0 (inclusive) and 1.0 (exclusive)
        System.out.println("\n3. Demonstration of Math.random():");
        System.out.println("   Raw random double [0.0, 1.0): " + Math.random());

        // Generating a random integer between 1 and 100
        int randomInt = (int) (Math.random() * 100) + 1;
        System.out.println("   Random integer between 1 and 100: " + randomInt);

        // Generating a random 6-digit OTP
        int otp = (int) (Math.random() * 900000) + 100000;
        System.out.println("   Simulated 6-digit OTP: " + otp);

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
