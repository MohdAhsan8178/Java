// Question 8: Synchronized Block: Create an inventory management program where multiple threads decrease the stock count of a product. Use a synchronized block to ensure stock updates are thread-safe.

class ProductInventory {
    private final String productName;
    private int stockCount;
    // Dedicated lock object for synchronization block
    private final Object lock = new Object();

    public ProductInventory(String productName, int initialStock) {
        this.productName = productName;
        this.stockCount = initialStock;
    }

    public void purchase(String customerName, int quantity) {
        System.out.println("[Request] " + customerName + " wants to buy " + quantity + " units of " + productName);

        // Synchronized block: synchronizes only the critical section on the lock object
        synchronized (lock) {
            System.out.println("  -> [Lock Acquired by " + customerName + "] Current stock: " + stockCount);

            if (quantity <= stockCount) {
                try {
                    Thread.sleep(100); // Simulate database update latency
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                stockCount -= quantity;
                System.out.println("  -> [Success] " + customerName + " purchased " + quantity + ". Remaining stock: " + stockCount);
            } else {
                System.out.println("  -> [Declined] Insufficient stock for " + customerName + "! Available: " + stockCount);
            }
            System.out.println("  -> [Lock Released by " + customerName + "]");
        }
    }

    public int getStockCount() {
        synchronized (lock) {
            return stockCount;
        }
    }

    public String getProductName() {
        return productName;
    }
}

public class Q08_InventoryManagementSyncBlock {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Thread Synchronization ---");
        System.out.println("--- Q8: Inventory Management using Synchronized Block ---\n");

        ProductInventory laptopInventory = new ProductInventory("MacBook Pro", 10);
        System.out.println("Initial Stock for " + laptopInventory.getProductName() + ": " + laptopInventory.getStockCount() + "\n");

        // Simulating multiple concurrent purchasing customer threads
        Thread c1 = new Thread(() -> laptopInventory.purchase("Customer-A (Ahsan)", 4));
        Thread c2 = new Thread(() -> laptopInventory.purchase("Customer-B (Zaid)", 3));
        Thread c3 = new Thread(() -> laptopInventory.purchase("Customer-C (Hamza)", 5));
        Thread c4 = new Thread(() -> laptopInventory.purchase("Customer-D (Faizan)", 2));

        // Start all customer threads
        c1.start();
        c2.start();
        c3.start();
        c4.start();

        // Wait for all threads to complete
        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted: " + e.getMessage());
        }

        System.out.println("\nFinal Stock Count for " + laptopInventory.getProductName() + ": " + laptopInventory.getStockCount());
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
