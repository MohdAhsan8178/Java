// Question: Write a program to create a HashMap of employee IDs and names. Perform the following operations: Add new key-value pairs. Check if a key exists. Iterate through the map using: KeySet, EntrySet.

import java.util.HashMap;
import java.util.Map;

public class Q18_HashMapEmployeeDirectory {
    public static void main(String[] args) {
        System.out.println("--- Section 5: Map Interface ---");
        System.out.println("--- Q18: HashMap Employee Directory Operations ---\n");

        Map<Integer, String> employeeMap = new HashMap<>();

        // 1. Add new key-value pairs
        employeeMap.put(1001, "Mohd Ahsan");
        employeeMap.put(1002, "Zaid Khan");
        employeeMap.put(1003, "Hamza Ali");
        employeeMap.put(1004, "Bilal Ahmed");
        System.out.println("1. Added Employees to HashMap: " + employeeMap);

        // 2. Check if a key exists
        int searchId = 1002;
        int nonExistingId = 9999;
        System.out.println("\n2. Key Existence Checks:");
        System.out.println("   Does ID " + searchId + " exist? -> " + employeeMap.containsKey(searchId));
        System.out.println("   Does ID " + nonExistingId + " exist? -> " + employeeMap.containsKey(nonExistingId));

        // 3. Iteration using KeySet
        System.out.println("\n3. Iterating using KeySet (keySet()):");
        for (Integer empId : employeeMap.keySet()) {
            System.out.println("   Key (ID): " + empId + " | Value (Name): " + employeeMap.get(empId));
        }

        // 4. Iteration using EntrySet (More efficient as it avoids repeated hash lookups)
        System.out.println("\n4. Iterating using EntrySet (entrySet()):");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("   [Entry] ID = " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
