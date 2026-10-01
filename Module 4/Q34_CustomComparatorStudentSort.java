// Question: Write a program to sort a list of custom objects (e.g., Student with name and marks) using a Comparator.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q34_CustomComparatorStudentSort {

    static class Student {
        private final int rollNo;
        private final String name;
        private final double marks;

        public Student(int rollNo, String name, double marks) {
            this.rollNo = rollNo;
            this.name = name;
            this.marks = marks;
        }

        public int getRollNo() {
            return rollNo;
        }

        public String getName() {
            return name;
        }

        public double getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return String.format("Student [RollNo=%-3d | Name=%-12s | Marks=%.2f]", rollNo, name, marks);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 10: Custom Comparator ---");
        System.out.println("--- Q34: Custom Object Sorting using Comparator ---\n");

        List<Student> students = new ArrayList<>();
        students.add(new Student(104, "Zaid Khan", 88.5));
        students.add(new Student(101, "Mohd Ahsan", 94.0));
        students.add(new Student(103, "Bilal Ahmed", 79.5));
        students.add(new Student(102, "Hamza Ali", 91.0));
        students.add(new Student(105, "Faizan", 88.5));

        System.out.println("Original Student List:");
        students.forEach(s -> System.out.println("  " + s));

        // 1. Sort by Marks Descending (Rank Order)
        Comparator<Student> marksComparator = (s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks());
        students.sort(marksComparator);
        System.out.println("\n1. Sorted by Marks (Highest to Lowest):");
        students.forEach(s -> System.out.println("  " + s));

        // 2. Sort by Name Alphabetically
        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        students.sort(nameComparator);
        System.out.println("\n2. Sorted by Name (Alphabetical):");
        students.forEach(s -> System.out.println("  " + s));

        // 3. Sort by Roll Number Ascending
        Comparator<Student> rollNoComparator = Comparator.comparingInt(Student::getRollNo);
        students.sort(rollNoComparator);
        System.out.println("\n3. Sorted by Roll Number (Ascending):");
        students.forEach(s -> System.out.println("  " + s));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
