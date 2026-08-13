// Question 41: Implement a singleton class in Java.

class DatabaseConnection {
    // 1. Private static instance of the class (eager or lazy initialization)
    private static DatabaseConnection instance;

    // 2. Private constructor to prevent instantiation from outside
    private DatabaseConnection() {
        System.out.println("DatabaseConnection object created (Private Constructor).");
    }

    // 3. Public static method to provide global access to the instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection(); // Lazy initialization
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing Query: " + query);
    }
}

public class Q41_SingletonPattern {
    public static void main(String[] args) {
        System.out.println("--- Singleton Class Pattern Demo ---");

        // Attempting to get instance 1
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.executeQuery("SELECT * FROM users");

        // Attempting to get instance 2
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("SELECT * FROM orders");

        // Verifying both references point to the exact same object
        System.out.println("\nChecking if db1 and db2 reference the same instance:");
        System.out.println("db1 == db2: " + (db1 == db2));
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
