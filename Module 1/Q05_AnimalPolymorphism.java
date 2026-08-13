// Question 5: Create a class hierarchy for animals that demonstrates polymorphism.

// Base class
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }
}

// Subclass Dog
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(getName() + " barks: Woof Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(getName() + " meows: Meow Meow!");
    }
}

// Subclass Cow
class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(getName() + " moos: Moo Moo!");
    }
}

public class Q05_AnimalPolymorphism {
    public static void main(String[] args) {
        System.out.println("--- Animal Hierarchy Polymorphism Demo ---");

        // Array of base class references storing derived class objects
        Animal[] animals = {
            new Dog("Buddy"),
            new Cat("Whiskers"),
            new Cow("Daisy")
        };

        // Polymorphic call
        for (Animal animal : animals) {
            animal.makeSound();
        }
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
