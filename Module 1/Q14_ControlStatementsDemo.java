// Question 14: Implement a program to demonstrate the use of if-else, switch, and for loops.

public class Q14_ControlStatementsDemo {
    public static void main(String[] args) {
        System.out.println("--- Control Statements Demo ---");

        // 1. Demonstration of if-else
        int number = 15;
        System.out.println("\n1. If-Else Statement:");
        if (number > 0) {
            System.out.println(number + " is Positive.");
        } else if (number < 0) {
            System.out.println(number + " is Negative.");
        } else {
            System.out.println("Number is Zero.");
        }

        // 2. Demonstration of switch-case
        int day = 3;
        System.out.println("\n2. Switch Statement:");
        switch (day) {
            case 1:
                System.out.println("Day 1: Monday");
                break;
            case 2:
                System.out.println("Day 2: Tuesday");
                break;
            case 3:
                System.out.println("Day 3: Wednesday");
                break;
            case 4:
                System.out.println("Day 4: Thursday");
                break;
            case 5:
                System.out.println("Day 5: Friday");
                break;
            default:
                System.out.println("Weekend!");
                break;
        }

        // 3. Demonstration of for loop
        System.out.println("\n3. For Loop (Printing first 5 natural numbers):");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
