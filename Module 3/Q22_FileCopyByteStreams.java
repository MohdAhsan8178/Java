// Question 22: Copying a File: Create a program that copies the contents of one file to another using byte streams (FileInputStream and FileOutputStream).

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q22_FileCopyByteStreams {

    /**
     * Copies a source file to a destination file using byte streams with a buffer.
     *
     * @param sourcePath source file path
     * @param destPath   destination file path
     */
    public static void copyFile(String sourcePath, String destPath) {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        System.out.println("Source File      : " + sourceFile.getAbsolutePath());
        System.out.println("Destination File : " + destFile.getAbsolutePath());

        if (!sourceFile.exists()) {
            System.err.println("[ERROR] Source file does not exist!");
            return;
        }

        long startTime = System.currentTimeMillis();
        long totalBytesCopied = 0;

        // Byte streams: FileInputStream reads binary bytes, FileOutputStream writes them
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            // Using 4KB buffer for efficient block copying
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesCopied += bytesRead;
            }

            long duration = System.currentTimeMillis() - startTime;
            System.out.println("\n[SUCCESS] File copied successfully!");
            System.out.println("  - Total Bytes Copied : " + totalBytesCopied + " bytes");
            System.out.println("  - Time Taken         : " + duration + " ms");

        } catch (IOException e) {
            System.err.println("[ERROR] I/O Exception during file copy: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Section 5: File Handling ---");
        System.out.println("--- Q22: File Copying using Byte Streams ---\n");

        String src = "copy_source.txt";
        String dest = "copy_destination.txt";

        // Setup: Create a sample source file with data
        try (FileOutputStream fos = new FileOutputStream(src)) {
            String testContent = "This is the source file data for Java Assignment 3 (Module 3).\nByte stream copying works for both text and binary files.";
            fos.write(testContent.getBytes());
        } catch (IOException e) {
            System.err.println("Setup error: " + e.getMessage());
        }

        // Perform file copy
        copyFile(src, dest);

        // Verification & cleanup
        File dstFile = new File(dest);
        System.out.println("Verification -> Destination file exists: " + dstFile.exists() + " (Size: " + dstFile.length() + " bytes)");

        // Clean up temporary files
        new File(src).delete();
        dstFile.delete();

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
