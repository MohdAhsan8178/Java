// Question 12: Stopping a Thread: Write a program that simulates a file download in a thread (printing "Downloading chunk X"). Allow the download to stop gracefully when a stop flag is set to false.

class FileDownloader implements Runnable {
    // Volatile flag ensures immediate visibility across threads
    private volatile boolean isRunning = true;

    // Graceful stop method
    public void stopDownload() {
        System.out.println("\n[USER ACTION] Stop signal sent to downloader!");
        this.isRunning = false;
    }

    @Override
    public void run() {
        System.out.println("Download thread started...");
        int chunk = 1;

        // Thread loops while isRunning flag is true
        while (isRunning && chunk <= 10) {
            System.out.println("Downloading chunk " + chunk + " / 10 (10% completed)...");
            chunk++;
            try {
                // Simulate chunk download time
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Download interrupted during sleep.");
                break;
            }
        }

        if (!isRunning) {
            System.out.println("Download stopped gracefully before completing all chunks.");
            System.out.println("Cleaned up partial download temporary buffers.");
        } else {
            System.out.println("Download finished 100% successfully!");
        }
    }
}

public class Q12_GracefulThreadStopDownload {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Thread Synchronization ---");
        System.out.println("--- Q12: Graceful Thread Termination Demonstration ---\n");

        FileDownloader downloader = new FileDownloader();
        Thread downloadThread = new Thread(downloader, "DownloadThread");

        // Start the download thread
        downloadThread.start();

        // Let the download proceed for 1.5 seconds (downloads chunks 1 to 4)
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Gracefully signal the thread to stop
        downloader.stopDownload();

        // Wait for thread to finish its graceful exit
        try {
            downloadThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main join interrupted.");
        }

        System.out.println("\nProgram terminated cleanly.");
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
