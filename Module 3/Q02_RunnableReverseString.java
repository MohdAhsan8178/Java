// Question 2: Create a thread by implementing the Runnable interface that takes a string "MULTITHREADING" and prints its characters in reverse order one by one.

// Custom task implementing Runnable interface
class ReverseStringRunnable implements Runnable {
    private final String text;

    public ReverseStringRunnable(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        System.out.println("Reverse String Worker started for text: \"" + text + "\"");
        System.out.print("Characters in reverse order: ");

        // Iterating backwards through the string
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i) + " ");
            try {
                // Short delay to demonstrate step-by-step character printing
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("\nWorker thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\nWorker finished printing.");
    }
}

public class Q02_RunnableReverseString {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Thread Concepts and Implementation ---");
        System.out.println("--- Q2: Thread Creation via Runnable Interface ---\n");

        String sample = "MULTITHREADING";

        // Creating Runnable task and wrapping in a Thread object
        Runnable task = new ReverseStringRunnable(sample);
        Thread thread = new Thread(task, "ReverseStringThread");

        // Starting the thread
        thread.start();

        // Waiting for the thread to complete
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
