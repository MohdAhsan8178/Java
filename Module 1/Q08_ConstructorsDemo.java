// Question 8: Demonstrate the concept of constructors in OOP with a program.

class Student {
    private String name;
    private int age;

    // 1. Default Constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        System.out.println("Default constructor called.");
    }

    // 2. Parameterized Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor called.");
    }

    // 3. Copy Constructor
    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
        System.out.println("Copy constructor called.");
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

public class Q08_ConstructorsDemo {
    public static void main(String[] args) {
        System.out.println("--- Constructors Demo ---");

        System.out.println("\n1. Creating object with Default Constructor:");
        Student s1 = new Student();
        s1.displayDetails();

        System.out.println("\n2. Creating object with Parameterized Constructor:");
        Student s2 = new Student("Mohd Ahsan", 20);
        s2.displayDetails();

        System.out.println("\n3. Creating object with Copy Constructor:");
        Student s3 = new Student(s2);
        s3.displayDetails();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
