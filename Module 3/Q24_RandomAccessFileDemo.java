// Question 24: Random Access File: Create a program that uses the RandomAccessFile class to read and write to specific positions within a file. The program should write some data at the beginning of the file, then overwrite part of it later.

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Q24_RandomAccessFileDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 5: File Handling ---");
        System.out.println("--- Q24: RandomAccessFile Read/Write and Overwrite Demo ---\n");

        String fileName = "random_access_demo.txt";

        try {
            // "rw" mode: opens for reading and writing
            try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {

                // Step 1: Write initial data at position 0
                String initialData = "Hello World! Java Programming is fun.";
                raf.writeBytes(initialData);
                System.out.println("[Step 1] Written initial data:");
                System.out.println("  \"" + initialData + "\"");
                System.out.println("  File pointer position: " + raf.getFilePointer() + " | File length: " + raf.length() + " bytes\n");

                // Step 2: Read back initial data from position 0
                raf.seek(0); // Move pointer back to beginning
                byte[] buffer1 = new byte[(int) raf.length()];
                raf.readFully(buffer1);
                System.out.println("[Step 2] Read from start after seek(0):");
                System.out.println("  \"" + new String(buffer1) + "\"\n");

                // Step 3: Seek to position 6 and overwrite "World" with "Ahsan"
                raf.seek(6);
                System.out.println("[Step 3] Moved pointer to index 6 (seek(6)). Overwriting with \"Ahsan\"...");
                raf.writeBytes("Ahsan");
                System.out.println("  File pointer after overwrite: " + raf.getFilePointer() + "\n");

                // Step 4: Seek to the end and append more text
                raf.seek(raf.length());
                raf.writeBytes(" [Module 3]");
                System.out.println("[Step 4] Appended \" [Module 3]\" at the end.\n");

                // Step 5: Read the final modified content
                raf.seek(0);
                byte[] finalBuffer = new byte[(int) raf.length()];
                raf.readFully(finalBuffer);
                System.out.println("[Step 5] Final modified content from start:");
                System.out.println("  \"" + new String(finalBuffer) + "\"");
            }

        } catch (IOException e) {
            System.err.println("[ERROR] RandomAccessFile I/O Error: " + e.getMessage());
        } finally {
            // Clean up temporary demonstration file
            new File(fileName).delete();
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
