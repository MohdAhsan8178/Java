// Question 19: Buffered I/O: Modify the previous FileReader and FileWriter examples to use BufferedReader and BufferedWriter respectively to read from and write to the file, improving performance.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q19_BufferedReadWritePerformance {
    public static void main(String[] args) {
        System.out.println("--- Section 4: I/O Streams: Byte Stream and Character Stream ---");
        System.out.println("--- Q19: High-Performance Buffered I/O (BufferedReader & BufferedWriter) ---\n");

        String fileName = "buffered_example.txt";

        // PART 1: Writing with BufferedWriter (Buffers characters for batch write)
        System.out.println("1. Writing multiple lines using BufferedWriter to '" + fileName + "'...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Line 1: Java Buffered I/O provides high-efficiency data caching.");
            bw.newLine(); // Platform-independent newline
            bw.write("Line 2: BufferedReader reads full lines with readLine().");
            bw.newLine();
            bw.write("Line 3: BufferedWriter minimizes physical disk I/O operations.");
            System.out.println("   [SUCCESS] Successfully written buffered data.");
        } catch (IOException e) {
            System.err.println("Write error: " + e.getMessage());
        }

        // PART 2: Reading with BufferedReader (Reads line-by-line efficiently)
        System.out.println("\n2. Reading lines from '" + fileName + "' using BufferedReader:\n--------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            int lineNumber = 1;
            while ((currentLine = br.readLine()) != null) {
                System.out.println("  [" + lineNumber++ + "] " + currentLine);
            }
            System.out.println("--------------------------------------------------");
            System.out.println("   [SUCCESS] Buffered reading completed.");
        } catch (IOException e) {
            System.err.println("Read error: " + e.getMessage());
        } finally {
            // Clean up test file
            new File(fileName).delete();
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
