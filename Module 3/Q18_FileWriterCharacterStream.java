// Question 18: Writing to a File Using Character Stream: Write a program that writes a string to a file using the FileWriter class. The string should be written to a file named example.txt.

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q18_FileWriterCharacterStream {
    public static void main(String[] args) {
        System.out.println("--- Section 4: I/O Streams: Byte Stream and Character Stream ---");
        System.out.println("--- Q18: Writing to File using FileWriter ---\n");

        String fileName = "example.txt";
        String content = "Character Streams in Java handle Unicode text data efficiently using FileWriter.";

        System.out.println("Target File: " + fileName);
        System.out.println("Content    : \"" + content + "\"\n");

        // Writing string directly to file using FileWriter
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(content);
            System.out.println("[SUCCESS] Successfully written string to '" + fileName + "' using FileWriter.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Verifying content by reading back
        System.out.println("\n--- Verifying Content from '" + fileName + "' ---");
        try (FileReader fr = new FileReader(fileName)) {
            int c;
            System.out.print("File Content: \"");
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println("\"");
        } catch (IOException e) {
            System.err.println("Error reading verification file: " + e.getMessage());
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
