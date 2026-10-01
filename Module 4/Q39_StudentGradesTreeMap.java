// Question: Create a program to store students’ grades in a TreeMap, with student names as keys and grades as values. Allow adding, removing, and querying grades.

import java.util.Map;
import java.util.TreeMap;

public class Q39_StudentGradesTreeMap {

    static class GradeBook {
        // TreeMap ensures student names are automatically sorted alphabetically
        private final TreeMap<String, String> gradeMap = new TreeMap<>();

        public void addOrUpdateGrade(String studentName, String grade) {
            gradeMap.put(studentName, grade);
            System.out.println("  [+] Stored Grade: " + studentName + " -> " + grade);
        }

        public void removeStudent(String studentName) {
            if (gradeMap.containsKey(studentName)) {
                String removedGrade = gradeMap.remove(studentName);
                System.out.println("  [-] Removed " + studentName + " (Grade was: " + removedGrade + ")");
            } else {
                System.out.println("  [!] Student not found: " + studentName);
            }
        }

        public void queryGrade(String studentName) {
            if (gradeMap.containsKey(studentName)) {
                System.out.println("  [?] Query Result: " + studentName + " has Grade '" + gradeMap.get(studentName) + "'");
            } else {
                System.out.println("  [?] Query Result: No grade record found for '" + studentName + "'");
            }
        }

        public void displayAllGrades() {
            System.out.println("\n--- Grade Book Records (Alphabetically Sorted) ---");
            System.out.printf("%-20s | %-6s%n", "STUDENT NAME", "GRADE");
            System.out.println("-----------------------------");
            for (Map.Entry<String, String> entry : gradeMap.entrySet()) {
                System.out.printf("%-20s | %-6s%n", entry.getKey(), entry.getValue());
            }
            System.out.println("-----------------------------");
            System.out.println("Total Students Enrolled: " + gradeMap.size() + "\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 11: Practical Use Cases ---");
        System.out.println("--- Q39: Student Grade Book using TreeMap ---\n");

        GradeBook gradeBook = new GradeBook();

        // 1. Adding Grades
        System.out.println("1. Adding Student Grades:");
        gradeBook.addOrUpdateGrade("Zaid Khan", "A");
        gradeBook.addOrUpdateGrade("Mohd Ahsan", "A+");
        gradeBook.addOrUpdateGrade("Hamza Ali", "B+");
        gradeBook.addOrUpdateGrade("Bilal Ahmed", "A");
        gradeBook.addOrUpdateGrade("Faizan Siddiqui", "B");

        // 2. Display All Grades
        gradeBook.displayAllGrades();

        // 3. Querying Grades
        System.out.println("2. Querying Student Grades:");
        gradeBook.queryGrade("Mohd Ahsan");
        gradeBook.queryGrade("Ayaan"); // Non-existent

        // 4. Removing a Record
        System.out.println("\n3. Removing Student Record:");
        gradeBook.removeStudent("Faizan Siddiqui");

        // 5. Final Grade Book View
        gradeBook.displayAllGrades();

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
