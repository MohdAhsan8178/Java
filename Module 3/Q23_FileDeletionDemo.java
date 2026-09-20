// Question 23: Deleting a File: Write a Java program that deletes a file from the system using the File class.

import java.io.File;
import java.io.IOException;

public class Q23_FileDeletionDemo {
    public static void main(String[] args) {
        System.out.println("--- Section 5: File Handling ---");
        System.out.println("--- Q23: File Deletion using File Class ---\n");

        String targetFileName = "delete_me.txt";
        File file = new File(targetFileName);

        // Step 1: Create the file first so we have a concrete file to delete
        try {
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println("[Step 1] Created sample file: " + file.getName());
            } else {
                System.out.println("[Step 1] File already existed: " + file.getName());
            }
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to create file: " + e.getMessage());
            return;
        }

        System.out.println("Current File Status -> Exists: " + file.exists() + " | Path: " + file.getAbsolutePath());

        // Step 2: Delete the file using File.delete()
        System.out.println("\n[Step 2] Attempting to delete the file...");
        boolean isDeleted = file.delete();

        if (isDeleted) {
            System.out.println("[SUCCESS] The file '" + targetFileName + "' was successfully deleted from disk.");
        } else {
            System.out.println("[FAILED] Could not delete the file. (Check permissions or if file is in use).");
        }

        // Step 3: Verify deletion
        System.out.println("\n[Step 3] Post-deletion verification:");
        System.out.println("File exists check: " + file.exists());

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
