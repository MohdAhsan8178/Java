// Question 42: Write a program to demonstrate multilevel inheritance in Java.

// Grandparent class
class LivingBeing {
    public void breathing() {
        System.out.println("Living being is breathing...");
    }
}

// Parent class extending LivingBeing
class AnimalBase extends LivingBeing {
    public void eat() {
        System.out.println("Animal is eating food...");
    }
}

// Child class extending AnimalBase
class DogChild extends AnimalBase {
    public void bark() {
        System.out.println("Dog is barking: Woof Woof!");
    }
}

public class Q42_MultilevelInheritance {
    public static void main(String[] args) {
        System.out.println("--- Multilevel Inheritance Demo ---");

        DogChild dog = new DogChild();

        // Calling method inherited from Grandparent (LivingBeing)
        dog.breathing();

        // Calling method inherited from Parent (AnimalBase)
        dog.eat();

        // Calling method defined in Child (DogChild)
        dog.bark();
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
