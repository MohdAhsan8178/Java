// Question 7: Write a Java program to showcase the use of this and super keywords.

// Parent class
class Person {
    String name = "Parent Person";

    public Person(String name) {
        this.name = name; // 'this' refers to current instance variable
    }

    public void display() {
        System.out.println("Person display method: Name = " + name);
    }
}

// Child class
class StudentPerson extends Person {
    String name = "Student Person";

    public StudentPerson(String parentName, String childName) {
        super(parentName); // 'super()' calls parent class constructor
        this.name = childName; // 'this' refers to child instance variable
    }

    public void display() {
        super.display(); // 'super.display()' calls parent class method
        System.out.println("Student display method: Child Name = " + this.name);
        System.out.println("Accessing Parent Name via super: " + super.name);
    }
}

public class Q07_ThisAndSuperKeywords {
    public static void main(String[] args) {
        System.out.println("--- 'this' and 'super' Keywords Demo ---");
        StudentPerson st = new StudentPerson("Mohd Ahsan", "Mohd Ahsan");
        st.display();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
