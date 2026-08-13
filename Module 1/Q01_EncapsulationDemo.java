// Question 1: Write a program to demonstrate encapsulation in Java.

class BankAccount {
    // Private data members (data hiding)
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Parameterized constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Setter and operational methods with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

public class Q01_EncapsulationDemo {
    public static void main(String[] args) {
        // Creating an object of BankAccount
        BankAccount account = new BankAccount("ACC1001", "Mohd Ahsan", 5000.0);

        System.out.println("--- Encapsulation Demo ---");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: $" + account.getBalance());

        // Modifying balance safely using public methods
        account.deposit(1500.0);
        System.out.println("Updated Balance: $" + account.getBalance());

        account.withdraw(2500.0);
        System.out.println("Final Balance: $" + account.getBalance());
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
