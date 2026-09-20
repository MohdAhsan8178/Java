// Question 4: Write a program where one thread prints a countdown from 10 to 1 (1-second delay), while another thread simultaneously prints "Tick..." every half a second.

public class Q04_CountdownTimerThreads {
    // Shared flag to control the ticker thread when countdown finishes
    private static volatile boolean running = true;

    public static void main(String[] args) {
        System.out.println("--- Section 1: Thread Concepts and Implementation ---");
        System.out.println("--- Q4: Countdown Timer with Simultaneous Tick Thread ---\n");

        // Countdown Thread: 10 down to 1 with 1000ms delay
        Thread countdownThread = new Thread(() -> {
            for (int i = 10; i >= 1; i--) {
                System.out.println(">>> COUNTDOWN: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Countdown interrupted.");
                    break;
                }
            }
            System.out.println(">>> LIFTOFF / TIME'S UP!");
            running = false; // Signal ticker thread to stop
        }, "CountdownThread");

        // Ticker Thread: prints "Tick..." every 500ms
        Thread tickThread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(500);
                    if (running) {
                        System.out.println("   [Timer] Tick...");
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "TickThread");

        // Start both threads
        tickThread.start();
        countdownThread.start();

        // Wait for countdown thread to finish
        try {
            countdownThread.join();
            tickThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted: " + e.getMessage());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
