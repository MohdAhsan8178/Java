// Question 5: Write a Java program that creates three threads: "Worker-1", "Worker-2", and "Worker-3". Assign different priorities and print messages from each thread showing their execution order.

class PriorityWorker implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.println("Started: " + current.getName() + " | Priority: " + current.getPriority());

        for (int i = 1; i <= 3; i++) {
            System.out.println("  " + current.getName() + " executing task step " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Completed: " + current.getName());
    }
}

public class Q05_ThreadNamingAndPriority {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Thread Concepts and Implementation ---");
        System.out.println("--- Q5: Thread Naming and Priority Demonstration ---\n");

        PriorityWorker worker = new PriorityWorker();

        // Creating three threads with custom names
        Thread thread1 = new Thread(worker, "Worker-1");
        Thread thread2 = new Thread(worker, "Worker-2");
        Thread thread3 = new Thread(worker, "Worker-3");

        // Assigning priorities (MIN_PRIORITY = 1, NORM_PRIORITY = 5, MAX_PRIORITY = 10)
        thread1.setPriority(Thread.MIN_PRIORITY);  // Priority 1
        thread2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        thread3.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        System.out.println("Thread Configured:");
        System.out.println("1. " + thread1.getName() + " -> Priority: " + thread1.getPriority() + " (MIN_PRIORITY)");
        System.out.println("2. " + thread2.getName() + " -> Priority: " + thread2.getPriority() + " (NORM_PRIORITY)");
        System.out.println("3. " + thread3.getName() + " -> Priority: " + thread3.getPriority() + " (MAX_PRIORITY)");
        System.out.println("\n--- Starting Thread Execution ---");

        // Starting all threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Waiting for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted: " + e.getMessage());
        }

        System.out.println("\nAll worker threads finished.");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
