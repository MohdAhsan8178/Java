// Question 43: Create a program to show method overriding and the use of super to call the parent class method.

// Base class
class Employee {
    String name;
    double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void calculateSalary() {
        System.out.println("Employee " + name + " Base Salary: $" + baseSalary);
    }
}

// Subclass
class Manager extends Employee {
    double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary); // Call parent constructor
        this.bonus = bonus;
    }

    public void calculateSalary() {
        super.calculateSalary(); // Call parent class method
        double totalSalary = baseSalary + bonus;
        System.out.println("Manager Bonus: $" + bonus + " | Total Salary: $" + totalSalary);
    }
}

public class Q43_MethodOverridingSuper {
    public static void main(String[] args) {
        System.out.println("--- Method Overriding & 'super' Keyword Demo ---");

        Manager mgr = new Manager("Mohd Ahsan", 75000.0, 15000.0);
        mgr.calculateSalary();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
