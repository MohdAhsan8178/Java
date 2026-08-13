// Question 2: Create a program showing the use of inheritance and polymorphism.

// Base / Parent class
class Vehicle {
    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void startEngine() {
        System.out.println(brand + " vehicle engine starting...");
    }
}

// Derived class 1 demonstrating inheritance
class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    // Method overriding (Polymorphism)
    public void startEngine() {
        System.out.println(brand + " car engine starts with a smooth sound: Vroom Vroom!");
    }
}

// Derived class 2 demonstrating inheritance
class Bike extends Vehicle {
    public Bike(String brand) {
        super(brand);
    }

    // Method overriding (Polymorphism)
    public void startEngine() {
        System.out.println(brand + " bike engine starts with a kick: Brum Brum!");
    }
}

public class Q02_InheritancePolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("--- Inheritance & Polymorphism Demo ---");

        // Polymorphic reference: Parent reference holding Child object
        Vehicle myVehicle1 = new Car("Honda");
        Vehicle myVehicle2 = new Bike("Yamaha");

        // Dynamic method dispatch calls overridden methods
        myVehicle1.startEngine();
        myVehicle2.startEngine();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
