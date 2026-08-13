// Question 46: Create a program to show run-time polymorphism using dynamic method dispatch.

class PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing general payment of $" + amount);
    }
}

class CreditCardPayment extends PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount + " with 2% processing fee.");
    }
}

class UPDPayment extends PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount + " instantly via UPI ID.");
    }
}

public class Q46_DynamicMethodDispatch {
    public static void main(String[] args) {
        System.out.println("--- Dynamic Method Dispatch (Runtime Polymorphism) Demo ---");

        PaymentMethod payment; // Parent class reference

        payment = new CreditCardPayment();
        payment.processPayment(250.00); // Calls CreditCardPayment's method at runtime

        payment = new UPDPayment();
        payment.processPayment(100.00); // Calls UPDPayment's method at runtime
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
