// Question 20: File Existence Check: Write a program that checks if a file exists in the system. If the file does not exist, create the file using the File class.

import java.io.File;
import java.io.IOException;

public class Q20_FileExistenceAndCreation {
    public static void main(String[] args) {
        System.out.println("--- Section 5: File Handling ---");
        System.out.println("--- Q20: File Existence Check and Creation ---\n");

        String filePath = "test_file.txt";
        File file = new File(filePath);

        System.out.println("Target File Path: " + file.getAbsolutePath());

        // Checking if file exists
        if (file.exists()) {
            System.out.println("Status: The file ALREADY exists in the file system.");
            System.out.println("File Size: " + file.length() + " bytes");
        } else {
            System.out.println("Status: File does NOT exist. Attempting to create it...");
            try {
                // Creates a new, empty file named by this abstract pathname if it does not exist
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("[SUCCESS] New file '" + file.getName() + "' created successfully!");
                } else {
                    System.out.println("[INFO] File was already created concurrently.");
                }
            } catch (IOException e) {
                System.err.println("[ERROR] Failed to create file: " + e.getMessage());
            }
        }

        // Displaying file metadata
        System.out.println("\nFile Metadata:");
        System.out.println("  - Name         : " + file.getName());
        System.out.println("  - Is File      : " + file.isFile());
        System.out.println("  - Is Directory : " + file.isDirectory());
        System.out.println("  - Can Read     : " + file.canRead());
        System.out.println("  - Can Write    : " + file.canWrite());

        // Clean up test file
        if (file.exists()) {
            file.delete();
            System.out.println("\n(Cleaned up temporary file after demonstration)");
        }

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
