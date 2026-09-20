// Question 15: Reading File Using Byte Stream: Write a program that reads a text file using the FileInputStream and prints the contents to the console.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q15_FileInputStreamByteStream {
    public static void main(String[] args) {
        System.out.println("--- Section 4: I/O Streams: Byte Stream and Character Stream ---");
        System.out.println("--- Q15: Reading File using FileInputStream (Byte Stream) ---\n");

        String fileName = "sample_byte_input.txt";

        // Setup: Create a sample file first so it is guaranteed to exist
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            String initialData = "Hello from Java Byte Stream!\nFileInputStream reads data byte by byte (ASCII/Binary).";
            fos.write(initialData.getBytes());
        } catch (IOException e) {
            System.err.println("Setup failed: " + e.getMessage());
        }

        // Reading file contents using FileInputStream
        System.out.println("Reading contents from '" + fileName + "' byte by byte:\n--------------------------------------------------");
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int byteData;
            // fis.read() returns -1 when end of file (EOF) is reached
            while ((byteData = fis.read()) != -1) {
                // Cast byte value to char and print to console
                System.out.print((char) byteData);
            }
            System.out.println("\n--------------------------------------------------");
            System.out.println("File reading completed successfully.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // Clean up temporary sample file
            new File(fileName).delete();
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
