// Question 16: Writing to a File Using Byte Stream: Create a program that writes a string into a file using the FileOutputStream. Ensure that the program writes the string "Java I/O Streams Example" to a file named output.txt.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q16_FileOutputStreamByteStream {
    public static void main(String[] args) {
        System.out.println("--- Section 4: I/O Streams: Byte Stream and Character Stream ---");
        System.out.println("--- Q16: Writing to File using FileOutputStream ---\n");

        String fileName = "output.txt";
        String contentToWrite = "Java I/O Streams Example";

        System.out.println("Target File: " + fileName);
        System.out.println("Content    : \"" + contentToWrite + "\"\n");

        // Writing string into file using FileOutputStream
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            // Convert String to byte array and write
            byte[] bytes = contentToWrite.getBytes();
            fos.write(bytes);
            System.out.println("[SUCCESS] Successfully written " + bytes.length + " bytes to '" + fileName + "'.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Verification: Read back the file to confirm contents
        System.out.println("\n--- Verifying Content from '" + fileName + "' ---");
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int b;
            System.out.print("File Content: \"");
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
            System.out.println("\"");
        } catch (IOException e) {
            System.err.println("Error reading verification file: " + e.getMessage());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
