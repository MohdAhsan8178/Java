// Question: Write a program to demonstrate the uniqueness property of HashSet by attempting to add duplicate elements.

import java.util.HashSet;
import java.util.Set;

public class Q14_HashSetUniquenessDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 4: Set Interface ---");
        System.out.println("--- Q14: HashSet Uniqueness Property & Duplicate Rejection ---\n");

        Set<String> employeeIds = new HashSet<>();

        // set.add() returns true if element was added, false if already present
        System.out.println("Adding 'EMP101' -> Success: " + employeeIds.add("EMP101"));
        System.out.println("Adding 'EMP102' -> Success: " + employeeIds.add("EMP102"));
        System.out.println("Adding 'EMP103' -> Success: " + employeeIds.add("EMP103"));
        System.out.println("Adding 'EMP101' (Duplicate!) -> Success: " + employeeIds.add("EMP101"));
        System.out.println("Adding 'EMP102' (Duplicate!) -> Success: " + employeeIds.add("EMP102"));

        System.out.println("\nFinal HashSet Elements: " + employeeIds);
        System.out.println("Total Unique Elements in Set: " + employeeIds.size());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
