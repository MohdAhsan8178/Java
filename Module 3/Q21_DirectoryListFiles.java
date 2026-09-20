// Question 21: Listing All Files in a Directory: Write a Java program that lists all files in a directory specified by the user. The program should handle exceptions appropriately.

import java.io.File;

public class Q21_DirectoryListFiles {

    /**
     * Lists all files and subdirectories within a given directory path.
     *
     * @param directoryPath path to the target directory
     */
    public static void listFilesInDirectory(String directoryPath) {
        System.out.println("Inspecting Directory: " + directoryPath);
        System.out.println("--------------------------------------------------");

        try {
            File directory = new File(directoryPath);

            // Validation: Check if path exists
            if (!directory.exists()) {
                System.err.println("[ERROR] The specified path does not exist: " + directoryPath);
                return;
            }

            // Validation: Check if path is actually a directory
            if (!directory.isDirectory()) {
                System.err.println("[ERROR] The specified path is a file, not a directory: " + directoryPath);
                return;
            }

            // Retrieve directory contents
            File[] filesList = directory.listFiles();

            if (filesList == null) {
                System.err.println("[ERROR] Unable to access directory contents (I/O error or permission denied).");
                return;
            }

            if (filesList.length == 0) {
                System.out.println("[INFO] The directory is empty.");
                return;
            }

            System.out.printf("%-30s | %-10s | %-12s%n", "NAME", "TYPE", "SIZE (Bytes)");
            System.out.println("-------------------------------------------------------------");

            int fileCount = 0;
            int dirCount = 0;

            for (File item : filesList) {
                String type = item.isDirectory() ? "[DIR]" : "[FILE]";
                long size = item.isFile() ? item.length() : 0;
                System.out.printf("%-30s | %-10s | %-12d%n", item.getName(), type, size);

                if (item.isDirectory()) dirCount++;
                else fileCount++;
            }

            System.out.println("-------------------------------------------------------------");
            System.out.println("Total: " + fileCount + " files, " + dirCount + " subdirectories.");

        } catch (SecurityException e) {
            System.err.println("[SECURITY EXCEPTION] Read access denied to directory: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("[UNEXPECTED ERROR] " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 5: File Handling ---");
        System.out.println("--- Q21: Listing All Files in a Directory ---\n");

        // Example 1: Listing current directory
        listFilesInDirectory(".");

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
