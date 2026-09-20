// Question 17: Reading a File Using Character Stream: Write a program that reads a file using the FileReader class and prints the contents of the file to the console.

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q17_FileReaderCharacterStream {
    public static void main(String[] args) {
        System.out.println("--- Section 4: I/O Streams: Byte Stream and Character Stream ---");
        System.out.println("--- Q17: Reading File using FileReader (Character Stream) ---\n");

        String fileName = "sample_char_input.txt";

        // Setup: Create a sample text file using character writer
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Welcome to Java Character Streams!\nFileReader reads data 16-bit Unicode characters at a time.");
        } catch (IOException e) {
            System.err.println("Setup error: " + e.getMessage());
        }

        // Reading file contents using FileReader
        System.out.println("Reading contents from '" + fileName + "' using FileReader:\n--------------------------------------------------");
        try (FileReader fr = new FileReader(fileName)) {
            int charCode;
            // fr.read() returns character code as int, or -1 at EOF
            while ((charCode = fr.read()) != -1) {
                System.out.print((char) charCode);
            }
            System.out.println("\n--------------------------------------------------");
            System.out.println("Character stream reading completed successfully.");
        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        } finally {
            // Clean up temporary sample file
            new File(fileName).delete();
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
