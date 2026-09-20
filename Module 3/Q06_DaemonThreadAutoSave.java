// Question 6: Write a Java program where a daemon thread continuously writes "Auto-Save in progress..." every 3 seconds, while the main thread performs a file processing task.

public class Q06_DaemonThreadAutoSave {
    public static void main(String[] args) {
        System.out.println("--- Section 1: Thread Concepts and Implementation ---");
        System.out.println("--- Q6: Daemon Thread Auto-Save Simulation ---\n");

        // Creating the background auto-save thread
        Thread autoSaveThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000); // Wait 3 seconds between auto-saves
                    System.out.println("  [DAEMON] Auto-Save in progress... Data backed up to disk.");
                } catch (InterruptedException e) {
                    System.out.println("Auto-save daemon interrupted.");
                    break;
                }
            }
        }, "AutoSaveDaemon");

        // Mark this thread as a Daemon thread (JVM terminates it automatically when all user threads finish)
        autoSaveThread.setDaemon(true);
        System.out.println("AutoSave thread isDaemon: " + autoSaveThread.isDaemon());

        // Start daemon thread
        autoSaveThread.start();

        // Main thread performing a simulated file processing task
        System.out.println("Main Thread: Starting intensive file processing task...");
        for (int step = 1; step <= 4; step++) {
            System.out.println("Main Thread: Processing large data block " + step + " of 4...");
            try {
                // Simulate work taking 2.5 seconds per step (total ~10 seconds)
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                System.out.println("Main processing interrupted: " + e.getMessage());
            }
        }

        System.out.println("Main Thread: File processing completed successfully!");
        System.out.println("Main Thread exiting... (Daemon thread will terminate automatically)");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
