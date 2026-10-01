// Question: Write a program to implement a simple banking system using Map to store customer IDs and their account balances.

import java.util.HashMap;
import java.util.Map;

public class Q42_BankingSystemMap {

    static class BankAccountService {
        // Map mapping Customer ID (String) -> Balance (Double)
        private final Map<String, Double> accounts = new HashMap<>();

        public void createAccount(String customerId, double initialDeposit) {
            if (accounts.containsKey(customerId)) {
                System.out.println("  [!] Account already exists for ID: " + customerId);
                return;
            }
            accounts.put(customerId, Math.max(0.0, initialDeposit));
            System.out.printf("  [+] Created account for %s with initial balance: $%.2f%n", customerId, initialDeposit);
        }

        public void deposit(String customerId, double amount) {
            if (!accounts.containsKey(customerId)) {
                System.out.println("  [!] Account not found: " + customerId);
                return;
            }
            if (amount <= 0) {
                System.out.println("  [!] Deposit amount must be positive.");
                return;
            }
            double newBalance = accounts.get(customerId) + amount;
            accounts.put(customerId, newBalance);
            System.out.printf("  [+] Deposited $%.2f to %s. New Balance: $%.2f%n", amount, customerId, newBalance);
        }

        public boolean withdraw(String customerId, double amount) {
            if (!accounts.containsKey(customerId)) {
                System.out.println("  [!] Account not found: " + customerId);
                return false;
            }
            double currentBalance = accounts.get(customerId);
            if (amount > 0 && amount <= currentBalance) {
                double newBalance = currentBalance - amount;
                accounts.put(customerId, newBalance);
                System.out.printf("  [-] Withdrew $%.2f from %s. New Balance: $%.2f%n", amount, customerId, newBalance);
                return true;
            } else {
                System.out.printf("  [!] Withdrawal failed for %s! Requested: $%.2f, Available: $%.2f%n", customerId, amount, currentBalance);
                return false;
            }
        }

        public void displayAllAccounts() {
            System.out.println("\n--- Bank Accounts Summary ---");
            System.out.printf("%-15s | %-12s%n", "CUSTOMER ID", "BALANCE");
            System.out.println("-----------------------------");
            for (Map.Entry<String, Double> entry : accounts.entrySet()) {
                System.out.printf("%-15s | $%-12.2f%n", entry.getKey(), entry.getValue());
            }
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 12: Advanced Questions ---");
        System.out.println("--- Q42: Banking System using Map Demo ---\n");

        BankAccountService bank = new BankAccountService();

        // 1. Account Creation
        System.out.println("1. Opening Accounts:");
        bank.createAccount("CUST1001", 5000.0);
        bank.createAccount("CUST1002", 3200.0);
        bank.createAccount("CUST1003", 10000.0);

        bank.displayAllAccounts();

        // 2. Deposit and Withdrawal Operations
        System.out.println("2. Performing Transactions:");
        bank.deposit("CUST1001", 1500.0);
        bank.withdraw("CUST1002", 1200.0);
        bank.withdraw("CUST1002", 5000.0); // Overdraft check

        bank.displayAllAccounts();

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
